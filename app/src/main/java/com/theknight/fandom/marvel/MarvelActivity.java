package com.theknight.fandom.marvel;

import android.os.Bundle;
import android.util.Log;
import android.view.animation.OvershootInterpolator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.theknight.fandom.R;
import com.theknight.fandom.lib.Divider;
import com.theknight.fandom.lib.RetrofitClient;
import com.theknight.fandom.lib.Util;

import java.util.List;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MarvelActivity extends AppCompatActivity {
    private static final String TAG = "Potter.java";
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marvel);

        recyclerView = findViewById(R.id.marvel_rec);
        RetrofitClient rt = new RetrofitClient();

        MarvelCall characterCall = rt.getRetrofitInstance("https://raw.githubusercontent.com/").create(MarvelCall.class);
        Log.d(TAG, "onCreate: retrofit instance done" + characterCall.toString());

        Call<List<MarvelModel>> call = characterCall.getMarvelData();
        Log.d(TAG, "onCreate: call harry " + call.request());

        call.enqueue(new Callback<List<MarvelModel>>() {
            @Override
            public void onResponse(Call<List<MarvelModel>> call, Response<List<MarvelModel>> response) {
                System.out.println("Code :" + response.code());
                if (response.code() != 200) {
                    System.out.println("Code : " + response.code());


                }
                List<MarvelModel> items = response.body();
                if (items != null) {
                    Log.d(TAG, "onResponse: Items are filled" + items.get(0).getName() + items.get(0).getGender() + items.get(0).getImages());

                    setAdapter(items);
                    Log.d(TAG, "onResponse: character added by url");


                }
            }

            @Override
            public void onFailure(Call<List<MarvelModel>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());


            }
        });

    }

    public void setAdapter(List<MarvelModel> data) {
        MarvelAdapter adapter = new MarvelAdapter(this, data);
        RecyclerView.LayoutManager manager = null;


        if (Util.getRotation(this).equals("landscape")) {
            manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        }
        if (Util.getRotation(this).equals("portrait")) {
            manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        }

        recyclerView.setLayoutManager(manager);
        AlphaInAnimationAdapter alphaInAnimationAdapter = new AlphaInAnimationAdapter(adapter);

        alphaInAnimationAdapter.setInterpolator(new OvershootInterpolator());
        alphaInAnimationAdapter.setFirstOnly(false);
        alphaInAnimationAdapter.setDuration(1000);


        recyclerView.setAdapter(new ScaleInAnimationAdapter(alphaInAnimationAdapter));
        recyclerView.addItemDecoration(Divider.getDivider(this));
        Log.d(TAG, "onCreate: Set final adapter");
    }
}