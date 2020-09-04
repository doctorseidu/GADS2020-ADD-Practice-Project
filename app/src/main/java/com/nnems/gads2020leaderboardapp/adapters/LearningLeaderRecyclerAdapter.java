package com.nnems.gads2020leaderboardapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nnems.gads2020leaderboardapp.R;
import com.nnems.gads2020leaderboardapp.models.LearningLeader;


import java.util.ArrayList;

public class LearningLeaderRecyclerAdapter extends RecyclerView.Adapter<LearningLeaderRecyclerAdapter.ViewHolder>  {
    private final ArrayList<LearningLeader> mLearningLeadersList;
    private final Context mContext;
    private final LayoutInflater mLayoutInflater;

    public LearningLeaderRecyclerAdapter(Context context,ArrayList<LearningLeader> learningLeadersList) {
        mLearningLeadersList = learningLeadersList;
        mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public LearningLeaderRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.learning_leader_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull LearningLeaderRecyclerAdapter.ViewHolder holder, int position) {
        String hour_country = mLearningLeadersList.get(position).getHours() +" learning hours"+", "+
                mLearningLeadersList.get(position).getCountry();
        holder.mTextName.setText(mLearningLeadersList.get(position).getName());
        holder.mTextHours_Country.setText(hour_country);

    }

    @Override
    public int getItemCount() {
        return mLearningLeadersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public final TextView mTextName;
        public final TextView mTextHours_Country;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextName = itemView.findViewById(R.id.name_textview);
            mTextHours_Country= itemView.findViewById(R.id.hours_country_textview);
        }
    }
}
