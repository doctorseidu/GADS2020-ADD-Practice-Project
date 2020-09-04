package com.nnems.gads2020leaderboardapp.models;

import com.google.gson.annotations.SerializedName;

public class LearningLeader {


    String name;
    int hours;
    String country;
    String badge;


    public LearningLeader(String name, int hours, String country, String badge) {
        this.name = name;
        this.hours = hours;
        this.country = country;
        this.badge = badge;
    }

    public LearningLeader() { }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBadge() { return badge; }

    public void setBadge(String badge) { this.badge = badge; }
}
