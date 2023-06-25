package com.example.app2.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app2.models.Movie;
import com.example.app2.R;
import com.example.app2.viewHolders.MovieViewHolder;

import java.util.List;

public class MoviesRecyclerAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    LayoutInflater inflater;
    List<Movie> data;

    public void setData(List<Movie> data){
        this.data = data;
    }

    public MoviesRecyclerAdapter(LayoutInflater inflater, List<Movie> data) {
        this.inflater = inflater;
        this.data = data;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // creates a row view
        View view = inflater.inflate(R.layout.movie_item, parent, false);
        return new MovieViewHolder(view, data);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        // connects between the data and the row view
        Movie movie = data.get(position);
        holder.bind(movie, position);
    }

    @Override
    public int getItemCount() {
        if(data == null)
            return 0;
        return data.size();
    }
}
