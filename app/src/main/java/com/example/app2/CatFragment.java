package com.example.app2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.app2.databinding.FragmentCatBinding;
import com.example.app2.models.CatsFact;
import com.google.gson.Gson;


public class CatFragment extends Fragment {

    FragmentCatBinding binding;
    private static final Gson gson = new Gson();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentCatBinding.inflate(inflater);
        View view = binding.getRoot();

        RequestQueue requestQueue = VolleySingleton.getInstance(this.getContext()).getRequestQueue();

        binding.catFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://cat-fact.herokuapp.com/facts/random";
                StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        CatsFact fact = gson.fromJson(response.toString(), CatsFact.class);
//                        Log.d("TAG", "The response is: " + fact.text);
                        binding.catFragmentTv.setText(fact.getText());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("TAG", "That didn't work..");
                    }
                });
                requestQueue.add(request);

            }
        });


        return view;
    }
}