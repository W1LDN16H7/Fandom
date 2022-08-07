package com.theknight.fandom.lib;

import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public Retrofit retrofit;
    String BASE_URL = "";

    /**
     * Custom Retrofit Client method that return the retrofit and accept the @baseURL
     *
     * @param BASE_URL - The base url of the API
     * @return Retrofit instance
     */

    public synchronized Retrofit getRetrofitInstance(String BASE_URL) {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().serializeNulls().create()))
                    .build();
        }
        return retrofit;
    }

}
