package com.theknight.fandom.starwars;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.theknight.fandom.R;
import com.theknight.fandom.lib.RetrofitClient;

import java.util.List;

import jp.wasabeef.recyclerview.animators.FlipInBottomXAnimator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StarWarsActivity extends AppCompatActivity {
    private static final String TAG = "StarWarsActivity";
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_wars);
        Log.d(TAG, "onCreate: opening starwars class ");
        recyclerView = findViewById(R.id.starwars_rec);

        // loading data into Character class


//        characters.add(new Character("Star Wars","Vader",R.drawable.starwars));
//        characters.add(new Character("Star Wars","Vader",R.drawable.starwars));
//        characters.add(new Character("Star Wars","Vader",R.drawable.starwars));
//        characters.add(new Character("Star Wars","Vader",R.drawable.starwars));
//        characters.add(new Character("Star Wars","Vader",R.drawable.starwars));
//        characters.add(new Character("Star Wars","Vader",R.drawable.starwars));
//        characters.add(new Character("Star Wars","Vader",R.drawable.starwars));
//        characters.add(new Character("Star Wars","Vader",R.drawable.starwars));
//        characters.add(new Character("Star Wars","Vader",R.drawable.starwars));
//        characters.add(new Character("Star Wars","Vader",R.drawable.starwars));
//        characters.add(new Character("Star Wars","Vader",R.drawable.starwars));
        Log.d(TAG, "onCreate: Added characters");
//        characters.add(new Character("Star Wars","Vader",R.drawable.starwars));
//        characters.add(new Character("Star Wars","Vader",R.drawable.starwars));
//        characters.add(new Character("Star Wars","Vader",R.drawable.starwars));
//        characters.add(new Character("Star Wars","Vader",R.drawable.starwars));
//        characters.add(new Character("Star Wars","Vader",R.drawable.starwars));
//        characters.add(new Character("Star Wars","Vader",R.drawable.starwars));
//        characters.add(new Character("Star Wars","Vader",R.drawable.starwars));
//        characters.add(new Character("Star Wars","Vader",R.drawable.starwars));
//        characters.add(new Character("Star Wars","Vader",R.drawable.starwars));


        CastCall castcall = RetrofitClient.getRetrofitInstance("https://akabab.github.io/").create(CastCall.class);
        Log.d(TAG, "onCreate: retrofit instance done");
        Log.d(TAG, "onCreate: castcall" + castcall.toString());
        Call<List<Character>> call = castcall.getData();
        Log.d(TAG, "onCreate: call " + call.toString());

        call.enqueue(new Callback<List<Character>>() {
            @Override
            public void onResponse(@NonNull Call<List<Character>> call, @NonNull Response<List<Character>> response) {
                System.out.println("Code :" + response.code());
                if (response.code() != 200) {
                    System.out.println("Code : " + response.code());


                }
                List<Character> items = response.body();
                if (items != null) {
                    Log.d(TAG, "onResponse: Items are filled" + items.get(0).getName() + items.get(0).getAge() + items.get(0).getUrl());


//                    ;
//                    List<Character> characters = new ArrayList<>();
//                    characters.add(new Character(items.getName(),items.getAge(),items.getUrl()));

                    setAdapter(items);
                    Log.d(TAG, "onResponse: character added by url");


                }


            }

            @Override
            public void onFailure(@NonNull Call<List<Character>> call, @NonNull Throwable t) {
                Log.d(TAG, "onFailure: Character added failed " + call.toString());
                System.out.println(t.getLocalizedMessage());

            }
        });
//        CastAdapter adapter = new CastAdapter(this,characters);
//        Log.d(TAG, "onCreate: Adapter set");
//
//
//
//        RecyclerView.LayoutManager manager = new GridLayoutManager(this,2,GridLayoutManager.HORIZONTAL,false);
//        recyclerView.setLayoutManager(manager);
//        recyclerView.setItemAnimator(new FlipInBottomXAnimator());
//        recyclerView.setAdapter(adapter);
//        Log.d(TAG, "onCreate: Set final adapter");


    }

    public void setAdapter(List<Character> data) {

        CastAdapter adapter = new CastAdapter(this, data);
        Log.d(TAG, "onCreate: Adapter set");


        RecyclerView.LayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new FlipInBottomXAnimator());
        recyclerView.setAdapter(adapter);
        Log.d(TAG, "onCreate: Set final adapter");


    }
}