package com.example.arithmetic;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText val1, val2;
    float v1,v2,result;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val1 = findViewById(R.id.val1);
        val2 = findViewById(R.id.val2);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        resultText = findViewById(R.id.resultText);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check()) {
                    result = v1 + v2;
                    resultText.setText(String.format("Add: %.2f", result));
                }
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check()) {
                    result = v1 - v2;
                    resultText.setText(String.format("Sub: %.2f", result));
                }
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check()) {
                    result = v1 * v2;
                    resultText.setText(String.format("Mul: %.2f", result));
                }
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check()) {
                    result = v1 / v2;
                    resultText.setText(String.format("Div: %.2f", result));
                }
            }
        });
    }

    protected boolean check(){
        resultText.setText("");
        boolean bool = !val1.getText().toString().isEmpty() &&
                !val2.getText().toString().isEmpty();
        if (bool) {
            v1 = Float.parseFloat(val1.getText().toString());
            v2 = Float.parseFloat(val2.getText().toString());
        }
        return bool;
    }
}
