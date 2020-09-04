package com.nnems.gads2020leaderboardapp.models;

public class SkillIQLeader {


    String name;
    int score;
    String country;
    String badgeUrl;

    public SkillIQLeader() { }

    public SkillIQLeader(String name, int score, String country, String badgeUrl) {
        this.name = name;
        this.score = score;
        this.country = country;
        this.badgeUrl = badgeUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBadgeUrl() { return badgeUrl; }

    public void setBadgeUrl(String badgeUrl) { this.badgeUrl = badgeUrl; }
}
