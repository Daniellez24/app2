package com.example.app2;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app2.databinding.FragmentMoviesBinding;
import com.example.app2.models.Movie;
import com.example.app2.adapters.MoviesRecyclerAdapter;
import com.example.app2.models.MovieModel;
import com.example.app2.viewModels.MoviesFragmentViewModel;

import java.util.List;

public class MoviesFragment extends Fragment {

    FragmentMoviesBinding binding;
    MoviesRecyclerAdapter adapter;
    List<Movie> data;
    MoviesFragmentViewModel viewModel;


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
        adapter = new MoviesRecyclerAdapter(getLayoutInflater(), viewModel.getData().getValue());

        binding.moviesFragmentRv.setAdapter(adapter);
//        adapter.setData(data);

//        MovieModel.instance.searchMoviesByTitle("avatar");

        viewModel.getData().observe(getViewLifecycleOwner(), list -> {
            adapter.setData(list);
        });

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        viewModel = new ViewModelProvider(this).get(MoviesFragmentViewModel.class);
    }
}