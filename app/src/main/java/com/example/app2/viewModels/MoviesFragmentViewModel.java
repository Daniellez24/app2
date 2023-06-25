package com.example.app2.viewModels;

import androidx.lifecycle.ViewModel;

import com.example.app2.models.Movie;
import com.example.app2.models.MovieModel;

import java.util.List;

public class MoviesFragmentViewModel extends ViewModel {

    private List<Movie> data = MovieModel.instance.searchMoviesByTitle("avatar");

    public List<Movie> getData(){
        return data;
    }
}
