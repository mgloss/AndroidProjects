package cz.activate.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Michaela on 5/18/2018.
 */

public class SongActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);

        // create an array od words
        ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song("song one", "Gil"));
        songs.add(new Song("song two", "Jackson"));
        songs.add(new Song("three", "tři"));
        songs.add(new Song("four", "čtyři"));
        songs.add(new Song("five", "pět"));
        songs.add(new Song("six", "šest"));


        SongAdapter adapter = new SongAdapter(this, songs);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(adapter);

        //TextView oneSong = findViewById(R.id.list_name);
        //oneSong.setOnClickListener(new View.OnClickListener(){
        //    @Override
        //    public void onClick(View view) {
        //        Intent intent = new Intent(SongActivity.this, PlayActivity.class);
        //        startActivity(intent);
        //    }
        //});
    }
}



