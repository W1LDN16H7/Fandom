package com.theknight.fandom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.thecode.aestheticdialogs.AestheticDialog;
import com.thecode.aestheticdialogs.DialogStyle;
import com.thecode.aestheticdialogs.DialogType;
import com.thecode.aestheticdialogs.OnDialogClickListener;
import com.theknight.fandom.adapter.ItemAdapter;
import com.theknight.fandom.adapter.MovieCall;
import com.theknight.fandom.adapter.MovieModel;
import com.theknight.fandom.lib.CustomAnimationAdapter;
import com.theknight.fandom.lib.Divider;
import com.theknight.fandom.lib.NetworkChangeListener;
import com.theknight.fandom.lib.RetrofitClient;
import com.theknight.fandom.lib.RightDrawableOnTouchListener;
import com.theknight.fandom.lib.Util;

import java.util.List;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    RecyclerView recyclerView;
    TextInputEditText search;
    Context context;
    NetworkChangeListener networkChangeListener = new NetworkChangeListener();


    @SuppressLint("ClickableViewAccessibility")
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
        this.search = findViewById(R.id.search_item);

        RetrofitClient rt = new RetrofitClient();

        MovieCall movieCall = rt.getRetrofitInstance("https://omg-db.herokuapp.com/").create(MovieCall.class);
        Log.d(TAG, "onCreate: retrofit instance done");
        Log.d(TAG, "onCreate: castcall" + movieCall.toString());
        Call<List<MovieModel>> call = movieCall.getMovie();
//        Log.d(TAG, "onCreate: call " + call.toString());
//        Log.d(TAG, "onCreate: " + call.request());

        call.enqueue(new Callback<List<MovieModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<MovieModel>> call, @NonNull Response<List<MovieModel>> response) {
//                System.out.println("Code :" + response.code());
                if (response.code() != 200) {
                    System.out.println("Code : " + response.code());


                }
                List<MovieModel> items = response.body();
                if (items != null) {
//                    Log.d(TAG, "onResponse: Items are filled");


//                    ;
//                    List<Character> characters = new ArrayList<>();
//                    characters.add(new Character(items.getName(),items.getAge(),items.getUrl()));

                    setAdapter(items);
//                    Log.d(TAG, "onResponse: character added by url");


                }

            }

            @Override
            public void onFailure(@NonNull Call<List<MovieModel>> call, @NonNull Throwable t) {

//                Log.d(TAG, "onFailure: Character added failed " + call.toString());
                new AestheticDialog.Builder(getParent(), DialogStyle.CONNECTIFY, DialogType.ERROR)
                        .setTitle("Network unavailable")
                        .setMessage("No internet connection")
                        .setDuration(2000)
                        .setOnClickListener(new OnDialogClickListener() {
                            @Override
                            public void onClick(@NonNull AestheticDialog.Builder builder) {
                                builder.dismiss();

                            }
                        }).show();

                System.out.println(t.getLocalizedMessage());

            }

        });


        this.search.setOnTouchListener(new RightDrawableOnTouchListener(search) {
            @Override
            public boolean onDrawableTouch(final MotionEvent event) {
                Toast.makeText(context, "Hello", Toast.LENGTH_SHORT).show();
                return onClickSearch(search, event);
            }
        });


    }

    private boolean onClickSearch(View view, MotionEvent event) {
        Toast.makeText(context, "Hello drawble", Toast.LENGTH_SHORT).show();
        // do something
        event.setAction(MotionEvent.ACTION_CANCEL);
        return false;
    }

    public void setAdapter(List<MovieModel> data) {
        ItemAdapter adapter = new ItemAdapter(this, data);


//        Log.d(TAG, "onCreate: Adapter set");
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
//        Log.d(TAG, "onCreate: Set final adapter");


    }


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