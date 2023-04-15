package com.amtudio.electionapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView candidatesList;
    private Button viewResult;
    private ArrayList<Candidate> candidateArrayList;
    private CandidatesAdapter candidatesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        candidatesList = findViewById(R.id.candidateList);
        viewResult = findViewById(R.id.viewResult);

        viewResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                startActivity(intent);
            }
        });

        candidateArrayList = new ArrayList<>();

        candidatesAdapter = new CandidatesAdapter(this, MainActivity.this, candidateArrayList);
        candidatesList.setLayoutManager(new LinearLayoutManager(this));
        candidatesList.setAdapter(candidatesAdapter);

        getCandidatesList();
    }

    private void getCandidatesList()
    {
        Utils.getCandidateList(candidateArrayList);
        candidatesAdapter.notifyDataSetChanged();
    }
}