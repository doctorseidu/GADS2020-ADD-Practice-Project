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
import com.nnems.gads2020leaderboardapp.adapters.SkillIQLeaderRecyclerAdapter;
import com.nnems.gads2020leaderboardapp.api.LeaderboardApi;
import com.nnems.gads2020leaderboardapp.models.SkillIQLeader;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class SkillIQLeadersFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private SkillIQLeaderRecyclerAdapter mSkillIQLeaderRecyclerAdapter;
//    private Context mContext = getActivity();
    private ArrayList<SkillIQLeader> mSkillIQLeaderList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_skill_iq_leaders, container, false);
        mRecyclerView = view.findViewById(R.id.list_iq_leaders);
        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mSkillIQLeaderList = new ArrayList<SkillIQLeader>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(LeaderboardApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        LeaderboardApi leaderboardApi = retrofit.create(LeaderboardApi.class);


        Call<List<SkillIQLeader>> call = leaderboardApi.getSkillIQLeaders();


        call.enqueue(new Callback<List<SkillIQLeader>>() {
            @Override
            public void onResponse(Call<List<SkillIQLeader>> call, Response<List<SkillIQLeader>> response) {
                List<SkillIQLeader> skillIQLeadersList = response.body();

                Log.i("size: " , Integer.toString(skillIQLeadersList.size()));
                for(int i = 0; i<skillIQLeadersList.size();i++){
                    mSkillIQLeaderList.add(skillIQLeadersList.get(i));
                }
                mRecyclerView.setLayoutManager(mLinearLayoutManager);
                mSkillIQLeaderRecyclerAdapter = new SkillIQLeaderRecyclerAdapter (getActivity(),mSkillIQLeaderList);
                mRecyclerView.setAdapter(mSkillIQLeaderRecyclerAdapter);

            }

            @Override
            public void onFailure(Call<List<SkillIQLeader>> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });



        return view;
    }


}