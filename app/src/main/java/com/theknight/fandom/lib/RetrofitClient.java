package com.theknight.fandom.lib;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static Retrofit retrofit;

    /**
     * Custom Retrofit Client method that return the retrofit and accept the @baseURL
     *
     * @param baseUrl
     * @return Retrofit instance
     */

    public static synchronized Retrofit getRetrofitInstance(String baseUrl) {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
