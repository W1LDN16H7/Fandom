package com.theknight.fandom.potter;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HarryCall {
    @GET("/api/v1/hp")
    Call<List<CharacterModel>> getHPData();
}

