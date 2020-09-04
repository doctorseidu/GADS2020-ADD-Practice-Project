package com.nnems.gads2020leaderboardapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.nnems.gads2020leaderboardapp.R;
import com.nnems.gads2020leaderboardapp.adapters.LearningLeaderRecyclerAdapter;
import com.nnems.gads2020leaderboardapp.api.LeaderboardApi;
import com.nnems.gads2020leaderboardapp.models.LearningLeader;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class LearningLeadersFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private LearningLeaderRecyclerAdapter mLearningLeaderRecyclerAdapter;
//    private Context mContext = getActivity();
    private ArrayList<LearningLeader> mLearningLeaderList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_learning_leaders, container, false);
        mRecyclerView = view.findViewById(R.id.list_learning_leaders);
        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mLearningLeaderList = new ArrayList<LearningLeader>();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(LeaderboardApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        LeaderboardApi leaderboardApi = retrofit.create(LeaderboardApi.class);


        Call<List<LearningLeader>> call = leaderboardApi.getLearningLeaders();


       call.enqueue(new Callback<List<LearningLeader>>() {
           @Override
           public void onResponse(Call<List<LearningLeader>> call, Response<List<LearningLeader>> response) {

               List<LearningLeader> learningLeaderList = response.body();
               Log.i("size: " , Integer.toString(learningLeaderList.size()));
               for(int i = 0; i<learningLeaderList.size();i++){
                   mLearningLeaderList.add(learningLeaderList.get(i));
               }
               mRecyclerView.setLayoutManager(mLinearLayoutManager);
               mLearningLeaderRecyclerAdapter = new LearningLeaderRecyclerAdapter(getActivity(),mLearningLeaderList);
               mRecyclerView.setAdapter(mLearningLeaderRecyclerAdapter);


           }

           @Override
           public void onFailure(Call<List<LearningLeader>> call, Throwable t) {
               Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
           }
       });


        return view;
    }

}