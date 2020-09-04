package com.nnems.gads2020leaderboardapp.api;

import com.nnems.gads2020leaderboardapp.models.LearningLeader;
import com.nnems.gads2020leaderboardapp.models.SkillIQLeader;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface LeaderboardApi {
    String BASE_URL = "https://gadsapi.herokuapp.com";

    @GET("/api/hours")
    Call<List<LearningLeader>> getLearningLeaders();

    @GET("/api/skilliq")
    Call<List<SkillIQLeader>> getSkillIQLeaders();


}
