package com.faculdade.pa_ap2.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.faculdade.pa_ap2.R;

public class NewContactActivity extends AppCompatActivity {

    private TextView aCancelButton;
    private ImageView aCameraButton;

    //TODO: logic of all 3 fields, camera button and save button. 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);

        aCancelButton = findViewById(R.id.cancel_button);
        aCameraButton = findViewById(R.id.photo_button);

        //Going back to previous activity
        aCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

       /*//Accessing camera
        aCameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });*/



    }

    //Ask for permission to access camera
    public void checkPermission(View view){

    }
}
