package com.example.app2.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.app2.models.Movie;
import com.example.app2.models.MovieModel;

import java.util.List;

public class MoviesFragmentViewModel extends ViewModel {

    private LiveData<List<Movie>> data = MovieModel.instance.searchMoviesByTitle("love");

    public LiveData<List<Movie>> getData(){
        return data;
    }
}
