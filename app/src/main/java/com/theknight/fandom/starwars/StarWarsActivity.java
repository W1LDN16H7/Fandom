package com.theknight.fandom.starwars;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.animation.OvershootInterpolator;

import com.theknight.fandom.R;
import com.theknight.fandom.lib.TransparentBar;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

public class StarWarsActivity extends AppCompatActivity {
    private static final String TAG = "$className" ;
    RecyclerView recyclerView;
    List<Character> characters = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_wars);
        Log.d(TAG, "onCreate: opening starwars class ");
        recyclerView = findViewById(R.id.starwars_rec);


        characters.add(new Character("Star Wars","Vader",R.drawable.starwars));
        characters.add(new Character("Star Wars","Vader",R.drawable.starwars));
        characters.add(new Character("Star Wars","Vader",R.drawable.starwars));
        characters.add(new Character("Star Wars","Vader",R.drawable.starwars));
        characters.add(new Character("Star Wars","Vader",R.drawable.starwars));
        characters.add(new Character("Star Wars","Vader",R.drawable.starwars));
        characters.add(new Character("Star Wars","Vader",R.drawable.starwars));
        characters.add(new Character("Star Wars","Vader",R.drawable.starwars));
        characters.add(new Character("Star Wars","Vader",R.drawable.starwars));
        characters.add(new Character("Star Wars","Vader",R.drawable.starwars));
        characters.add(new Character("Star Wars","Vader",R.drawable.starwars));
        characters.add(new Character("Star Wars","Vader",R.drawable.starwars));
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
        CharacterAdapter adapter = new CharacterAdapter(this,characters);
        Log.d(TAG, "onCreate: Adapter set");
        RecyclerView.LayoutManager manager = new GridLayoutManager(this,2,GridLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new SlideInUpAnimator(new OvershootInterpolator(1f)));
        recyclerView.setAdapter(adapter);
        Log.d(TAG, "onCreate: Set final adapter");




    }
}