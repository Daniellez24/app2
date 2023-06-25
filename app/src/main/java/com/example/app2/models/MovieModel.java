package com.example.app2.models;

import com.android.volley.RequestQueue;

public class MovieModel {
    final public static MovieModel instance = new MovieModel();

    private RequestQueue requestQueue;
    String url = "https://cat-fact.herokuapp.com/facts/random";

    private MovieModel(){
//        requestQueue = VolleySingleton.getInstance().getRequestQueue();
    }

}
