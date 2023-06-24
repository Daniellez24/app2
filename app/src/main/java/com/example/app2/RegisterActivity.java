package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.app2.databinding.ActivityRegisterBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.registerToLoginTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

        String email = binding.registerEmailTl.getEditText().getText().toString();
        String password = binding.registerPasswordTl.getEditText().getText().toString();
        String url = "https://dummy.restapiexample.com/api/v1/create";
        RequestQueue requestQueue = VolleySingleton.getInstance(this).getRequestQueue();


        binding.registerRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest registerRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // handle response
                        startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // handle error
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams(){
                        Map<String, String> params = new HashMap<>();
                        // request params
                        params.put("name", email);
                        params.put("age", password);
//                        params.put("password", password);

                        return params;
                    }
                };

                requestQueue.add(registerRequest);
            }
        });

//                try {
//                    String URL = "https://reqres.in/api/register";
//                    JSONObject jsonBody = new JSONObject();
//                    jsonBody.put("email", email);
//                    jsonBody.put("password", password);
//                    final String requestBody = jsonBody.toString();
//
//                    StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
//                        @Override
//                        public void onResponse(String response) {
//                            Log.i("VOLLEY", response);
//                            //startActivity(new Intent(RegisterActivity.this, MainActivity.class));
//                        }
//                    }, new Response.ErrorListener() {
//                        @Override
//                        public void onErrorResponse(VolleyError error) {
//                            Log.e("VOLLEY", error.toString());
//                        }
//                    }) {
//
//                        @Override
//                        public byte[] getBody() throws AuthFailureError {
//                            try {
//                                return requestBody == null ? null : requestBody.getBytes("utf-8");
//                            } catch (UnsupportedEncodingException uee) {
//                                VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
//                                return null;
//                            }
//                        }
//
//                        @Override
//                        public String getBodyContentType() {
//                            return "application/x-www-form-urlencoded; charset=UTF-8";
//                        }
//
//                        @Override
//                        protected Map<String, String> getParams(){
//                            Map<String, String> params = new HashMap<>();
//                            // request params
//                            params.put("email", email);
//                            params.put("password", password);
//
//                            return params;
//                        }
//
//                        @Override
//                        protected Response<String> parseNetworkResponse(NetworkResponse response) {
//                            String responseString = "";
//                            if (response != null) {
//                                responseString = String.valueOf(response.statusCode);
//                                // can get more details such as response.headers
//                            }
//                            return Response.success(responseString, HttpHeaderParser.parseCacheHeaders(response));
//                        }
//                    };
//
//                    requestQueue.add(stringRequest);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }

//            }
//
//
//        });
    }
}