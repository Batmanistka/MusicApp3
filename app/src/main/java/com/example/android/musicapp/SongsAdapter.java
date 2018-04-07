package com.example.android.musicapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Miszka on 2018-04-07.
 */

public class SongsAdapter extends ArrayAdapter {

    public SongsAdapter(Context context, ArrayList<Songs> pSongs) {
        super(context, 0, pSongs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_songs_list, parent, false);
        }

        Songs my_song = (Songs) getItem(position);
        TextView artistTextView = (TextView) listItemView.findViewById(R.id.artist_text_view);
        artistTextView.setText(my_song.getArtists());
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title_text_view);
        titleTextView.setText(my_song.getSongTitle());

        return listItemView;
    }
}