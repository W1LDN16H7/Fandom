package com.theknight.fandom.starwars;

import com.google.gson.annotations.SerializedName;

public class Character {

    @SerializedName("image")
    public String url;
    private String name;
    private String age;

    public Character(String name, String age, String url) {
        this.name = name;
        this.age = age;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
