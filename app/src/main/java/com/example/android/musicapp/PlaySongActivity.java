package com.example.android.musicapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class PlaySongActivity extends AppCompatActivity {

    private TextView mTextTitle;
    private String mIntentMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);

        mTextTitle = (TextView) findViewById(R.id.title_ps_TextView);

        getSupportActionBar().setTitle("Play Song");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Display intent message - title, artist and category
        Bundle bundle = getIntent().getExtras();
        mIntentMessage = bundle.getString("message");
        mTextTitle.setText(mIntentMessage);
    }
}
