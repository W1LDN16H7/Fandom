package com.theknight.fandom;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.theknight.fandom.adapter.ItemAdapter;
import com.theknight.fandom.adapter.MovieData;
import com.theknight.fandom.starwars.CharacterModel;
import com.theknight.fandom.starwars.StarCall;
import com.theknight.fandom.starwars.StarWarsEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;
    String text;
    RecyclerView recyclerView;
    EditText editText;
    ImageView imageView;
    List<MovieData> movies = new ArrayList<>();
    static String[] titles = {"StarWars", "Harry Potter"};
    static int[] images = {R.drawable.starwars_logo, R.drawable.hp_logo};

    static String starDesc = "Star Wars is an American epic space-opera multimedia franchise created by George Lucas, which began with the eponymous 1977 film and quickly became a worldwide pop-culture phenomenon.";
    static String harryDesc = "Harry Potter is a series of seven fantasy novels written by British author J. K. Rowling. The novels chronicle the lives of a young wizard, Harry Potter.";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        transparentStatusAndNavigation();
//        textView = findViewById(R.id.textView);
//        button = findViewById(R.id.button);
//        editText = findViewById(R.id.id);
//        imageView = findViewById(R.id.userimage);
        recyclerView = findViewById(R.id.rec);






        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        movies.add(new MovieData("StarWars",starDesc,images[0]));
        movies.add(new MovieData("Harry Potter",harryDesc,images[1]));
        movies.add(new MovieData("StarWars",starDesc,images[0]));
        movies.add(new MovieData("Harry Potter",harryDesc,images[1]));
        movies.add(new MovieData("StarWars",starDesc,images[0]));
        movies.add(new MovieData("Harry Potter",harryDesc,images[1]));
        movies.add(new MovieData("StarWars",starDesc,images[0]));
        movies.add(new MovieData("Harry Potter",harryDesc,images[1]));
        movies.add(new MovieData("StarWars",starDesc,images[0]));
        movies.add(new MovieData("Harry Potter",harryDesc,images[1]));
        movies.add(new MovieData("StarWars",starDesc,images[0]));
        movies.add(new MovieData("Harry Potter",harryDesc,images[1]));

        ItemAdapter itemAdapter = new ItemAdapter(movies);
        recyclerView.setItemAnimator(new SlideInUpAnimator(new OvershootInterpolator(1f)));

        recyclerView.setAdapter(itemAdapter);
        Objects.requireNonNull(recyclerView.getLayoutManager()).setMeasurementCacheEnabled(false);





//        Intent i =new Intent(getApplicationContext(), Slider.class);
//        startActivity(i);
//        StarWarsEngine en = new StarWarsEngine("https://swapi.dev/","2");
//        response = en.request();
//        System.out.println("First : " + response.get(0));



//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                new StarWarsEngine().getStarWarsData("https://akabab.github.io/",editText,textView,imageView);
//
//
//            }
//        });


    }



//    public void prepareMovieData(){
//        int count = 0;
//        for(String title : titles){
//            for(String desc : descs){
//                MovieData movieData = new MovieData(title,desc,images[count]);
//                movies.add(movieData);
//                count++;
//
//
//
//            }
//        }
//    }

    private void transparentStatusAndNavigation() {
        //make full transparent statusBar
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, true);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            );
        }
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, false);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
            getWindow().setNavigationBarColor(Color.TRANSPARENT);
        }
    }

    private void setWindowFlag(final int bits, boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

}