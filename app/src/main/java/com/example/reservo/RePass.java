package com.example.reservo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

import java.util.HashMap;
import java.util.Map;

public class RePass extends AppCompatActivity {

    EditText newpw, newconfpw;
    Button btnNewPW;
    String npw, ncpw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String num = getIntent().getStringExtra("RETRIEVENUMBER");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_pass);

        newpw = (EditText) findViewById(R.id.newPW);
        newconfpw = (EditText) findViewById(R.id.confNewPW);

        btnNewPW = (Button) findViewById(R.id.btnConfCode);
//        btnNewPW.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                npw = newpw.getText().toString();
//                ncpw = newconfpw.getText().toString();
//
//                if(npw.equals(ncpw)) {
//                    RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
//                    String url ="http://10.0.2.2/reservo/newpw.php";
//                    StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
//                            new Response.Listener<String>() {
//                                @Override
//                                public void onResponse(String response) {
//                                    if(response.equals("success")) {
//                                        Toast.makeText(getApplicationContext(), "Update successful!", Toast.LENGTH_SHORT).show();
//                                        Intent intent = new Intent(getApplicationContext(), HomePage.class);
//                                        startActivity(intent);
//                                        finish();
//                                    }
//                                    else {
//                                        Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
//                                    }
//                                }
//                            }, new Response.ErrorListener() {
//                        @Override
//                        public void onErrorResponse(VolleyError error) {
//                            Toast.makeText(getApplicationContext(), error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//                        }
//                    }){
//                        protected Map<String, String> getParams(){
//                            Map<String, String> paramV = new HashMap<>();
//                            paramV.put("num", num);
//                            paramV.put("password", npw);
//                            return paramV;
//                        }
//                    };
//                    queue.add(stringRequest);
//                }
//                else {
//                    Toast.makeText(getApplicationContext(), "Passwords do not match. Try again.", Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        });
    }
}