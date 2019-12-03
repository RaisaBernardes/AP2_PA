package com.faculdade.pa_ap2.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.faculdade.libdownloadmanager.DownloadFacade;
import com.faculdade.pa_ap2.R;

public class TestLibActivity extends AppCompatActivity {
    private Button aDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_lib);

        aDownload = findViewById(R.id.aDownload);
        aDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DownloadFacade.getInstance().getDownloadController()
                        .download(view.getContext(), "https://www.infoescola.com/wp-content/uploads/2017/07/baleia-azul-565369243.jpg", ".jpg");
            }
        });
    }
}
