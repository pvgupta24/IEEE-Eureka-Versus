package org.ieeenitk.versus;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public int count=0;
    TextView mtextview;
    TextView mtext;
    Button button;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button) findViewById(R.id.submit);
        mtext=findViewById(R.id.code);
        Intent i = getIntent();
        String textval = i.getStringExtra ("LeagueID");
        mtextview=(TextView) findViewById(R.id.quest);
        button.setText("Start");
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button.setText("Submit");

                if(count == 0){
                    progressBar.setVisibility(View.VISIBLE);
                    findViewById(R.id.options).setVisibility(View.VISIBLE);
                    nextQuestion();
                    count++;
                }

//                else if(count==1){
//                    mtextview.setText("What is the bleh bleh bleh");
//                }
//                else if(count==2){
//                    mtextview.setText("Question two");
//                }
//                else if(count==3){
//                    mtextview.setText("gdhhdh");
//                }
//                else if(count==4){
//                    mtextview.setText("question 4");
//                }
//                else if(count==5){
//                    mtextview.setText("question5");
//
//                }
//                else{
//                    mtextview.setText("GameOverrr");
//                    button.setVisibility(View.INVISIBLE);
//                }

                // code for submitting the answer goes here (not updating the question)

            }
        });
    }


    // Updates the question and resets the timer
    // Needs to be called only once while starting the game

    void nextQuestion(){
        CountDownTimer cdt = new CountDownTimer(120000, 1) {

            public void onTick(long millisUntilFinished) {
                progressBar.setProgress((int)millisUntilFinished);
            }

            public void onFinish() {
                Toast.makeText(MainActivity.this, "Time Up!", Toast.LENGTH_SHORT).show();
                nextQuestion();
            }
        };

        // code for updating question and options goes here

        cdt.start();
    }


}
