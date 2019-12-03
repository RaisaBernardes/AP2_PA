package com.faculdade.libdownloadmanager;

import android.Manifest;
import android.app.DownloadManager;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.File;

public class DownloadService extends Service {

    private final int REQUEST_CODE = 1;

    private Looper serviceLooper;
    private ServiceHandler serviceHandler;

    private void download(String url, String name, String type) {

        // Apenas para ter certeza de permissão da internet para uso em testes
        if (checkSelfPermission(Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED) {
            Log.println(Log.INFO, "PERMISSION", "INTERNET permission granted");
        } else {
            Log.println(Log.INFO, "INTERNET PERMISSION", "INTERNET permission refused");
        }

        // Apenas para ter certeza de permissão da escrita para uso em testes
        if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            Log.println(Log.INFO, "PERMISSION", "WRITE_EXTERNAL_STORAGE permission granted");
        } else {
            Log.println(Log.INFO, "PERMISSION", "WRITE_EXTERNAL_STORAGE permission refused");
        }

        // Preparando parâmetros para download
        Uri uriURL = Uri.parse(url);
        String formattedType;
        if (type.charAt(0) == '.') {
            formattedType = type;
        } else {
            formattedType = '.' + type;
        }

        // Preparação do arquivo (local de salvamento, nome e extensão)
//        File file = new File(Environment.getExternalStorageDirectory(), Environment.DIRECTORY_DOWNLOADS + File.separator + "pa_ap2" + formattedType);
        File file = new File(Environment.getExternalStorageDirectory(), DirectoryTypeHelper.giveDirectoryType(formattedType) + File.separator + name + formattedType);

        DownloadManager.Request request = new DownloadManager.Request(uriURL)
                .setDestinationUri(Uri.fromFile(file))
                .setTitle(name)
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

        DownloadManager downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        downloadManager.enqueue(request);



        Log.println(Log.INFO, "DOWNLOADING URL", url);
    }

    // Handler that receives messages from the thread
    private final class ServiceHandler extends Handler {
        public ServiceHandler(Looper looper) {
            super(looper);
        }
        @Override
        public void handleMessage(Message msg) {
            // Normally we would do some work here, like download a file.

            String url = msg.getData().getString("url");
            String name = msg.getData().getString("name");
            String type = msg.getData().getString("type");
            Log.println(Log.INFO, "DOWNLOAD THREAD", "arg1: " + msg.arg1 + ";\n url: " + url + ";\n type: " + type);
            download(url, name, type);

            // Stop the service using the startId, so that we don't stop
            // the service in the middle of handling another job
            stopSelf(msg.arg1);
        }
    }

    @Override
    public void onCreate() {
        // Start up the thread running the service. Note that we create a
        // separate thread because the service normally runs in the process's
        // main thread, which we don't want to block. We also make it
        // background priority so CPU-intensive work doesn't disrupt our UI.
        HandlerThread thread = new HandlerThread("ServiceStartArguments",
                Process.THREAD_PRIORITY_BACKGROUND);
        thread.start();

        // Toast.makeText(this, "This message will only appear once", Toast.LENGTH_LONG).show();

        // Get the HandlerThread's Looper and use it for our Handler
        serviceLooper = thread.getLooper();
        serviceHandler = new ServiceHandler(serviceLooper);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Aqui é feito o pedido do download

        String url = intent.getExtras().getString("url");
        String name = intent.getExtras().getString("name");
        String type = intent.getExtras().getString("type");
        Log.println(Log.INFO, "STARTING DOWNLOAD", url + "; " + type);

        // Construindo mensagem
        Message message = serviceHandler.obtainMessage();
        message.arg1 = startId;
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        bundle.putString("name", name);
        bundle.putString("type", type);
        message.setData(bundle);
//        Log.println(Log.INFO, "MESSAGE CONTENT", message.arg1 + "; " + message.getData().getString("url"));

        // Enviando mensagem
        serviceHandler.sendMessage(message);
        Toast.makeText(this, R.string.starting_download, Toast.LENGTH_LONG).show();

        return START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.println(Log.INFO, "FINISHING DOWNLOAD", "download thread finished (it DOES NOT GRANT successful download!)");
    }
}
