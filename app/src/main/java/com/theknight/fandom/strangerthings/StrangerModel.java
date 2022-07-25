package com.theknight.fandom.strangerthings;

import androidx.annotation.NonNull;

import java.util.List;

public class StrangerModel {

    private List<String> aliases;
    private List<String> otherRelations;
    private String name;
    private String status;
    private String born;
    private String gender;
    private String eyeColor;
    private String hairColor;
    private String portrayedBy;
    private String photo;
    private List<String> residence;
    private List<String> occupation;

    public List<String> getAliases() {
        return aliases;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    public List<String> getOtherRelations() {
        return otherRelations;
    }

    public void setOtherRelations(List<String> otherRelations) {
        this.otherRelations = otherRelations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getPortrayedBy() {
        return portrayedBy;
    }

    public void setPortrayedBy(String portrayedBy) {
        this.portrayedBy = portrayedBy;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<String> getResidence() {
        return residence;
    }

    public void setResidence(List<String> residence) {
        this.residence = residence;
    }

    public List<String> getOccupation() {
        return occupation;
    }

    public void setOccupation(List<String> occupation) {
        this.occupation = occupation;
    }

    @NonNull
    @Override
    public String toString() {
        return "StrangerModel{" +
                "aliases=" + aliases +
                ", otherRelations=" + otherRelations +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", born='" + born + '\'' +
                ", gender='" + gender + '\'' +
                ", eyeColor='" + eyeColor + '\'' +
                ", hairColor='" + hairColor + '\'' +
                ", portrayedBy='" + portrayedBy + '\'' +
                ", photo='" + photo + '\'' +
                ", residence='" + residence + '\'' +
                ", occupation=" + occupation +
                '}';
    }
}
