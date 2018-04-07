package com.example.android.musicapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView(R.layout.category_list);

        // Create a list of categories
        ArrayList<Categories> categories = new ArrayList<Categories>();
        categories.add(new Categories (getString(R.string.cat_chill)));
        categories.add(new Categories (getString(R.string.cat_energetic)));
        categories.add(new Categories (getString(R.string.cat_filmM)));

        ListView listView = (ListView) findViewById(R.id.category_list);
        listView.setBackgroundResource(R.drawable.background_music_appp);

        CategoriesAdapter adapter = new CategoriesAdapter(this, categories);
        listView.setAdapter(adapter);

        // Set OnClickListener on ListView
        listView.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        final Context context = this;

        TextView textView = (TextView) view.findViewById(R.id.category_text_view);
        String playlistText = textView.getText().toString();

        Intent intent = new Intent(context, SongsListActivity.class);
        intent.putExtra("message", playlistText);
        startActivity(intent);
    }
}