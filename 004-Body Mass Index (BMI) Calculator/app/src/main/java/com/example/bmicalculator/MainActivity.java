package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etWeight, etHeight;
    Button btnCalculateBMI;
    TextView tvBMIResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etWeight = findViewById(R.id.etWeight);
        etHeight = findViewById(R.id.etHeight);
        btnCalculateBMI = findViewById(R.id.btnCalculateBMI);
        tvBMIResult = findViewById(R.id.tvBMIResult);

        btnCalculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etWeight.getText().toString().isEmpty() &&
                        !etHeight.getText().toString().isEmpty()) {
                    float weight = Float.parseFloat(etWeight.getText().toString());
                    float height = Float.parseFloat(etHeight.getText().toString());
                    float bmi = weight / (height * height);
                    String assessment = getHealthAssessment(bmi);
                    tvBMIResult.setText(String.format("BMI: %.2f (%s)", bmi, assessment));
                }
            }
        });
    }

    private String getHealthAssessment(float bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}
