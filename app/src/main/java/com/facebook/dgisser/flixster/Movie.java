package com.facebook.dgisser.flixster;

import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by dgisser on 6/15/16.
 */
public class Movie {
    public String title;
    public String posterUrl;
    public int rating;

    public Movie(String title, String posterUrl, int rating) {
        this.title = title;
        this.posterUrl = posterUrl;
        this.rating = rating;
    }

    public static ArrayList<Movie> getMovies(Context place) {
        ArrayList<Movie> movies = new ArrayList<>();
        String api = place.getResources().getString(R.string.moviedb_api_key);
        String url = String.format("https://api.themoviedb.org/3/movie/now_playing?api_key=%s",api);
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        client.get(url, params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // Root JSON in response is an dictionary i.e { "data : [ ... ] }
                // Handle resulting parsed JSON response here

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String res, Throwable t) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)

            }
        });
        return movies;
    }

    @Override
    public String toString() {
        return title + " - " + rating;
    }
}
