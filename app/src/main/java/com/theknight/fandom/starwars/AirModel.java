package com.theknight.fandom.starwars;

import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AirModel {
    private String userId;
    private String id;
    private String title;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    private boolean completed;
    String text;

    public void getStarWarsData(String url, EditText editText, TextView textView){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        System.out.println("Retrofit : " + retrofit);
        StarCall starCall = retrofit.create(StarCall.class);
        int id = 0;
        try {
            id = Integer.parseInt(editText.getText().toString());


        } catch (NumberFormatException n) {
            System.out.println(n.getMessage());
        }
        System.out.println("Id : " + id);
        Call<CharacterModel> call = starCall.getData(id);
        System.out.println("Call :" + call.request());
        call.enqueue(new Callback<CharacterModel>() {
            @Override
            public void onResponse(@NonNull Call<CharacterModel> call, @NonNull Response<CharacterModel> response) {
                System.out.println("Code :" + response.code());
                if (response.code() != 200) {
                    System.out.println("Code : " + response.code());
                    return;


                }
                assert response.body() != null;
                text = "\n\n name : " + response.body().getName() +
                        "\nheight : " + response.body().getHeight() +
                        "\nmass : " + response.body().getMass() +
                        "\nhair color : " + response.body().getHair_color() +
                        "\nskin color : " + response.body().getSkin_color() +
                        "\neye color : " + response.body().getEye_color() +
                        "\nbirth_year : " + response.body().getBirth_year() +
                        "\ngender : " + response.body().getGender() +
                        "\nhomewolrd : " + response.body().getHomeworld();

                textView.setText(text);

            }

            @Override
            public void onFailure(@NonNull Call<CharacterModel> call, @NonNull Throwable t) {
                System.out.println("Failed" + t.getMessage());


            }
        });

    }





}
