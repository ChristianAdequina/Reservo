package com.example.reservo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HomePage extends AppCompatActivity {

    ImageButton rFi, rH, rL, rG, rT, rFo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        rFi = (ImageButton) findViewById(R.id.reservofitness);
        rH = (ImageButton) findViewById(R.id.reservohealth);
        rL = (ImageButton) findViewById(R.id.reservolens);
        rG = (ImageButton) findViewById(R.id.reservoglam);
        rT = (ImageButton) findViewById(R.id.reservotravel);
        rFo = (ImageButton) findViewById(R.id.reservofood);

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