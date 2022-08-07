package com.theknight.fandom.pirates;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PirateCall {
    @GET("/api/v1/pirates")
    Call<List<PiratesModel>> getPirateData();
}
