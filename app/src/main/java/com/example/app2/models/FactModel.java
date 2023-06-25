package com.example.app2.models;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.example.app2.VolleySingleton;

public class FactModel {
    final public static FactModel instance = new FactModel();

    private RequestQueue requestQueue;
    String url = "https://cat-fact.herokuapp.com/facts/random";

    private FactModel(){
//        requestQueue = VolleySingleton.getInstance().getRequestQueue();
    }

}
