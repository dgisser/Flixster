package com.facebook.dgisser.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by dgisser on 6/16/16.
 */
public class Movie {
    public String getPosterPath() {
        return String.format("http://image.tmdb.org/t/p/w500%s",posterPath);
    }

    String posterPath;

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public String getBackdropPath() {
        return String.format("http://image.tmdb.org/t/p/w500%s",backdropPath);
    }

    public Integer getPopularity() {
        return popularity;
    }

    public Integer getVote_average() {
        return vote_average;
    }

    String originalTitle;
    String overview;
    String backdropPath;
    Integer popularity;
    Integer vote_average;

    public Movie(JSONObject jsonObject) throws JSONException {
        this.posterPath = jsonObject.getString("poster_path");
        this.originalTitle = jsonObject.getString("original_title");
        this.overview = jsonObject.getString("overview");
        this.backdropPath = jsonObject.getString("backdrop_path");
        this.popularity = (int) jsonObject.getDouble("popularity");
        this.vote_average = (int) jsonObject.getDouble("vote_average");
    }

    public static ArrayList<Movie> fromJSONArray (JSONArray array) {
        ArrayList<Movie> results = new ArrayList<>();
        for (int x = 0; x < array.length(); x++) {
            try {
                results.add(new Movie(array.getJSONObject(x)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }

}
