package com.theknight.fandom.strangerthings;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StrangerCall {
    @GET("/api/v1/strangerthings")
    Call<List<StrangerModel>> getStrangerData();


}
