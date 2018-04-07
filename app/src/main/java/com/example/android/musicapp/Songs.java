package com.example.android.musicapp;

/**
 * Created by Miszka on 2018-04-07.
 */

public class Songs {

    //String with Artists
    private String mArtist;

    //String with Titles
    private String mSongTitle;

    //Create a new Categories object.
    public Songs(String Artist, String Title) {
        mArtist = Artist;
        mSongTitle = Title;
    }
    //Get name of Artists
    public String getArtists() {
        return mArtist;
    }

    //Get Title of song
    public String getSongTitle() {
        return mSongTitle;
    }
}