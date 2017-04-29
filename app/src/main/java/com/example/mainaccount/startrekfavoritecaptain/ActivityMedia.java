package com.example.mainaccount.startrekfavoritecaptain;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class ActivityMedia extends AppCompatActivity {
    ImageView iv;
    Animation animation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        Button stClipBtn = (Button) findViewById(R.id.buttonSTClip);
        Button cameraBtn = (Button) findViewById(R.id.cameraButton);
        Button connectOnlineBtn = (Button) findViewById(R.id.connectOnline);
        Button warpBtn = (Button) findViewById(R.id.warp_button);
        Button cloakBtn = (Button) findViewById(R.id.cloak_button);

        iv = (ImageView) findViewById(R.id.image_starship);



        warpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
                iv.startAnimation(animation);
                Toast.makeText(getApplicationContext(), "Warp Engines Engaged", Toast.LENGTH_SHORT).show();

            }
        });

        cloakBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
                iv.startAnimation(animation);
                Toast.makeText(getApplicationContext(), "Ships Cloak Engaged", Toast.LENGTH_SHORT).show();
            }
        });


        stClipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sUrl = "https://www.youtube.com/watch?v=bWD_9uMtHJo";
                Intent iBrowser = new Intent(Intent.ACTION_VIEW, Uri.parse(sUrl));
                startActivity(iBrowser);
            }
        });

        cameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ActivityMedia.this, ActivityDisplayPicture.class);
                startActivity(i);

            }
        });

        connectOnlineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sUrl = "http://www.startrek.com/";
                Intent iBrowser = new Intent(Intent.ACTION_VIEW, Uri.parse(sUrl));
                startActivity(iBrowser);

            }
        });




    }
}
