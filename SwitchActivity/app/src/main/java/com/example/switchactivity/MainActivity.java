package com.example.switchactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
EditText editText;
Button button;

public static String NAME="com.example.switchactivity.extra.name";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.editTextText);
        button=findViewById(R.id.button);

    }
    public void openActivity(View v){
        Toast.makeText(this, "Helllo", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,MainActivity2.class);
        String name=editText.getText().toString();
        intent.putExtra(NAME,name);
        startActivity(intent);
    }
}