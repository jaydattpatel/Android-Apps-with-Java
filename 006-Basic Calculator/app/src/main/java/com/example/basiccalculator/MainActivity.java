package com.example.basiccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

    TextView tvDisplay;
    private double firstNumber = 0;
    private String operation = null;
    private boolean isNewOperation = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvDisplay = findViewById(R.id.tvDisplay);
    }

    public void numberEvent(View view) {
        if (isNewOperation) {
            tvDisplay.setText("");
        }
        isNewOperation = false;
        String number = tvDisplay.getText().toString();
        int id = view.getId();
        if (id == R.id.btnZero) {
            number += "0";
        } else if (id == R.id.btnOne) {
            number += "1";
        } else if (id == R.id.btnTwo) {
            number += "2";
        } else if (id == R.id.btnThree) {
            number += "3";
        } else if (id == R.id.btnFour) {
            number += "4";
        } else if (id == R.id.btnFive) {
            number += "5";
        } else if (id == R.id.btnSix) {
            number += "6";
        } else if (id == R.id.btnSeven) {
            number += "7";
        } else if (id == R.id.btnEight) {
            number += "8";
        } else if (id == R.id.btnNine) {
            number += "9";
        }
        tvDisplay.setText(number);
    }

    public void operationEvent(View view) { isNewOperation = true;
        firstNumber	= Double.parseDouble(tvDisplay.getText().toString());
        int id = view.getId();
        if (id == R.id.btnAdd) {
            operation = "+";
        } else if (id == R.id.btnMinus) {
            operation = "-";
        } else if (id == R.id.btnMultiply) {
            operation = "*";
        } else if (id == R.id.btnDivide) {
            operation = "/";
        }

    }

    public void equalEvent(View view) {
        if (operation == null) {
        tvDisplay.setText("No operation set");
        isNewOperation = true;
        return;

    }
        String newNumber = tvDisplay.getText().toString(); double result = 0.0;
        switch (operation) {
            case "+":
                result	=	firstNumber	+ Double.parseDouble(newNumber);
                break;
            case "-":
                result	=	firstNumber	- Double.parseDouble(newNumber);
                break;
            case "*":
                result	=	firstNumber	* Double.parseDouble(newNumber);
                break;
            case "/":
                if (Double.parseDouble(newNumber) != 0) {
                    result	=	firstNumber	/
                    Double.parseDouble(newNumber);
                } else {
                tvDisplay.setText("Error");
                isNewOperation = true;
                return;
                }
                break;

        }
        tvDisplay.setText(String.valueOf(result));

        isNewOperation = true;
    }

    public void clearEvent(View view) {
        tvDisplay.setText("0");
        isNewOperation = true;
        firstNumber = 0;
        operation = null;
    }

}

