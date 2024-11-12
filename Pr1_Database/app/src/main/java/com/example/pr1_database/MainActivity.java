package com.example.pr1_database;

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
EditText name,usn,sem;
Button button;
MyDatabaseOperation myDatabaseOperation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.name);
        usn=findViewById(R.id.usn);
        sem=findViewById(R.id.sem);
        button=findViewById(R.id.button);

        myDatabaseOperation=new MyDatabaseOperation(this,"StudentInfo",null,1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sname= name.getText().toString();
                String susn=name.getText().toString();
                int ssem=Integer.parseInt(sem.getText().toString());

                boolean success=false;
                
                success=myDatabaseOperation.data_insertion(susn,sname,ssem);
                
                if(success){
                    Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "fail", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}