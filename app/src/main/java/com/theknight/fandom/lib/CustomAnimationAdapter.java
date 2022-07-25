package com.theknight.fandom.lib;

import android.view.animation.OvershootInterpolator;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;

public class CustomAnimationAdapter {
    public static AlphaInAnimationAdapter setAnimationAdapter(AlphaInAnimationAdapter adapter) {


        adapter.setInterpolator(new OvershootInterpolator());
        adapter.setFirstOnly(false);
        adapter.setDuration(1000);

        return adapter;


    }


}
