package com.theknight.fandom.adapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieCall {
    @GET("/W1LDN16H7/fandom-api/master/api/shows.json")
    Call<List<MovieModel>> getMovie();

}
