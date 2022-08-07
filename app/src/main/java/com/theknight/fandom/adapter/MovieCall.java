package com.theknight.fandom.adapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieCall {
    @GET("/api/v1/all")
    Call<List<MovieModel>> getMovie();

}
