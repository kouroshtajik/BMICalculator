package com.kouroshtj.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edtWeight = findViewById(R.id.edtWeight);
        EditText edtHeight = findViewById(R.id.edtHeight);
        Button btnCalculate = findViewById(R.id.btnCalculate);
        TextView txtShowResult = findViewById(R.id.txtShowResult);


        //Calculate Methods...

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtShowResult.setText("");
                String weight = edtWeight.getText().toString();
                String height = edtHeight.getText().toString();
                if (weight.isEmpty() & height.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Weight And Height Values Are Empty", Toast.LENGTH_SHORT).show();
                }else if(weight.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Weight Value is Empty", Toast.LENGTH_SHORT).show();
                }else if(height.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Height Value is Empty", Toast.LENGTH_SHORT).show();
                }else {
                    double weightValue = Double.parseDouble(weight);
                    double heightValue = Double.parseDouble(height);

                    Double bmi = weightValue/(heightValue * heightValue);
                    if (bmi < 18.5) {
                        String underweight = getResources().getString(R.string.underweight);
                        String result = bmi.toString();
                        txtShowResult.setText("Your BMI is :   " + bmi + "\n\n" + underweight );
                    }else  if (bmi > 18.4 & bmi < 25) {
                        String normal = getResources().getString(R.string.normal);
                        String result = bmi.toString();
                        txtShowResult.setText("Your BMI is :   " + bmi + "\n\n" + normal );
                    }else if (bmi > 24.9 & bmi < 29.9) {
                        String overweight = getResources().getString(R.string.overweight);
                        String result = bmi.toString();
                        txtShowResult.setText("Your BMI is :   " + bmi + "\n\n" + overweight );
                    }else {
                        String obese = getResources().getString(R.string.obese);
                        String result = bmi.toString();
                        txtShowResult.setText("Your BMI is :   " + bmi + "\n\n" + obese );
                    }


                }

            }
        });



    }
}