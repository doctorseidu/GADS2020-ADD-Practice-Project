package com.nnems.gads2020leaderboardapp.models;

public class Project {

    String firstname;
    String lastname;
    String email;
    String project_link;

    public Project(String firstname, String lastname, String email, String project_link) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.project_link = project_link;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProject_link() {
        return project_link;
    }

    public void setProject_link(String project_link) {
        this.project_link = project_link;
    }
}
