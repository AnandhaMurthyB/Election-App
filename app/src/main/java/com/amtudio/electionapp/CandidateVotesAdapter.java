package com.amtudio.electionapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CandidateVotesAdapter extends RecyclerView.Adapter<CandidateVotesAdapter.CandidateVotesViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList<Candidate> candidateArrayList;
    private Utils utils;

    public CandidateVotesAdapter(Context context, Activity activity, ArrayList<Candidate> candidateArrayList)
    {
        this.context = context;
        this.activity = activity;
        this.candidateArrayList = candidateArrayList;
        this.utils = new Utils();
    }

    @NonNull
    @Override
    public CandidateVotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_candidate_votes_layout, parent, false);
        return new CandidateVotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CandidateVotesViewHolder holder, int position) {

        Candidate candidate = candidateArrayList.get(position);

        holder.candidateName.setText(candidate.getName());
        holder.candidateSymbol.setImageResource(candidate.getSymbol());
        holder.candidateVotes.setText(utils.getCandidateVote(activity, position + 1)+"");
    }

    @Override
    public int getItemCount() {
        return candidateArrayList.size();
    }

    public class CandidateVotesViewHolder extends RecyclerView.ViewHolder {

        private TextView candidateName;
        private ImageView candidateSymbol;
        private TextView candidateVotes;

        public CandidateVotesViewHolder(@NonNull View itemView) {
            super(itemView);

            candidateName = itemView.findViewById(R.id.candidateName);
            candidateSymbol = itemView.findViewById(R.id.candidateSymbol);
            candidateVotes = itemView.findViewById(R.id.candidateVotes);
        }
    }
}
