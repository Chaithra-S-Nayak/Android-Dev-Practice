package com.example.multiplicationtable;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView1, textView2,textView3, textView4, textView5;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.editTextNumber);
        button=findViewById(R.id.button);
        textView1=findViewById(R.id.textView1);
        textView2=findViewById(R.id.textView2);
        textView3=findViewById(R.id.textView3);
        textView4=findViewById(R.id.textView4);
        textView5=findViewById(R.id.textView5);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double value= Double.parseDouble(editText.getText().toString());
                textView1.setText(value+" * 1 = "+value*1);
                textView2.setText(value+" * 2 = "+value*2);
                textView3.setText(value+" * 3 = "+value*3);
                textView4.setText(value+" * 4 = "+value*4);
                textView5.setText(value+" * 5 = "+value*5);
            }
        });



    }
}