package com.theknight.fandom.starwars;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.theknight.fandom.R;
import com.theknight.fandom.lib.ImageLoader;
import com.theknight.fandom.lib.RetrofitClient;
import com.theknight.fandom.lib.Util;

import java.util.List;

import jp.wasabeef.recyclerview.animators.FlipInBottomXAnimator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StarWarsActivity extends AppCompatActivity {
    private static final String TAG = "StarWarsActivity";
    RecyclerView recyclerView;
    ImageView imageView, imageView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_wars);
        Log.d(TAG, "onCreate: opening starwars class ");
        recyclerView = findViewById(R.id.starwars_rec);
        imageView = findViewById(R.id.header);
        imageView2 = findViewById(R.id.header2);
        String url1 = getIntent().getStringExtra("url1");
        String url2 = getIntent().getStringExtra("url2");
        ImageLoader loader = new ImageLoader();
        loader.loadImage(this, imageView, url1);

        loader.loadImage(this, imageView2, url2);


        Log.d(TAG, "onCreate: Added characters");

        CharacterCall castcall = RetrofitClient.getRetrofitInstance(" https://raw.githubusercontent.com/").create(CharacterCall.class);
        Log.d(TAG, "onCreate: retrofit instance done");
        Log.d(TAG, "onCreate: castcall" + castcall.toString());
        Call<List<CharacterModel>> call = castcall.getData();
        Log.d(TAG, "onCreate: call " + call.toString());
        Log.d(TAG, "onCreate: " + call.request());

        call.enqueue(new Callback<List<CharacterModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<CharacterModel>> call, @NonNull Response<List<CharacterModel>> response) {
                System.out.println("Code :" + response.code());
                if (response.code() != 200) {
                    System.out.println("Code : " + response.code());


                }
                List<CharacterModel> items = response.body();
                if (items != null) {
                    Log.d(TAG, "onResponse: Items are filled" + items.get(0).getName() + items.get(0).getGender() + items.get(0).getUrl());

                    setAdapter(items);
                    Log.d(TAG, "onResponse: character added by url");


                }


            }

            @Override
            public void onFailure(@NonNull Call<List<CharacterModel>> call, @NonNull Throwable t) {
                Log.d(TAG, "onFailure: Character added failed " + call.toString());
                System.out.println(t.getLocalizedMessage());

            }
        });


    }

    public void setAdapter(List<CharacterModel> data) {

        CastAdapter adapter = new CastAdapter(this, data);
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