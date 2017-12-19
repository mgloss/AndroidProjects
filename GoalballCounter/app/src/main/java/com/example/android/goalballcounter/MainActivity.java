package com.example.android.goalballcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.android.goalballcounter.R;

public class MainActivity extends AppCompatActivity {
    int scoreA = 0;
    int scoreB = 0;
    int penaltyA = 0;
    int penaltyB = 0;
    int penaltyGoalA = 0;
    int penaltyGoalB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void addGoalA(View View) {
        scoreA = scoreA + 1;
        displayForTeamA(scoreA);
    }
    public void addPenaltyA(View View) {
        penaltyA = penaltyA + 1;
        displayPenaltyForTeamA(penaltyA);
    }
    public void addPenaltyGoalA(View View) {
        scoreA = scoreA + 1;
        penaltyGoalA = penaltyGoalA + 1;
        displayForTeamA(scoreA);
        displayPenaltyGoalForTeamA(penaltyGoalA);
    }

    public void resetScore(View View) {
        scoreA = 0;
        scoreB = 0;
        penaltyA = 0;
        penaltyB = 0;
        penaltyGoalA = 0;
        penaltyGoalB = 0;
        displayForTeamA(scoreA);
        displayForTeamB(scoreB);
        displayPenaltyForTeamA(penaltyA);
        displayPenaltyForTeamB(penaltyB);
        displayPenaltyGoalForTeamA(penaltyGoalA);
        displayPenaltyGoalForTeamB(penaltyGoalB);
    }
    public void addGoalB(View View) {
        scoreB = scoreB + 1;
        displayForTeamB(scoreB);
    }
    public void addPenaltyB(View View) {
        penaltyB = penaltyB + 1;
        displayPenaltyForTeamB(penaltyB);
    }
    public void addPenaltyGoalB(View View) {
        scoreB = scoreB + 1;
        penaltyGoalB = penaltyGoalB + 1;
        displayForTeamB(scoreB);
        displayPenaltyGoalForTeamB(penaltyGoalB);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    public void displayPenaltyForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score_penalty);
        scoreView.setText(String.valueOf(score));
    }
    public void displayPenaltyGoalForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score_penalty_goal);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
    public void displayPenaltyForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score_penalty);
        scoreView.setText(String.valueOf(score));
    }
    public void displayPenaltyGoalForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score_penalty_goal);
        scoreView.setText(String.valueOf(score));
    }


}
