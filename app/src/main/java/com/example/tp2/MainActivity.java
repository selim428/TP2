package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText taille;
    EditText poids;
    EditText age;
    RadioButton homme;
    RadioButton femme;
    Button img;
    TextView R1;
    TextView R2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        taille = findViewById(R.id.taille);
        poids = findViewById(R.id.poids);
        age = findViewById(R.id.age);
        R1 = findViewById(R.id.R1);
        R2 = findViewById(R.id.R2);
        btn = findViewById(R.id.img);
        homme = findViewById(R.id.homme);
        femme = findViewById(R.id.femme);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double poid = Double.valueOf(poids.getText().toString());
                double tailles = Double.valueOf(taille.getText().toString());
                double ages = Double.valueOf(age.getText().toString());
                double imc;

                if (ages >= 16) {
                    if (femme.isChecked()) {
                        imc = ((1.2 * poid) / (tailles * tailles)) + (0.2 * ages) - 5.4;
                    } else {
                        imc = ((1.2 * poid) / (tailles * tailles)) + (0.2 * ages) - 16.2;
                    }
                } else {
                    if (femme.isChecked()) {
                        imc = ((1.51 * poid) / (tailles * tailles)) + (0.7 * ages) + 1.4;
                    } else {
                        imc = ((1.51 * poid) / (tailles * tailles)) + (0.7 * ages) - 2.2;
                    }
                }

                String txt;
                if (femme.isChecked()) {
                    if (imc < 25) {
                        txt = "trop maigre";
                    } else if (imc > 30) {
                        txt = "surpoids";
                    } else {
                        txt = "normale";
                    }
                } else {
                    if (imc < 15) {
                        txt = "trop maigre";
                    } else if (imc > 20) {
                        txt = "surpoids";
                    } else {
                        txt = "normale";
                    }
                }

                R1.setText(String.valueOf(imc));
                R2.setText(txt);
            }
        });
    }
}







