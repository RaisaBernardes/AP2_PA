package com.faculdade.pa_ap2.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.faculdade.libdownloadmanager.DownloadFacade;
import com.faculdade.pa_ap2.R;

public class Mp3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp3_activity);

        DownloadFacade.getInstance().getDownloadController()
                .download(this, "https://www.infoescola.com/wp-content/uploads/2017/07/baleia-azul-565369243.jpg", "jpg");
                //Obs.: The activity is already a context!


    }
}
