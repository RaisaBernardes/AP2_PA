package com.faculdade.pa_ap2.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.faculdade.pa_ap2.R;

public class ContactsActivity extends AppCompatActivity {

    private ImageView aAddContact;

    //TODO: SearchField, ScrollView and logic of scrollView item to Contact Details Activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        aAddContact = findViewById(R.id.addContactButton);

        //Navigating between ContactActivity and NewContactActivity
        aAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ContactsActivity.this, NewContactActivity.class));
            }
        });
    }
}
