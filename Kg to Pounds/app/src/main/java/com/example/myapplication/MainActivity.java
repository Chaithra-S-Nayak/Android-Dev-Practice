package com.example.myapplication;

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
Button btn;
EditText editText;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    editText=findViewById(R.id.editTextNumber);
    btn=findViewById(R.id.button);
    textView=findViewById(R.id.textViewOutput);

    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_SHORT).show();
            Double kg=Double.parseDouble(editText.getText().toString());
            Double pound= kg*2.205;
            textView.setText("the corresponding value in pounds is "+ pound);
        }
    });

    }
}