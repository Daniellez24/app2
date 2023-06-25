package com.example.app2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app2.databinding.FragmentMoviesBinding;
import com.example.app2.models.Movie;
import com.example.app2.adapters.MoviesRecyclerAdapter;
import com.example.app2.models.MovieModel;

import java.util.List;

public class MoviesFragment extends Fragment {

    FragmentMoviesBinding binding;
    MoviesRecyclerAdapter adapter;
    List<Movie> data;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentMoviesBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.moviesFragmentRv.setHasFixedSize(true);
        binding.moviesFragmentRv.setLayoutManager(new LinearLayoutManager(this.getContext()));
        adapter = new MoviesRecyclerAdapter(getLayoutInflater(), data);

        binding.moviesFragmentRv.setAdapter(adapter);
//        adapter.setData(data);

//        MovieModel.instance.searchMoviesByTitle("avatar");

        adapter.setData(MovieModel.instance.searchMoviesByTitle("avatar"));
        return view;
    }
}