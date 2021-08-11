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
                    String result = bmi.toString();
                    txtShowResult.setText(result);

                }

            }
        });



    }
}