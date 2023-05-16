package com.example.reservo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MedHistory extends AppCompatActivity {

    Button btnE, btnS;
    RadioButton m, f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med_history);

        btnE = (Button) findViewById(R.id.btnMHEdit);
        btnS = (Button) findViewById(R.id.btnMHSave);
        m = (RadioButton) findViewById(R.id.male);
        f = (RadioButton) findViewById(R.id.female);

        btnS.setVisibility(View.GONE);

        int[] genHis = {R.id.checkBox1, R.id.checkBox2, R.id.checkBox3, R.id.checkBox4, R.id.checkBox5, R.id.checkBox6,
                R.id.checkBox7, R.id.checkBox8, R.id.checkBox9, R.id.checkBox10, R.id.checkBox11, R.id.checkBox12};

        int[] all = {R.id.checkBox13, R.id.checkBox14, R.id.checkBox15, R.id.checkBox16, R.id.checkBox17, R.id.checkBox18, };

        int[] famHis = {R.id.checkBox19, R.id.checkBox20, R.id.checkBox21, R.id.checkBox22, R.id.checkBox23, R.id.checkBox24,
                R.id.checkBox25, R.id.checkBox26, R.id.checkBox27};

        for (int checkboxId : genHis) {
            CheckBox checkbox = findViewById(checkboxId);
            checkbox.setEnabled(false);
        }

        for (int checkboxId : all) {
            CheckBox checkbox = findViewById(checkboxId);
            checkbox.setEnabled(false);
        }

        for (int checkboxId : famHis) {
            CheckBox checkbox = findViewById(checkboxId);
            checkbox.setEnabled(false);
        }

        m.setEnabled(false);
        f.setEnabled(false);

        btnE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnS.setVisibility(View.VISIBLE);
                btnE.setVisibility(View.GONE);
                for (int checkboxId : genHis) {
                    CheckBox checkbox = findViewById(checkboxId);
                    checkbox.setEnabled(true);
                }

                for (int checkboxId : all) {
                    CheckBox checkbox = findViewById(checkboxId);
                    checkbox.setEnabled(true);
                }

                for (int checkboxId : famHis) {
                    CheckBox checkbox = findViewById(checkboxId);
                    checkbox.setEnabled(true);
                }

                m.setEnabled(true);
                f.setEnabled(true);
            }
        });

        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnS.setVisibility(View.GONE);
                btnE.setVisibility(View.VISIBLE);
                for (int checkboxId : genHis) {
                    CheckBox checkbox = findViewById(checkboxId);
                    checkbox.setEnabled(false);
                }

                for (int checkboxId : all) {
                    CheckBox checkbox = findViewById(checkboxId);
                    checkbox.setEnabled(false);
                }

                for (int checkboxId : famHis) {
                    CheckBox checkbox = findViewById(checkboxId);
                    checkbox.setEnabled(false);
                }

                m.setEnabled(false);
                f.setEnabled(false);
            }
        });
    }
}