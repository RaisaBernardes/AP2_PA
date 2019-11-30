package com.faculdade.pa_ap2.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.faculdade.pa_ap2.R;

public class NewContactActivity extends AppCompatActivity {

    private TextView cancelButton;

    //TODO: logic of all 3 fields, camera button and save button. 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);

        cancelButton = findViewById(R.id.cancel_button);

        //Going back to previous activity
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
