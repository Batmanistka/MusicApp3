package com.example.android.musicapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Miszka on 2018-04-07.
 */

public class SongsListActivity extends AppCompatActivity implements ListView.OnItemClickListener {

    private String mIntentMessage;
    private String mSongsCategory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView(R.layout.songs_list);

        Bundle bundle = getIntent().getExtras();
        mIntentMessage = bundle.getString("message");

        // Display list of songs from chosen category
        createSongsList();
    }

    // Create a list of songs
    public void createSongsList () {
        ArrayList<Songs> songs = new ArrayList<Songs>();

        if (mIntentMessage.equals("Chill Out")) {
            mSongsCategory = getString(R.string.cat_chill);
            songs.add(new Songs("Cafe del Mar", "Music Mix 12"));
            songs.add(new Songs("Coccolino Deep", "Dont forget to fly"));
            songs.add(new Songs("Infinite", "Ambient Mix"));
        }

        else if (mIntentMessage.equals(getString(R.string.cat_energetic))) {
            mSongsCategory = getString(R.string.cat_energetic);
            songs.add(new Songs("Bbbb", "Bbbb"));
            songs.add(new Songs("Bbbbbbb", "Bbbbbbbb"));
            songs.add(new Songs("Bbbbbbbbbbb", "Bbbbbbbbbb"));
        }

        else if (mIntentMessage.equals(getString(R.string.cat_filmM))) {
            mSongsCategory = getString(R.string.cat_filmM);
            songs.add(new Songs("Ccc", "Ccc"));
            songs.add(new Songs("Cccc", "Cccc"));
            songs.add(new Songs("Cccccc", "Cccccc"));
        }

        ListView listView = (ListView) findViewById(R.id.songs_list);
        listView.setBackgroundResource(R.drawable.background_music_appp);

        SongsAdapter adapter = new SongsAdapter(this, songs);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        final Context context = this;
        String intentExtra = "";

        TextView textViewArtist = (TextView) view.findViewById(R.id.artist_text_view);
        String artist = textViewArtist.getText().toString();

        TextView textViewTitle = (TextView) view.findViewById(R.id.title_text_view);
        String title = textViewTitle.getText().toString();

        intentExtra = mSongsCategory + System.getProperty("line.separator") +
        artist + System.getProperty("line.separator") + title;
        Intent i = new Intent(context, PlaySongActivity.class);
        i.putExtra("message", intentExtra);
        startActivity(i);
    }
}