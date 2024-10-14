package com.example.pr1_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText num1, num2;
    Button add, div, clr;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        num1= findViewById(R.id.num1);
        num2= findViewById(R.id.num2);
        add= findViewById(R.id.add);
        div= findViewById(R.id.div);
        clr= findViewById(R.id.clr);
        result= findViewById(R.id.result);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateInput()){
                    double n1= Double.parseDouble(num1.getText().toString());
                    double n2= Double.parseDouble(num2.getText().toString());
                    double res= n1+n2;
                    result.setText(String.valueOf(res));
                }
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateInput()){
                    double n1= Double.parseDouble(num1.getText().toString());
                    double n2= Double.parseDouble(num2.getText().toString());
                    if(n2==0){
                        Toast.makeText(MainActivity.this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    }
                    double res= n1/n2;
                    result.setText(String.valueOf(res));
                }
            }
        });

        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               num1.setText(null);
               num2.setText(null);
               result.setText(null);
            }
        });
    }
    public boolean validateInput(){
        if(num1.getText().toString().isEmpty()|| num2.getText().toString().isEmpty() ){
            Toast.makeText(this, "Please enter both fields", Toast.LENGTH_SHORT).show();
            return false;
        }else {
            return true;
        }
    }

}