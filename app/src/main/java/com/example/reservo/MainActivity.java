package com.example.reservo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        //Check if app is opened for the first time
//        SharedPreferences preferences = getSharedPreferences("PREFERENCE", MODE_PRIVATE);
//        String FirstTime = preferences.getString("FirstTimeInstall", "");
//
//        if(FirstTime.equals("Yes")) {
//            //If app opened for the first time, go to startup page
//            Intent intent = new Intent(MainActivity.this, Login.class);
//            startActivity(intent);
//        }
//        else {
//            //Else go directly to login
//            SharedPreferences.Editor editor = preferences.edit();
//            editor.putString("FirstTimeInstall", "Yes");
//            editor.apply();
//        }

        btn = (Button) findViewById(R.id.btnStart);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogin();
            }
        });
    }

    public void openLogin() {
//        Intent intent = new Intent(this, Login.class);
//        startActivity(intent);

        Intent i = new Intent(this, Login.class);
        startActivity(i);
    }
}