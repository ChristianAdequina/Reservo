package com.example.reservo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.StringRequest;
//import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Signup extends AppCompatActivity {

    EditText fName, lName, pNo, email, pw, confpw;
    Button btnRegister;
    FirebaseAuth mAuth;
    DatabaseReference user;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(getApplicationContext(), HomePage.class);
            startActivity(intent);
            finish();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mAuth = FirebaseAuth.getInstance();
        fName = (EditText) findViewById(R.id.createFname);
        lName = (EditText) findViewById(R.id.createLname);
        pNo = (EditText) findViewById(R.id.createPhone);
        email = (EditText) findViewById(R.id.createEmail);
        pw = (EditText) findViewById(R.id.createPassword);
        confpw = (EditText) findViewById(R.id.confirmPassword);

        btnRegister = (Button) findViewById(R.id.btnRgstr);
        user = FirebaseDatabase.getInstance().getReference().child("User");
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fn, ln, pn, e, passw, cpw;
                fn = fName.getText().toString();
                ln = lName.getText().toString();
                pn = pNo.getText().toString();
                e = email.getText().toString();
                passw = pw.getText().toString();
                cpw = confpw.getText().toString();

                if(TextUtils.isEmpty(fn) || TextUtils.isEmpty(ln) || TextUtils.isEmpty(pn) || TextUtils.isEmpty(e) || TextUtils.isEmpty(passw)|| TextUtils.isEmpty(cpw)) {
                    Toast.makeText(getApplicationContext(), "Please fill out all fields.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(passw.equals(cpw)) {
                    mAuth.createUserWithEmailAndPassword(e, passw)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getApplicationContext(), "Account successfully created!",
                                                Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), Login.class);
                                        startActivity(intent);
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText(getApplicationContext(), "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                    insertUserData();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Passwords don't match. Try again.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    public void insertUserData() {
        String fn, ln, pn, e;
        fn = fName.getText().toString();
        ln = lName.getText().toString();
        pn = pNo.getText().toString();
        e = email.getText().toString();

        User u = new User(fn, ln, pn, e);

        user.push().setValue(u);
    }
}

