package com.amtudio.electionapp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;

public class Utils {

    private Activity activity;

    public void saveCandidateVotes(Activity activity, int candidateID)
    {
        this.activity = activity;
        SharedPreferences sharedPref = activity.getSharedPreferences("ElectionApp", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(getCandidateName(candidateID), getCandidateVotes(candidateID) + 1);
        editor.apply();
    }

    public int getCandidateVote(Activity activity, int candidateID)
    {
        this.activity = activity;
        return getCandidateVotes(candidateID);
    }

    private String getCandidateName(int candidateID)
    {
        String candidateName = "";

        switch (candidateID)
        {
            case 1:
                candidateName = "Twitter";
                break;
            case 2:
                candidateName = "Facebook";
                break;
            case 3:
                candidateName = "Telegram";
                break;
            case 4:
                candidateName = "Whatsapp";
                break;
            default:
                candidateName = "NOTA";
                break;
        }

        return candidateName;
    }

    private int getCandidateVotes(int candidateID)
    {
        SharedPreferences sharedPref = this.activity.getSharedPreferences("ElectionApp", Context.MODE_PRIVATE);
        return sharedPref.getInt(getCandidateName(candidateID), 0);
    }

    public static void getCandidateList(ArrayList<Candidate> candidateArrayList)
    {
        Candidate candidate_1 = new Candidate();
        candidate_1.setName("Twitter");
        candidate_1.setSymbol(R.drawable.twitter);

        Candidate candidate_2 = new Candidate();
        candidate_2.setName("Facebook");
        candidate_2.setSymbol(R.drawable.fb);

        Candidate candidate_3 = new Candidate();
        candidate_3.setName("Telegram");
        candidate_3.setSymbol(R.drawable.telegram);

        Candidate candidate_4 = new Candidate();
        candidate_4.setName("Whatsapp");
        candidate_4.setSymbol(R.drawable.whatsapp);

        Candidate nota = new Candidate();
        nota.setName("NOTA");
        nota.setSymbol(R.drawable.nota);

        candidateArrayList.add(candidate_1);
        candidateArrayList.add(candidate_2);
        candidateArrayList.add(candidate_3);
        candidateArrayList.add(candidate_4);
        candidateArrayList.add(nota);
    }
}
