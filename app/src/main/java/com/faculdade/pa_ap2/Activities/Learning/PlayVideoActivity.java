package com.faculdade.pa_ap2.Activities.Learning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.faculdade.pa_ap2.R;

import java.io.File;

public class PlayVideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);

        VideoView v  = new VideoView(this);
        setContentView(v);

        File sdcarDir = android.os.Environment.getExternalStorageDirectory();
        File file = new File(sdcarDir, ""); //TODO: Put the source and the name of the file

        String path = file.getAbsolutePath();
        v.setVideoPath(path); //This command actually reproduce the video
        v.setMediaController(new MediaController(this)); //This command informs the MediaController
        v.requestFocus();

    }

}
