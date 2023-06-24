package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.app2.databinding.ActivityLoginBinding;
import com.example.app2.databinding.ActivityRegisterBinding;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    ArrayList<User> userList;
    RequestQueue requestQueue;
    boolean userExists = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.loginToRegisterTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        String email = binding.loginEmailTl.getEditText().getText().toString();
        String password = binding.loginPasswordTl.getEditText().getText().toString();
        String url = "https://dummy.restapiexample.com/api/v1/create";
        requestQueue = VolleySingleton.getInstance(this).getRequestQueue();

        binding.loginLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest loginRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // handle response
                        Gson gson = new Gson();
                        User user = gson.fromJson(response.toString(), User.class);
                        validateUser(user);
//                        if(userExists){
//                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
//                        } else {
//                            Toast.makeText(LoginActivity.this, "User not found, please register", Toast.LENGTH_SHORT).show();
//                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // handle error
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<>();
                        // request params
                        params.put("name", email);
                        params.put("age", password);
//                        params.put("password", password);

                        return params;
                    }
                };

                requestQueue.add(loginRequest);
            }
        });


    }
    public void validateUser(User user){
        String url = "https://dummy.restapiexample.com/api/v1/employee/" + user.getData().getId();
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response != null){
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                } else {
                    Toast.makeText(LoginActivity.this, "User not found, please register", Toast.LENGTH_SHORT).show();
                }

//                    userExists = true;
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(request);

    }
}