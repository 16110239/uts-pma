package com.muhamadriza.mycatalogfilm;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.muhamadriza.mycatalogfilm.DetailActivity;
import com.muhamadriza.mycatalogfilm.MainActivity;
import com.muhamadriza.mycatalogfilm.R;
import com.muhamadriza.mycatalogfilm.MovieFilm;
import com.squareup.picasso.Picasso;

/**
 * Created by Muhamad Riza on 10/30/2018.
 */

import java.util.List;

public class AdapterMovie extends RecyclerView<AdapterMovie.MovieViewHolder> {

    private List<MovieFilm> movies;
    private int rowLayout;
    private Context context;
    public static final String IMAGE_URL_BASE_PATH = "https://image.tmdb.org/t/p/w342//";

    public MovieAdapter(List<MovieFilm> movies, int rowLayout, Context context) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;


    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        TextView movieTitle;
        TextView movieDescription;
        TextView rating;
        ImageView movieImage;
        Button btnDetail;

        public MovieViewHolder(View v) {
            super(v);
            moviesLayout = (LinearLayout) v.findViewById(R.id.movies_layout);
            movieImage = (ImageView) v.findViewById(R.id.movie_image);
            movieTitle = (TextView) v.findViewById(R.id.title);
//            data = (TextView) v.findViewById(R.id.date);
            movieDescription = (TextView) v.findViewById(R.id.description);
//            rating = (TextView) v.findViewById(R.id.rating);
            btnDetail = v.findViewById(R.id.btn_detail);
        }
    }
}