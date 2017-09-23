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
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button.setText("Submit");
                count++;
                if(count==1){
                    mtextview.setText("What is the bleh bleh bleh");
                }
                else if(count==2){
                    mtextview.setText("Question two");
                }
                else if(count==3){
                    mtextview.setText("gdhhdh");
                }
                else if(count==4){
                    mtextview.setText("question 4");
                }
                else if(count==5){
                    mtextview.setText("question5");
                }
                else{
                    mtextview.setText("GameOverrr");
                    button.setVisibility(View.INVISIBLE);
                }
            }
        });

    }


}
