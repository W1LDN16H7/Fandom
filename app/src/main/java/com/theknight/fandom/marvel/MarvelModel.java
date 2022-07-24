package com.theknight.fandom.marvel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MarvelModel {
    @SerializedName("Name")
    private String name;
    @SerializedName("Gender")
    private String gender;
    @SerializedName("Bio")
    private String bio;
    @SerializedName("Date_of_Birth")
    private String dob;
    @SerializedName("Date_of_Death")
    private String date_of_death;
    @SerializedName("Posters")
    private List<String> images;
    private String Title;
    private String Genre;
    private String Species;
    private String alternate_name;
    private String played_by;

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

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDate_of_death() {
        return date_of_death;
    }

    public void setDate_of_death(String date_of_death) {
        this.date_of_death = date_of_death;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getSpecies() {
        return Species;
    }

    public void setSpecies(String species) {
        Species = species;
    }

    public String getAlternate_name() {
        return alternate_name;
    }

    public void setAlternate_name(String alternate_name) {
        this.alternate_name = alternate_name;
    }

    public String getPlayed_by() {
        return played_by;
    }

    public void setPlayed_by(String played_by) {
        this.played_by = played_by;
    }

}
