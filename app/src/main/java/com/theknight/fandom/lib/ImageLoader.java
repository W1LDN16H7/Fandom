package com.theknight.fandom.lib;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.theknight.fandom.R;

public class ImageLoader {

    private static final String TAG = "Imageloader";

    public void loadImage(Context context, ImageView imageView, String url) {
        try {
            Glide.with(context)

                    .load(url)
                    .apply(new RequestOptions().override(200, 200).error(R.drawable.not_found))


                    .thumbnail(0.09f)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imageView)
            ;
            Log.d(TAG, "loadImage: Image loaded");

        } catch (Exception e) {
            Log.d(TAG, "loadImage: " + e.getMessage());

        }


    }
}
