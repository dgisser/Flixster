package com.facebook.dgisser.flixster;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by dgisser on 6/16/16.
 */
public class BoxOfficeResponse {
    public static BoxOfficeResponse parseJSON(String response) {
        Gson gson = new GsonBuilder().create();
        BoxOfficeResponse boxOfficeMovieResponse = gson.fromJson(response, BoxOfficeResponse.class);
        return boxOfficeMovieResponse;
    }
}
