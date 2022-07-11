package com.theknight.fandom.starwars;

public class Character {
    private String name;
    private String real_name;
    private int image;

    public Character(String name, String real_name, int image) {
        this.name = name;
        this.real_name = real_name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
