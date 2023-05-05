package com.example.reservo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    TextView signup, forgotpw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signup = (TextView) findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignup();
            }
        });

        forgotpw = (TextView) findViewById(R.id.forgotPW);
        forgotpw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openForgotPW();
            }
        });
    }

    public void openSignup() {
        Intent intent = new Intent(this, Signup.class);
        startActivity(intent);
    }

    public void openForgotPW() {
        Intent intent = new Intent(this, ForgotPW.class);
        startActivity(intent);
    }
}