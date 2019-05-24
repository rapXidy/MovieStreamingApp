package com.chidii.mymovies.Adapters;

import android.widget.ImageView;

import com.chidii.mymovies.Models.Movie;

public interface MovieItemClickListener {

    void onMovieClick(Movie movie, ImageView movieImageView);
    //we will need the ImageView to use the shared animation btw the two activities



}
