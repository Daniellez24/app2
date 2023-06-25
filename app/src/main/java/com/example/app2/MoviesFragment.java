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

import java.util.List;

public class MoviesFragment extends Fragment {

    FragmentMoviesBinding binding;
//    private static final Gson gson = new Gson();
//    FactsRecyclerAdapter adapter;
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
        //data = getFacts
        binding.moviesFragmentRv.setAdapter(new MoviesRecyclerAdapter(inflater, data));


        return view;
    }
}