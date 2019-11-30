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


        //CANCEL BUTTON: Going back to previous Activity
        aCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        if(Build.VERSION.SDK_INT >= 23){
            requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2);
        }

       //Accessing camera
        aCameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeAPictureAction();
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

        private void takeAPictureAction(){
        Intent takePic = new Intent (MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePic.resolveActivity(getPackageManager()) != null){
            File photoFile = null;
            photoFile = createPhotoFile();

            if(photoFile != null) {
                aPathToFile = photoFile.getAbsolutePath(); //We have the path to our file in the variable "pathToFile"
                Uri photoUri = FileProvider.getUriForFile(NewContactActivity.this, "com.faculdade.PA_AP2.fileprovider", photoFile);
                takePic.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                startActivityForResult(takePic, 1);
            }

        }
        }

        private File createPhotoFile(){
        String name = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File storageDir = getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File image = null;

        try{
            image = File.createTempFile(name, ".jpg", storageDir);
        }
        catch(IOException e){
            Log.d("mylog", "Exception: " + e.toString());
        }
        return image;
        }

}
