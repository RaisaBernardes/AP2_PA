package com.faculdade.pa_ap2.Activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.faculdade.pa_ap2.R;

public class VideosActivity extends AppCompatActivity {

    ListView list;
    String titles[] = {"Title 1", "Title 2", "Title 3", "Title 4"};
    String sources[] = {"Source 1", "Source 2", "Source 3", "Source 4"};

    //The images are from drawable
    int imgs[] = {R.drawable.teste_imagem_musica, R.drawable.teste_imagem_musica, R.drawable.teste_imagem_musica, R.drawable.teste_imagem_musica};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos_activity);

        list = findViewById(R.id.listView_songs);

        //Creating instance of a class MyAdapter
        MyAdapter adapter = new MyAdapter(this, titles, imgs, sources);

        //set Adapter to list
        list.setAdapter(adapter);

        //handle item clicks
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0){
                    Toast.makeText(VideosActivity.this, "TESTING! Item 1 clicked...", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }//closing onCreate
    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String myTitles[];
        String mySources[];
        int [] imgs;

        MyAdapter(Context c, String[] titles, int[] imgs, String [] sources){
            super(c, R.layout.row_listview, R.id.text_title, titles);
            this.context = c;
            this.imgs = imgs;
            this.myTitles = titles;
            this.mySources = sources;
        }

        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){

            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row_listView = layoutInflater.inflate(R.layout.row_listview, parent, false);
            ImageView images = row_listView.findViewById(R.id.photo_album);
            TextView myTitle = row_listView.findViewById(R.id.text_title);
            TextView mySources = row_listView.findViewById(R.id.text_source);
            images.setImageResource(imgs[position]);
            myTitle.setText(titles[position]);
            mySources.setText(sources[position]);

            return row_listView;
        }
    }

}
