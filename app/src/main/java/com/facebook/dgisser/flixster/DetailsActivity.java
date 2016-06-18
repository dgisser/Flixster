package com.facebook.dgisser.flixster;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RatingBar;
import android.widget.TextView;


/**
 * Created by dgisser on 6/17/16.
 */
public class DetailsActivity extends AppCompatActivity {
    TextView tvTitle;
    RatingBar rbMovie;
    TextView tvPopularity;
    TextView tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        rbMovie = (RatingBar) findViewById(R.id.rbMovie);
        tvPopularity = (TextView) findViewById(R.id.tvPopularity);
        tvDescription = (TextView) findViewById(R.id.tvDescription);
        tvTitle.setText(getIntent().getStringExtra("originalTitle"));
        tvPopularity.setText(String.format("popularity: %s",
                String.valueOf(getIntent().getIntExtra("popularity", 0))));
        tvDescription.setText(getIntent().getStringExtra("overview"));
        rbMovie.setRating(getIntent().getIntExtra("vote_average", 0));
    }
}
