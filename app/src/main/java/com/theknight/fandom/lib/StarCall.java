package com.theknight.fandom.lib;

import com.theknight.fandom.starwars.CharacterModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface StarCall {

    //    @GET("/todos/2")
//    Call<AirModel> getData();
    @GET("/starwars-api/api/id/{id}.json")
    Call<CharacterModel> getData(@Path("id") int id);

}
