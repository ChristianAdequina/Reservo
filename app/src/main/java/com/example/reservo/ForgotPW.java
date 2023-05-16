package com.example.reservo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
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

public class ForgotPW extends AppCompatActivity {

    EditText fEmail;
    Button btnRtrvE;
    String e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pw);

        fEmail = (EditText) findViewById(R.id.retrieveEmail);
        btnRtrvE = (Button) findViewById(R.id.btnRtrvEmail);
        btnRtrvE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e = fEmail.getText().toString();
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url ="http://10.0.2.2/reservo/forgotpw.php";
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if(response.equals("success")) {
                                    Toast.makeText(getApplicationContext(), "Phone number found!", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), OTP.class);
                                    intent.putExtra("RETRIEVENUMBER", e);
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
                        paramV.put("phoneNumber", e);
                        return paramV;
                    }
                };
                queue.add(stringRequest);
            }
        });
    }
}