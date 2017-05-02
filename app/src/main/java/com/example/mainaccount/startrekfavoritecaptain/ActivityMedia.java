package com.example.mainaccount.startrekfavoritecaptain;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ActivityMedia extends AppCompatActivity {
    ImageView iv;
    Animation animation;
    private FirebaseDatabase database;
    DatabaseReference databaseRef;
    EditText fanRegET;
    String fanName;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);


        Button stClipBtn = (Button) findViewById(R.id.buttonSTClip);
        Button cameraBtn = (Button) findViewById(R.id.cameraButton);
        Button connectOnlineBtn = (Button) findViewById(R.id.connectOnline);
        Button warpBtn = (Button) findViewById(R.id.warp_button);
        Button cloakBtn = (Button) findViewById(R.id.cloak_button);
        Button fanReg = (Button) findViewById(R.id.fanRegister);



        database = FirebaseDatabase.getInstance();
        databaseRef = database.getReference("Fan Listings");


        iv = (ImageView) findViewById(R.id.image_starship);

        // set EditText
        fanRegET = (EditText) findViewById(R.id.fanRegisterEdit);


        // onclick records the Fan name and pushes it to the FireBase database
        fanReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fanName = fanRegET.getText().toString();

                databaseRef.push().setValue(fanName);

                // reset EditText field
                fanRegET.setText("");

                // Send Toast message to user
                Toast.makeText(getApplicationContext(), "Your name has been added to our Fan List!", Toast.LENGTH_SHORT).show();

            }
        });

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
