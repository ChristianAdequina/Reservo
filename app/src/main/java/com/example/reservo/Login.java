package com.example.reservo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {

    TextView signup, forgotpw;
    EditText email, pw;
    String e, p;
    Button btnLogin;

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

        email = (EditText) findViewById(R.id.username);
        pw = (EditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e = email.getText().toString();
                p = pw.getText().toString();
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url ="http://10.0.2.2/reservo/login.php";
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if(response.equals("success")) {
                                    Toast.makeText(getApplicationContext(), "Login successful!", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), HomePage.class);
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
                        paramV.put("email", e);
                        paramV.put("password", p);
                        return paramV;
                    }
                };
                queue.add(stringRequest);
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

    public void openHome() {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
}