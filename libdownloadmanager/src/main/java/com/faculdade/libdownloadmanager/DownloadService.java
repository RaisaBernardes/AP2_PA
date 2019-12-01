package com.faculdade.libdownloadmanager;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DownloadService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // TODO download
        String url = intent.getExtras().getString("url");
        Toast.makeText(getApplicationContext(), url, Toast.LENGTH_LONG).show();

        return START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
