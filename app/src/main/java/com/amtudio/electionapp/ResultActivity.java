package com.amtudio.electionapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    private RecyclerView candidateVoteList;
    private CandidateVotesAdapter candidateVotesAdapter;
    private ArrayList<Candidate> candidateArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        candidateVoteList = findViewById(R.id.candidateVoteList);

        candidateArrayList = new ArrayList<>();

        candidateVotesAdapter = new CandidateVotesAdapter(this, ResultActivity.this, candidateArrayList);
        candidateVoteList.setLayoutManager(new LinearLayoutManager(this));
        candidateVoteList.setAdapter(candidateVotesAdapter);

        getCandidatesList();
    }

    private void getCandidatesList()
    {
        Utils.getCandidateList(candidateArrayList);
        candidateVotesAdapter.notifyDataSetChanged();
    }
}