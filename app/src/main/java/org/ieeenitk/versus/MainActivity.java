package org.ieeenitk.versus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;
import java.lang.String;
import android.content.Intent;
public class MainActivity extends AppCompatActivity {

    public int count=0;
    TextView mtextview;
    TextView mtext;
    Button button;
    String[] questions;
    String[] answers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button) findViewById(R.id.submit);
        mtext=findViewById(R.id.code);
        Intent i = getIntent();
        String leagueID = i.getStringExtra ("LeagueID");
        mtextview=(TextView) findViewById(R.id.quest);

        questions = getQuestions(leagueID);
        answers = getAnswers(leagueID);
        button.setText("Start");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button.setText("Submit");
                if(count<5){
                    mtextview.setText(questions[count]);
                }
                else{
                    mtextview.setText("GameOverrr");
                    button.setEnabled(false);
                }
                count++;
            }
        });

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
