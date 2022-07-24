package com.theknight.fandom.marvel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MarvelCall {

    @GET("/W1LDN16H7/fandom-api/master/api/marvel.json")
    Call<List<MarvelModel>> getMarvelData();
}
