package com.example.app2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app2.models.Fact;
import com.example.app2.adapters.FactsRecyclerAdapter;
import com.example.app2.databinding.FragmentFactsBinding;

import java.util.List;

public class FactsFragment extends Fragment {

    FragmentFactsBinding binding;
//    private static final Gson gson = new Gson();
//    FactsRecyclerAdapter adapter;
    List<Fact> data;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentFactsBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.factsRv.setHasFixedSize(true);
        binding.factsRv.setLayoutManager(new LinearLayoutManager(this.getContext()));
        //data = getFacts
        binding.factsRv.setAdapter(new FactsRecyclerAdapter(inflater, data));


        return view;
    }
}