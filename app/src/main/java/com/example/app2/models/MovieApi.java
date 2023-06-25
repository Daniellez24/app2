package com.example.app2.models;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApi {
    @GET("?apikey=c9a49a1c")
    Call<MovieSearchResult> searchMovieByTitle(@Query("s") String title);
}
