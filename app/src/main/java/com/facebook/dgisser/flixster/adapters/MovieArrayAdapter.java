package com.facebook.dgisser.flixster.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.facebook.dgisser.flixster.models.Movie;

import java.util.List;

/**
 * Created by dgisser on 6/16/16.
 */
public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    public MovieArrayAdapter(Context context, List<Movie> movies){
        super(context, android.R.layout.simple_list_item_1, movies);
    }
}
