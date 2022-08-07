package com.theknight.fandom.marvel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MarvelCall {

    @GET("/api/v1/marvel")
    Call<List<MarvelModel>> getMarvelData();
}
