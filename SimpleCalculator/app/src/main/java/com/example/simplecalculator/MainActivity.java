package com.example.simplecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText num1,num2;
    TextView result;
    Button add,sub,mul,div,mod,clr;
    double n1,n2,res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        result = findViewById(R.id.result);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);
        mod = findViewById(R.id.mod);
        clr = findViewById(R.id.clr);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs()) {
                    n1 = Double.parseDouble(num1.getText().toString());
                    n2 = Double.parseDouble(num2.getText().toString());
                    res = n1 + n2;
                    result.setText(String.valueOf(res));
                }
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs()) {
                    n1 = Double.parseDouble(num1.getText().toString());
                    n2 = Double.parseDouble(num2.getText().toString());
                    res = n1 - n2;
                    result.setText(String.valueOf(res));
                }
            }
        });


        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs()) {
                    n1 = Double.parseDouble(num1.getText().toString());
                    n2 = Double.parseDouble(num2.getText().toString());
                    res = n1 * n2;
                    result.setText(String.valueOf(res));
                }
            }
        });


        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs()) {
                    n1 = Double.parseDouble(num1.getText().toString());
                    n2 = Double.parseDouble(num2.getText().toString());
                    // Handle division by zero
                    if (n2 == 0) {
                        Toast.makeText(MainActivity.this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    } else {
                        res = n1 / n2;
                        result.setText(String.valueOf(res));
                    }
                }
            }
        });

        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs()) {
                    n1 = Double.parseDouble(num1.getText().toString());
                    n2 = Double.parseDouble(num2.getText().toString());
                    // Handle modulus by zero
                    if (n2 == 0) {
                        Toast.makeText(MainActivity.this, "Cannot mod by zero", Toast.LENGTH_SHORT).show();
                    } else {
                        res = n1 % n2;
                        result.setText(String.valueOf(res));
                    }
                }
            }
        });

        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1.setText("");
                num2.setText("");
                result.setText("Result");
            }
        });

    }
    // Method to validate inputs
    private boolean validateInputs() {
        if (num1.getText().toString().isEmpty() || num2.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Please enter two numbers", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}

