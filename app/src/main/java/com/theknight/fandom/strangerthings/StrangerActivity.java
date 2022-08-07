package com.theknight.fandom.strangerthings;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.theknight.fandom.R;
import com.theknight.fandom.lib.CustomAnimationAdapter;
import com.theknight.fandom.lib.Divider;
import com.theknight.fandom.lib.NetworkChangeListener;
import com.theknight.fandom.lib.RetrofitClient;
import com.theknight.fandom.lib.Util;

import java.util.List;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StrangerActivity extends AppCompatActivity {
    private static final String TAG = "Strangerthings";
    RecyclerView recyclerView;
    NetworkChangeListener networkChangeListener = new NetworkChangeListener();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stranger);

        recyclerView = findViewById(R.id.stranger_rec);
        RetrofitClient rt = new RetrofitClient();

        StrangerCall characterCall = rt.getRetrofitInstance("https://omg-db.herokuapp.com/").create(StrangerCall.class);
        Log.d(TAG, "onCreate: retrofit instance done" + characterCall.toString());

        Call<List<StrangerModel>> call = characterCall.getStrangerData();
        Log.d(TAG, "onCreate: call harry " + call.request());

        call.enqueue(new Callback<List<StrangerModel>>() {
            @Override
            public void onResponse(Call<List<StrangerModel>> call, Response<List<StrangerModel>> response) {
                System.out.println("Code :" + response.code());
                if (response.code() != 200) {
                    System.out.println("Code : " + response.code());


                }
                List<StrangerModel> items = response.body();
                if (items != null) {
                    Log.d(TAG, "onResponse: Items are filled" + items.get(0).getName() + items.get(0).getGender() + items.get(0).getPhoto());

                    setAdapter(items);
                    Log.d(TAG, "onResponse: character added by url");


                }
            }

            @Override
            public void onFailure(Call<List<StrangerModel>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());

            }
        });
    }

    public void setAdapter(List<StrangerModel> data) {
        StrangerAdapter adapter = new StrangerAdapter(this, data);
        RecyclerView.LayoutManager manager = null;


        if (Util.getRotation(this).equals("landscape")) {
            manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        }
        if (Util.getRotation(this).equals("portrait")) {
            manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        }

        recyclerView.setLayoutManager(manager);
        AlphaInAnimationAdapter alphaInAnimationAdapter = new AlphaInAnimationAdapter(adapter);


        recyclerView.setAdapter(new ScaleInAnimationAdapter(CustomAnimationAdapter.setAnimationAdapter(alphaInAnimationAdapter)));
        recyclerView.addItemDecoration(Divider.getDivider(this));
        Log.d(TAG, "onCreate: Set final adapter");
    }

    @Override
    protected void onStart() {
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkChangeListener, intentFilter);
        super.onStart();
    }

    @Override
    protected void onStop() {
        unregisterReceiver(networkChangeListener);
        super.onStop();
    }
}