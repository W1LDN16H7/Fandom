package com.theknight.fandom.potter;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.theknight.fandom.R;
import com.theknight.fandom.lib.RetrofitClient;
import com.theknight.fandom.lib.Util;

import java.util.List;

import jp.wasabeef.recyclerview.animators.FlipInBottomXAnimator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Potter extends AppCompatActivity {
    private static final String TAG = "Potter.java";
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_potter);

        recyclerView = findViewById(R.id.potter_rec);
        RetrofitClient rt = new RetrofitClient();

        HarryCall characterCall = rt.getRetrofitInstance("https://hp-api.herokuapp.com/").create(HarryCall.class);
        Log.d(TAG, "onCreate: retrofit instance done" + characterCall.toString());

        Call<List<CharacterModel>> call = characterCall.getHPData();
        Log.d(TAG, "onCreate: call harry " + call.request());

        call.enqueue(new Callback<List<CharacterModel>>() {
            @Override
            public void onResponse(Call<List<CharacterModel>> call, Response<List<CharacterModel>> response) {
                System.out.println("Code :" + response.code());
                if (response.code() != 200) {
                    System.out.println("Code : " + response.code());


                }
                List<CharacterModel> items = response.body();
                if (items != null) {
                    Log.d(TAG, "onResponse: Items are filled" + items.get(0).getName() + items.get(0).getGender() + items.get(0).getImageUrl());

                    setAdapter(items);
                    Log.d(TAG, "onResponse: character added by url");


                }
            }

            @Override
            public void onFailure(Call<List<CharacterModel>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());


            }
        });
    }

    public void setAdapter(List<CharacterModel> data) {

        RonAdapter adapter = new RonAdapter(this, data);
        Log.d(TAG, "onCreate: Adapter set");
        RecyclerView.LayoutManager manager = null;

        if (Util.getRotation(this).equals("landscape")) {
            manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);

        }
        if (Util.getRotation(this).equals("portrait")) {
            manager = new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false);

        }


        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new FlipInBottomXAnimator());
        recyclerView.setAdapter(adapter);
        Log.d(TAG, "onCreate: Set final adapter");


    }
}