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

public class CategoriesAdapter extends ArrayAdapter {

    public CategoriesAdapter(Context context, ArrayList<Categories> pCategories) {
        super(context, 0, pCategories);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_main, parent, false);
        }
        Categories my_categories = (Categories) getItem(position);
        TextView categoryTextView = (TextView) listItemView.findViewById(R.id.category_text_view);
        categoryTextView.setText(my_categories.getCategories());

        return listItemView;
    }
}
