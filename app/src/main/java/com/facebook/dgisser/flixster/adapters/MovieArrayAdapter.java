package com.facebook.dgisser.flixster.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.dgisser.flixster.CircleTransform;
import com.facebook.dgisser.flixster.R;
import com.facebook.dgisser.flixster.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dgisser on 6/16/16.
 */
public class MovieArrayAdapter extends ArrayAdapter<Movie> {
    private static class ViewHolder {
        TextView title;
        TextView overview;
        ImageView image;
    }

    public MovieArrayAdapter(Context context, List<Movie> movies){
        super(context, android.R.layout.simple_list_item_1, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Movie movie = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);
            viewHolder.title = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.overview = (TextView) convertView.findViewById(R.id.tvOverview);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.ivPoster);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.image.setImageResource(0);
        viewHolder.title.setText(movie.getOriginalTitle());
        viewHolder.overview.setText(movie.getOverview());
        int orientation = convertView.getResources().getConfiguration().orientation;
        String path;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            path = movie.getPosterPath();
        } else {
            path = movie.getBackdropPath();
        }
        Picasso.with(getContext()).load(movie.getPosterPath()).transform(new CircleTransform())
                .placeholder(R.drawable.corgi).into(viewHolder.image);

        return convertView;
    }
}
