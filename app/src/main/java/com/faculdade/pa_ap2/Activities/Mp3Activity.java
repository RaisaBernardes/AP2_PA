package com.faculdade.pa_ap2.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.faculdade.libdownloadmanager.DownloadFacade;
import com.faculdade.pa_ap2.R;

public class Mp3Activity extends AppCompatActivity {

    private String vamoLa = "Downloadando...";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp3_activity);

        DownloadFacade.getInstance().getDownloadController().download(this, vamoLa);


    }
}
