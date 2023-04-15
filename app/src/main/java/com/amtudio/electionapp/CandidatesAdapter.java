package com.amtudio.electionapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CandidatesAdapter extends RecyclerView.Adapter<CandidatesAdapter.CandidateViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList<Candidate> candidateArrayList;
    private Utils utils;

    public CandidatesAdapter(Context context, Activity activity, ArrayList<Candidate> candidateArrayList)
    {
        this.context = context;
        this.activity = activity;
        this.candidateArrayList = candidateArrayList;
        this.utils = new Utils();
    }

    @NonNull
    @Override
    public CandidateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.single_candidate_layout, parent, false);

        return new CandidateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CandidateViewHolder holder, int position) {

        Candidate candidate = candidateArrayList.get(position);

        holder.candidateName.setText(candidate.getName());
        holder.candidateSymbol.setImageResource(candidate.getSymbol());

        holder.candidateVote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                utils.saveCandidateVotes(activity, position + 1);
                Toast.makeText(context, "You have voted for "+candidate.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return candidateArrayList.size();
    }

    public class CandidateViewHolder extends RecyclerView.ViewHolder{

        private TextView candidateName;
        private ImageView candidateSymbol;
        private Button candidateVote;


        public CandidateViewHolder(@NonNull View itemView) {
            super(itemView);

            candidateName = itemView.findViewById(R.id.candidateName);
            candidateSymbol = itemView.findViewById(R.id.candidateSymbol);
            candidateVote = itemView.findViewById(R.id.candidateVote);
        }
    }
}
