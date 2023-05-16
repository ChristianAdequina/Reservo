package com.example.reservo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OTP extends AppCompatActivity {
    EditText otp;
    Button btnConf;
    String o;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String num = getIntent().getStringExtra("RETRIEVENUMBER");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        otp = (EditText) findViewById(R.id.otpCode);
        btnConf = (Button) findViewById(R.id.btnConfCode);
        btnConf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                o = otp.getText().toString();
                String otpcode = "012345";
                if(o.equals(otpcode)) {
                    Intent intent = new Intent(getApplicationContext(), RePass.class);
                    intent.putExtra("RETRIEVENUMBER", num);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Invalid OTP code.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}