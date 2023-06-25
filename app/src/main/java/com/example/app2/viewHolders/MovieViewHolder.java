package com.example.app2.viewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app2.models.Movie;
import com.example.app2.R;

import java.util.List;

public class MovieViewHolder extends RecyclerView.ViewHolder {
    TextView body;
    List<Movie> data;


    public MovieViewHolder(@NonNull View itemView, List<Movie> data) {
        super(itemView);
        this.data = data;
        this.body = itemView.findViewById(R.id.movieItem_tv);
    }

    public void bind(Movie movie, int pos){
        body.setText(movie.getTitle());
    }
}
