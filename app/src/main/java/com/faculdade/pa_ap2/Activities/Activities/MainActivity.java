package com.faculdade.pa_ap2.Activities.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.faculdade.pa_ap2.R;

public class MainActivity extends AppCompatActivity {

    private ImageView aContactsButton;
    private ImageView aMp3Button;
    private ImageView aVideosButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Binding variables to layout views/buttons
        aContactsButton = findViewById(R.id.contacts_button);
        aMp3Button = findViewById(R.id.mp3_button);
        aVideosButton = findViewById(R.id.videos_button);


        //----- Navigating between activities -----

        //MainActivity to ContactActivity
        aContactsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ContactsActivity.class));
            }
        });


        //MainActivity to Mp3Activity
        aMp3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Mp3Activity.class));
            }
        });

        //MainActivity to VideosActivity
        aVideosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, VideosActivity.class));
            }
        });

    }
}
