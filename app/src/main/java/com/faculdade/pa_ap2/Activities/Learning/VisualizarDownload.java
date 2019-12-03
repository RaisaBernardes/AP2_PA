package com.faculdade.pa_ap2.Activities.Learning;

import android.app.Activity;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.VideoView;

import com.faculdade.pa_ap2.R;

public class VisualizarDownload extends Activity {

    //TODO: This is a class to get the image after download by clicking the notification. Implementation by the book!

    private static final String CATEGORIA = "album";

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        Log.i(CATEGORIA,"VisualizarDownload > onCreate()");
        ImageView imageView = new ImageView(this);
        setContentView(imageView);

        byte[] bytesImage = getIntent().getExtras().getByteArray("image");
        Log.i(CATEGORIA, "VisualizarDownload > Criando a imagem");
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytesImage, 0, bytesImage.length);
        Log.i(CATEGORIA, "Video: " + imageView);
        imageView.setImageBitmap(bitmap);
        Log.i(CATEGORIA, "VisualizarDownload > Cancelando notificação...");
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        nm.cancel(R.string.app_name);
        Log.i(CATEGORIA, "VisualizarDownload > Fim.");
    }
}
