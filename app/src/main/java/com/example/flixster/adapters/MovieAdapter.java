package com.example.flixster.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.flixster.R;
import com.example.flixster.models.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    Context context;
    List<Movie> movies;

    public MovieAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View movieView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(movieView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie = movies.get(position);
        holder.bind(movie);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView movTitle;
        TextView movOverview;
        ImageView imgPoster;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            movTitle = itemView.findViewById(R.id.movTitle);
            movOverview = itemView.findViewById(R.id.movOverview);
            imgPoster = itemView.findViewById(R.id.imgPoster);
        }

        public void bind(Movie movie) {
            movTitle.setText(movie.getTitle());
            movOverview.setText(movie.getOverview());
            String imgURL;
            if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                imgURL = movie.getBackdropPath();
            } else {
                imgURL = movie.getPosterPath();
            }
            Glide.with(context).load(imgURL).into(imgPoster);
        }
    }
}
