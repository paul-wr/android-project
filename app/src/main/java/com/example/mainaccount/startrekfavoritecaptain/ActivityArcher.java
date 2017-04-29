package com.example.mainaccount.startrekfavoritecaptain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityArcher extends AppCompatActivity {
    // declare instance variables
    SeekBar sb;
    TextView tv;
    int seekValue;
    CaptainVote captainVote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archer);

        sb = (SeekBar) findViewById(R.id.seekBarA);
        tv = (TextView) findViewById(R.id.textViewA);
        Button vote = (Button) findViewById(R.id.buttonVoteA);
        Button next = (Button) findViewById(R.id.buttonNextA);
        Button home = (Button) findViewById(R.id.homeBtn);
        captainVote = new CaptainVote();



        // set onclick action for SeekBar
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                tv.setText(String.valueOf("CAPTAIN ARCHER VOTE: "+progress+"%"));
                seekValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
        });

        // set onclick action for vote button
        vote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                captainVote.setArcher("Archer", seekValue);
                Toast.makeText(getApplicationContext(), "Vote is set! Click Next", Toast.LENGTH_SHORT).show();

            }
        });

        // set onclick action for next button
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ActivityArcher.this, ActivityResult.class);
                startActivity(i);

            }
        });

        // set onclick action for home button
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ActivityArcher.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
