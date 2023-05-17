package com.example.reservo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomePage extends AppCompatActivity {

    ImageButton rFi, rH, rL, rG, rT, rFo;
    FirebaseAuth auth;
    FirebaseUser user;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        rFi = (ImageButton) findViewById(R.id.reservofitness);
        rH = (ImageButton) findViewById(R.id.reservohealth);
        rL = (ImageButton) findViewById(R.id.reservolens);
        rG = (ImageButton) findViewById(R.id.reservoglam);
        rT = (ImageButton) findViewById(R.id.reservotravel);
        rFo = (ImageButton) findViewById(R.id.reservofood);
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });

        if(user == null) {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        }

        rL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ReservoLens.class);
                startActivity(i);
            }
        });

        rH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RHealthIntro.class);
                startActivity(intent);
            }
        });
    }
}