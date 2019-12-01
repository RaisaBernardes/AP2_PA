package com.faculdade.pa_ap2.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.faculdade.pa_ap2.R;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.os.Environment.getExternalStoragePublicDirectory;

public class NewContactActivity extends AppCompatActivity {

    private TextView aCancelButton;
    private ImageView aCameraButton;
    private ImageView aImageView;
    private String aPathToFile;

    //TODO: logic of all 3 fields, camera button and save button. 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);

        aCancelButton = findViewById(R.id.cancel_button);
        aCameraButton = findViewById(R.id.photo_button);
        aImageView = findViewById(R.id.image);

        //Asking for permission to access camera
        if(Build.VERSION.SDK_INT >= 23){
            requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2);
            showToast("Version less than Marshmallow");
        }else {
            showToast("Version greater than Marshmallow");
        }



       //PHOTO BUTTON: Accessing Camera
        aCameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeAPictureAction();
            }
        });

        //CANCEL BUTTON: Going back to previous Activity
        aCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        }

        protected void onActivityResult(int requestCode, int resultCode, Intent data){
            super.onActivityResult(requestCode, resultCode, data);
            if(resultCode == RESULT_OK){
                if(requestCode == 1){
                    Bitmap bitmap = BitmapFactory.decodeFile(aPathToFile);
                    aImageView.setImageBitmap(bitmap);
                }
            }
        }

        //Toast message
        private void showToast(String msg){
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        }

        private void takeAPictureAction(){
        Intent takePic = new Intent("android.media.action.IMAGE_CAPTURE");
        if(takePic.resolveActivity(getPackageManager()) != null){
            File photoFile = null; //This is the file where our photo will be stored
            photoFile = createPhotoFile();

            if(photoFile != null) {
                aPathToFile = photoFile.getAbsolutePath(); //We have the path to our file in the variable "pathToFile"
                Uri photoUri = FileProvider.getUriForFile(NewContactActivity.this, "${applicationId}.provider", photoFile);
                takePic.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                startActivityForResult(takePic, 1);
            }

        }
        }

        //Creating the file where the photo will be stored
        private File createPhotoFile(){
        String name = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File storageDir = getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File image = null;
        try{
           image = File.createTempFile(name, ".jpg", storageDir); //Actually creating the file
        }
        catch(IOException e){
            Log.d("mylog", "Exception: " + e.toString());
        }
        return image;
        }

}
