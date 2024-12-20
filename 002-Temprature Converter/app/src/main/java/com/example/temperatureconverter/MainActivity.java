package com.example.temperatureconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etCelsius, etFahrenheit;
    Button btnToFahrenheit, btnToCelsius;
    TextView Result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCelsius = findViewById(R.id.etCelsius);
        etFahrenheit = findViewById(R.id.etFahrenheit);

        btnToFahrenheit = findViewById(R.id.btnToFahrenheit);
        btnToCelsius = findViewById(R.id.btnToCelsius);

        Result = findViewById(R.id.Result);

        btnToFahrenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etCelsius.getText().toString().isEmpty())
                {
                    double celsius = Double.parseDouble(etCelsius.getText().toString());
                    double fahrenheit = (celsius * 9/5) + 32;

                    Result.setText(String.format("%.2f Fahrenheit", fahrenheit));
                }
            }
        });

        btnToCelsius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etFahrenheit.getText().toString().isEmpty()) {
                    double fahrenheit = Double.parseDouble(etFahrenheit.getText().toString());
                    double celsius = (fahrenheit - 32) * 5/9;
                    Result.setText(String.format("%.2f Celsius", celsius));
                }
            }
        });

    }
}