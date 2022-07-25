package com.theknight.fandom.strangerthings;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StrangerCall {
    @GET("/api/v1/characters?perPage=108")
    Call<List<StrangerModel>> getStrangerData();


}
