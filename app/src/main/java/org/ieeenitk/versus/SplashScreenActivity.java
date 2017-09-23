package org.ieeenitk.versus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        findViewById(R.id.button_proceed).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String id = ((EditText)findViewById(R.id.text_input)).getText().toString();
                if (!(id.equals("slot1") || id.equals("slot2") || id.equals("slot3") || id.equals("slot4"))) {
                    Toast.makeText(SplashScreenActivity.this, "Invalid League Code!", Toast.LENGTH_LONG).show();
                    return;
                }
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                intent.putExtra("LeagueID", id);
                startActivity(intent);
                finish();
            }
        });

        findViewById(R.id.button_instructions).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SplashScreenActivity.this,Instructions.class));
            }
        });


    }
}
