package com.theknight.fandom.pirates;

import androidx.annotation.NonNull;

public class PiratesModel {
    private String name;
    private String gender;
    private String image;
    private String about;

    @NonNull
    @Override
    public String toString() {
        return "PiratesModel{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", image='" + image + '\'' +
                ", about='" + about + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
