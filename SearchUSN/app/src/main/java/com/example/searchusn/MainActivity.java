package com.example.searchusn;

import android.content.Intent;
import android.net.Uri;
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
    EditText phone,usn,sem, call_usn;
    Button button, call;
    MyDatabaseOperation myDatabaseOperation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        phone=findViewById(R.id.phone);
        usn=findViewById(R.id.usn);
        sem=findViewById(R.id.sem);
        button=findViewById(R.id.button);
        call_usn=findViewById(R.id.call_usn);
        call=findViewById(R.id.call);

        myDatabaseOperation=new MyDatabaseOperation(this,"StudentInfo",null,1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sphone= phone.getText().toString();
                String susn=usn.getText().toString();
                int ssem=Integer.parseInt(sem.getText().toString());

                boolean success=false;

                success=myDatabaseOperation.data_insertion(susn,sphone,ssem);

                if(success){
                    Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "fail", Toast.LENGTH_SHORT).show();
                }
            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ssusn=call_usn.getText().toString();
                String phoneNumber=myDatabaseOperation.getPhoneNumber(ssusn);
                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
                startActivity(intent);
            }
        });

    }
}