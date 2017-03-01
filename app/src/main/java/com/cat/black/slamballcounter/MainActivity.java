package com.cat.black.slamballcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

// --- App variables
    int scoreTeamA = 0;
    int slamTeamA = 0;
    int scoreTeamB = 0;
    int slamTeamB = 0;

// --- SaveState key constants
    public static final String SAVE_SCORE_TEAM_A = "saveScoreTeamA";
    public static final String SAVE_SLAM_TEAM_A = "saveSlamTeamA";
    public static final String SAVE_SCORE_TEAM_B = "saveScoreTeamB";
    public static final String SAVE_SLAM_TEAM_B = "saveSlamTeamB";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Reset Layer handlers

        final RelativeLayout rsLayer = (RelativeLayout) findViewById(R.id.reset_layer);

        final View reveal = findViewById(R.id.reveal_reset_layer);
        reveal.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {
                rsLayer.setVisibility(View.VISIBLE);
            }
        });

        final View proceedReset = findViewById(R.id.layer_red_reset);
        proceedReset.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {
                scoreTeamA = 0;
                slamTeamA = 0;
                scoreTeamB = 0;
                slamTeamB = 0;
                displayAllScores();
                rsLayer.setVisibility(View.GONE);
            }
        });

        final View returnReset = findViewById(R.id.layer_green_keep);
        returnReset.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {
                rsLayer.setVisibility(View.GONE);
            }
        });
    }

// --- Update all score displays method

    private void displayAllScores() {
        displayScoreTeamA(scoreTeamA);
        displaySlamTeamA(slamTeamA);
        displayScoreTeamB(scoreTeamB);
        displaySlamTeamB(slamTeamB);
    }

// --- Click methods for buttons in Team A

    public void slammedTeamA (View v){
        scoreTeamA = scoreTeamA + 3;
        slamTeamA = slamTeamA + 1;
        displayScoreTeamA(scoreTeamA);
        displaySlamTeamA(slamTeamA);}
    public void basketTeamA (View v){
        scoreTeamA = scoreTeamA + 2;
        displayScoreTeamA(scoreTeamA);}
    public void lineTeamA (View v){
        scoreTeamA = scoreTeamA + 3;
        displayScoreTeamA(scoreTeamA);}

// --- Click methods for buttons in Team B

    public void slammedTeamB (View v){
        scoreTeamB = scoreTeamB + 3;
        slamTeamB = slamTeamB + 1;
        displayScoreTeamB(scoreTeamB);
        displaySlamTeamB(slamTeamB);}
    public void basketTeamB (View v){
        scoreTeamB = scoreTeamB + 2;
        displayScoreTeamB(scoreTeamB);}
    public void lineTeamB (View v){
        scoreTeamB = scoreTeamB + 3;
        displayScoreTeamB(scoreTeamB);}

// --- Display methods for Team A and B

    public void displayScoreTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    public void displaySlamTeamA(int slam) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_slam);
        scoreView.setText(String.valueOf(slam));
    }
    public void displayScoreTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
    public void displaySlamTeamB(int slam) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_slam);
        scoreView.setText(String.valueOf(slam));
    }

// --- Back button handler

    @Override
    public void onBackPressed () {
        final RelativeLayout rsLayer = (RelativeLayout) findViewById(R.id.reset_layer);

        if (rsLayer.getVisibility() == View.VISIBLE) {
            rsLayer.setVisibility(View.GONE);
        } else {
            super.onBackPressed();
        }
    }

// --- Preserve data methods

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SAVE_SCORE_TEAM_A, scoreTeamA);
        outState.putInt(SAVE_SLAM_TEAM_A, slamTeamA);
        outState.putInt(SAVE_SCORE_TEAM_B, scoreTeamB);
        outState.putInt(SAVE_SLAM_TEAM_B, slamTeamB);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        scoreTeamA = savedInstanceState.getInt(SAVE_SCORE_TEAM_A);
        slamTeamA = savedInstanceState.getInt(SAVE_SLAM_TEAM_A);
        scoreTeamB = savedInstanceState.getInt(SAVE_SCORE_TEAM_B);
        slamTeamB = savedInstanceState.getInt(SAVE_SLAM_TEAM_B);
        displayAllScores();
    }
}
