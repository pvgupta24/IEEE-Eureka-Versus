package org.ieeenitk.versus;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextClock;
import android.widget.TextView;
import java.lang.String;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public int count=-1;
    TextView mtextview, score;
    ProgressBar progressBar;
    Button button, next;
    EditText answerText;
    String[] questions, answers;
    CountDownTimer cdt = new CountDownTimer(180000, 1) {
        public void onTick(long millisUntilFinished) {
            progressBar.setProgress((int)millisUntilFinished);
        }

        public void onFinish() {
            Toast.makeText(MainActivity.this, "Time Up!", Toast.LENGTH_SHORT).show();
            next.setText("Next");
            button.setVisibility(View.INVISIBLE);
            next.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.submit);
        score = findViewById(R.id.score);
        next= findViewById(R.id.next);
        answerText = findViewById(R.id.answer);
        Intent i = getIntent();
        String leagueID = i.getStringExtra ("LeagueID");
        mtextview = findViewById(R.id.quest);
        progressBar = findViewById(R.id.progress_bar);

        questions = getQuestions(leagueID);
        answers = getAnswers(leagueID);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answerText.getText().toString().equals(""))
                    return;
                if (answerText.getText().toString().equals(answers[count])) {
                    int scoreVal = progressBar.getProgress() / 1000;
                    button.setVisibility(View.INVISIBLE);
                    score.setText("Correct, " + scoreVal + " points!");
                } else {
                    Toast.makeText(MainActivity.this, "Incorrect!", Toast.LENGTH_LONG).show();
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                button.setText("Submit");
                if (count == 0)
                    answerText.setVisibility(View.VISIBLE);
                    button.setVisibility(View.VISIBLE);
                if(count<5){
                    nextQuestion();
                }
                else{
                    mtextview.setText("Game Over");
                    answerText.setVisibility(View.INVISIBLE);
                    button.setVisibility(View.INVISIBLE);
                    next.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    public void nextQuestion(){
        progressBar.setVisibility(View.VISIBLE);
        cdt.cancel();
        // code for updating question and options goes here
        next.setVisibility(View.INVISIBLE);
        answerText.setText("");
        mtextview.setText(questions[count]);
        score.setText("");
        cdt.start();
    }

    private String[] getAnswers(String leagueID) {
        String[] qs;
        switch (leagueID) {
            case "slot1":
                qs = getResources().getStringArray(R.array.slot1A);
                break;
            case "slot2":
                qs = getResources().getStringArray(R.array.slot2A);
                break;
            case "slot3":
                qs = getResources().getStringArray(R.array.slot3A);
                break;
            case "slot4":
                qs = getResources().getStringArray(R.array.slot4A);
                break;
            default:
                qs = new String[5];
        }
        return qs;
    }

    private String[] getQuestions(String leagueID) {
        String[] qs;
        switch (leagueID) {
            case "slot1":
                qs = getResources().getStringArray(R.array.slot1);
                break;
            case "slot2":
                qs = getResources().getStringArray(R.array.slot2);
                break;
            case "slot3":
                qs = getResources().getStringArray(R.array.slot3);
                break;
            case "slot4":
                qs = getResources().getStringArray(R.array.slot4);
                break;
            default:
                qs = new String[5];
        }
        return qs;
    }
}
