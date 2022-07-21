package com.theknight.fandom.lib;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.theknight.fandom.starwars.CharacterModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StarWarsEngine {



    String text;




    public void getStarWarsData(String url, EditText editText, TextView textView, ImageView imageView) {
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
//                text = "\n\n name : " + response.body().getName() +
//                        "\nheight : " + response.body().getHeight() +
//                        "\nmass : " + response.body().getMass() +
//                        "\nhair color : " + response.body().getHair_color() +
//                        "\nskin color : " + response.body().getSkin_color() +
//                        "\neye color : " + response.body().getEye_color() +
//                        "\nbirth_year : " + response.body().getBirth_year() +
//                        "\ngender : " + response.body().getGender() +
//                        "\nhomewolrd : " + response.body().getHomeworld();

                textView.setText(text);
                ImageLoader im = new ImageLoader();

            }

            @Override
            public void onFailure(@NonNull Call<CharacterModel> call, @NonNull Throwable t) {
                System.out.println("Failed" + t.getMessage());


            }

        });

    }



//                                response.body().getTitle() +
//                                response.body().isCompleted();
//                        System.out.println(text);

}
