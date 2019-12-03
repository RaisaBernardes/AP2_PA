package com.faculdade.pa_ap2.Activities.Learning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.faculdade.pa_ap2.R;

public class ContactDetailsActivity extends AppCompatActivity {

    private ImageView arrowBack;

    //TODO: Logic of ScrollView item to this Activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);

        arrowBack = findViewById(R.id.arrowBack_contactDetails);

        //Going back to Contact Activity
        arrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
