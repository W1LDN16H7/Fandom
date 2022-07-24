package com.theknight.fandom.lib;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.recyclerview.widget.DividerItemDecoration;

import com.theknight.fandom.R;


public class Divider {

    @SuppressLint("UseCompatLoadingForDrawables")
    public static DividerItemDecoration getDivider(Context context) {
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL);

        dividerItemDecoration.setDrawable(context.getResources().getDrawable(R.drawable.divider));
        return dividerItemDecoration;
    }


}
