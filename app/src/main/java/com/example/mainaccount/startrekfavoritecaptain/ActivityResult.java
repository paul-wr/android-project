package com.example.mainaccount.startrekfavoritecaptain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityResult extends AppCompatActivity {
    CaptainVote captainVote = new CaptainVote();
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Button homeBtn = (Button) findViewById(R.id.home_button);
        Button mediaBtn = (Button) findViewById(R.id.media_button);


        tvResult = (TextView) findViewById(R.id.resultText);

        String fav = "Favorite Captain Result: Captain "+captainVote.computeFavCaptain()+"!";


        tvResult.setText(fav);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ActivityResult.this, MainActivity.class);
                startActivity(i);
            }
        });

        mediaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ActivityResult.this, ActivityMedia.class);
                startActivity(i);
            }
        });



    }
}
