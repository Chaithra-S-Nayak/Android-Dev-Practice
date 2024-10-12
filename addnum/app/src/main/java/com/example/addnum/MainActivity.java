package com.example.addnum;

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
Button button;
EditText editText1, editText2;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editText1=findViewById(R.id.editTextNumber);
        editText2=findViewById(R.id.editTextNumber2);
        button=findViewById(R.id.button);
        textView= findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double a= Double.parseDouble(editText1.getText().toString());
                Double b= Double.parseDouble(editText2.getText().toString());

                Double result=a+b;

                textView.setText(result.toString());
            }
        });

    }
}