package com.theknight.fandom.pirates;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PirateCall {
    @GET("/W1LDN16H7/fandom-api/master/api/pirates.json")
    Call<List<PiratesModel>> getPirateData();
}
