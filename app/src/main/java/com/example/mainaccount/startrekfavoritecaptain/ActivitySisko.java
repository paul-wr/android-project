package com.example.mainaccount.startrekfavoritecaptain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class ActivitySisko extends AppCompatActivity {
    SeekBar sb;
    TextView tv;
    CaptainVote captainVote;
    int seekValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sisko);

        sb = (SeekBar) findViewById(R.id.seekBarS);
        tv = (TextView) findViewById(R.id.textViewS);
        Button vote = (Button) findViewById(R.id.buttonVoteS);
        Button next = (Button) findViewById(R.id.buttonNextS);
        Button home = (Button) findViewById(R.id.homeBtn);
        captainVote = new CaptainVote();





        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                tv.setText(String.valueOf("CAPTAIN SISKO VOTE: "+progress+"%"));
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

        vote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                captainVote.setSisko("Sisko", seekValue);
                Toast.makeText(getApplicationContext(), "Vote is set! Click Next", Toast.LENGTH_SHORT).show();



            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ActivitySisko.this, ActivityJaneway.class);
                startActivity(i);

            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ActivitySisko.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
