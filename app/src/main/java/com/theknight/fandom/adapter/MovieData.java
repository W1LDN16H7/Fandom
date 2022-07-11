package com.theknight.fandom.adapter;

import android.graphics.drawable.Drawable;

public class MovieData {

    public static final int VIEW_TYPE_TEXT = 0;
    public static final int VIEW_TYPE_IMAGE = 1;
    private String title;

    private String desc;
    private int image;


    public MovieData(String title, String desc, int image) {
        this.title = title;
        this.desc = desc;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
