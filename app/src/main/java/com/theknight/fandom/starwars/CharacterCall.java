package com.theknight.fandom.starwars;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

//interface CastCall {
//
//    //    @GET("/todos/2")
////    Call<AirModel> getData();
////    @GET("/starwars-api/api/id/{id}.json")
////    Call<Character> getData(@Path("id") int id);
//
//    @GET("/starwars-api/api/all.json")
//    Call<List<Character>> getData();
//
//}

public interface CharacterCall {
//    @GET("/starwars-api/api/all.json")
//    Call<List<CharacterModel>> getData();
@GET("/api/v1/starwars")
Call<List<CharacterModel>> getData();

}