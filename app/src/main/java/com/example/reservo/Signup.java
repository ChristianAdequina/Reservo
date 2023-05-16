package com.example.reservo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Signup extends AppCompatActivity {

    EditText fName, lName, pNo, email, pw, confpw;
    Button btnRegister;
    String fn, ln, pn, e, passw, cpw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        fName = (EditText) findViewById(R.id.createFname);
        lName = (EditText) findViewById(R.id.createLname);
        pNo = (EditText) findViewById(R.id.createPhone);
        email = (EditText) findViewById(R.id.createEmail);
        pw = (EditText) findViewById(R.id.createPassword);
        confpw = (EditText) findViewById(R.id.confirmPassword);

        btnRegister = (Button) findViewById(R.id.btnRgstr);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fn = fName.getText().toString();
                ln = lName.getText().toString();
                pn = pNo.getText().toString();
                e = email.getText().toString();
                passw = pw.getText().toString();
                cpw = confpw.getText().toString();

                if(passw.equals(cpw)) {
                    RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                    String url ="http://10.0.2.2/reservo/register.php";
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    if(response.equals("success")) {
                                        Toast.makeText(getApplicationContext(), "Registration successful!", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), Login.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                    else {
                                        Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getApplicationContext(), error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }){
                        protected Map<String, String> getParams(){
                            Map<String, String> paramV = new HashMap<>();
                            paramV.put("firstName", fn);
                            paramV.put("lastName", ln);
                            paramV.put("phoneNumber", pn);
                            paramV.put("email", e);
                            paramV.put("password", passw);
                            return paramV;
                        }
                    };
                    queue.add(stringRequest);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Passwords do not match. Try again.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}