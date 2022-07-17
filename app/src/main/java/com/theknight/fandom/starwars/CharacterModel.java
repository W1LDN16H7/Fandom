package com.theknight.fandom.starwars;

import com.google.gson.annotations.SerializedName;

public class CharacterModel {

    private String name;
    private String height;
    private String mass;
    @SerializedName("hairColor")
    private String hair_color;
    @SerializedName("skinColor")
    private String skin_color;
    @SerializedName("eyeColor")
    private String eye_color;

    private String gender;


    private String homeworld;

    @SerializedName("image")
    private String url;
    private String born;
    private String died;
    @SerializedName("wiki")
    private String wiki_url;
    @SerializedName("bornLocation")
    private String born_location;
    @SerializedName("diedLocation")
    private String died_location;
    private String species;
    private String[] apprentices;
    private String[] affiliations;
    private String[] master;
    private String[] formerAffiliations;

    public String[] getMaster() {
        return master;
    }

    public void setMaster(String[] master) {
        this.master = master;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getHair_color() {
        return hair_color;
    }

    public void setHair_color(String hair_color) {
        this.hair_color = hair_color;
    }

    public String getSkin_color() {
        return skin_color;
    }

    public void setSkin_color(String skin_color) {
        this.skin_color = skin_color;
    }

    public String getEye_color() {
        return eye_color;
    }

    public void setEye_color(String eye_color) {
        this.eye_color = eye_color;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public String getDied() {
        return died;
    }

    public void setDied(String died) {
        this.died = died;
    }

    public String getWiki_url() {
        return wiki_url;
    }

    public void setWiki_url(String wiki_url) {
        this.wiki_url = wiki_url;
    }

    public String getBorn_location() {
        return born_location;
    }

    public void setBorn_location(String born_location) {
        this.born_location = born_location;
    }

    public String getDied_location() {
        return died_location;
    }

    public void setDied_location(String died_location) {
        this.died_location = died_location;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String[] getApprentices() {
        return apprentices;
    }

    public void setApprentices(String[] apprentices) {
        this.apprentices = apprentices;
    }

    public String[] getAffiliations() {
        return affiliations;
    }

    public void setAffiliations(String[] affiliations) {
        this.affiliations = affiliations;
    }


    public String[] getFormerAffiliations() {
        return formerAffiliations;
    }

    public void setFormerAffiliations(String[] formerAffiliations) {
        this.formerAffiliations = formerAffiliations;
    }
}

