package com.example.app2.viewHolders;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app2.models.Movie;
import com.example.app2.R;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class MovieViewHolder extends RecyclerView.ViewHolder {
    TextView body;
    ImageView image;
    List<Movie> data;


    public MovieViewHolder(@NonNull View itemView, List<Movie> data) {
        super(itemView);
        this.data = data;
        this.body = itemView.findViewById(R.id.movieItem_tv);
        this.image = itemView.findViewById(R.id.movieItem_imageview);
    }

    public void bind(Movie movie, int pos) {
        body.setText(movie.getTitle());

        URL imageUri = null;
        try {
            imageUri = new URL(movie.getPoster());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        ImageView iv = (ImageView) itemView.findViewById(R.id.movieItem_imageview);
        Picasso.get().load(String.valueOf(imageUri)).into(iv);

    }
}
