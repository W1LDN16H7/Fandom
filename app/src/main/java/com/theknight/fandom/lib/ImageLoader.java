package com.theknight.fandom.lib;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.squareup.picasso.Picasso;

public class ImageLoader {

    public void loadImage(Context context, ImageView imageView, String url){
        Glide.with(context)
                .load(url)
                .thumbnail(0.09f)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .into(imageView);

    }
}
