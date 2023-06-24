package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.app2.databinding.ActivityCatsFactsBinding;
import com.example.app2.databinding.ActivityLoginBinding;
import com.google.gson.Gson;

public class CatsFactsActivity extends AppCompatActivity {

    ActivityCatsFactsBinding binding;
    private static final Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCatsFactsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        RequestQueue requestQueue = VolleySingleton.getInstance(this).getRequestQueue();

        binding.catsFactsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://cat-fact.herokuapp.com/facts/random";
                StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        CatsFact fact = gson.fromJson(response.toString(), CatsFact.class);
                        Log.d("TAG", "The response is: " + fact.text);

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
    }
}