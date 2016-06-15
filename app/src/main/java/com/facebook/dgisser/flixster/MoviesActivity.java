package com.facebook.dgisser.flixster;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MoviesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        // Retrieve movies
        ArrayList<Movie> movies = Movie.getMovies(this.getApplicationContext());
        // Generate ListView to populate
        ListView lvMovies = (ListView) findViewById(R.id.lvMovies);
        // Create ArrayAdapter
        //ArrayAdapter<Movie> adapter = new ArrayAdapter<Movie>(this, android.R.layout.simple_list_item_1, movies);
        MoviesAdapter adapter = new MoviesAdapter(this, movies);
        // Associate ArrayAdapter with ListView
        if (lvMovies != null) {
            lvMovies.setAdapter(adapter);
        }
    }
}
