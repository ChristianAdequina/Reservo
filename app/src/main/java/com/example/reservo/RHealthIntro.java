package com.example.reservo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RHealthIntro extends AppCompatActivity {

    Button btnMH, btnSkip;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rhealth_intro);

        //Check if app is opened for the first time
//        SharedPreferences preferences = getSharedPreferences("PREFERENCE", MODE_PRIVATE);
//        String FirstTime = preferences.getString("FirstTimeOpen", "");
//
//        if(FirstTime.equals("Yes")) {
//            //If app opened for the first time, go to startup page
//            Intent intent = new Intent(RHealthIntro.this, ReservoHealth.class);
//            startActivity(intent);
//        }
//        else {
//            //Else go directly to login
//            SharedPreferences.Editor editor = preferences.edit();
//            editor.putString("FirstTimeOpen", "Yes");
//            editor.apply();
//        }

        btnMH = (Button) findViewById(R.id.btnEnterMH);
        btnMH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMH();
            }
        });

        btnSkip = (Button) findViewById(R.id.btnSkipMH);
        builder = new AlertDialog.Builder(this);
        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setTitle("Note")
                        .setMessage("You can always edit your medical history in the menu tab.")
                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                openRH();
                            }
                        }).show();
            }
        });
    }

    public void openMH() {
        Intent intent = new Intent(this, MedHistory.class);
        startActivity(intent);
    }

    public void openRH() {
        Intent i = new Intent(this, HomePage.class);
        startActivity(i);
    }
}