package com.nnems.gads2020leaderboardapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nnems.gads2020leaderboardapp.R;
import com.nnems.gads2020leaderboardapp.models.SkillIQLeader;

import java.util.ArrayList;

public class SkillIQLeaderRecyclerAdapter extends RecyclerView.Adapter<SkillIQLeaderRecyclerAdapter.ViewHolder> {
    private final ArrayList<SkillIQLeader> mSkillIQLeaderList;
    private final Context mContext;
    private final LayoutInflater mLayoutInflater;

    public SkillIQLeaderRecyclerAdapter(Context context,ArrayList<SkillIQLeader> skillIQLeader) {
        mSkillIQLeaderList = skillIQLeader;
        mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.skilliq_leader_item, parent, false);
        return new ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String score_country = mSkillIQLeaderList.get(position).getScore()+" skill IQ Score"+", "+
                mSkillIQLeaderList.get(position).getCountry();
        holder.mTextName.setText(mSkillIQLeaderList.get(position).getName());
        holder.mTextScore_Country.setText(score_country);

    }

    @Override
    public int getItemCount() {
        return mSkillIQLeaderList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public final TextView mTextName;
        public final TextView mTextScore_Country;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextName = itemView.findViewById(R.id.name_textview);
            mTextScore_Country = itemView.findViewById(R.id.score_country_textview);

        }
    }
}


