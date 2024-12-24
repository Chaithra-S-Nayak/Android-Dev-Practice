package com.example.pr1_usncall;

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

    EditText usn,phone,sem,call_usn;
    Button button,call;
    MyDatabaseOperation myDatabaseOperation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        usn=findViewById(R.id.usn);
        phone=findViewById(R.id.phone);
        sem=findViewById(R.id.sem);
        call_usn=findViewById(R.id.call_usn);
        button=findViewById(R.id.button);
        call=findViewById(R.id.call);

        myDatabaseOperation= new MyDatabaseOperation(this,"StudentInfo",null,1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String susn=usn.getText().toString();
                String sphone=phone.getText().toString();
                int ssem=Integer.parseInt(sem.getText().toString());

                boolean success=false;
                success=myDatabaseOperation.data_insertion(susn,sphone,ssem);
                if(success){
                    Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_SHORT).show();
                }

            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber=myDatabaseOperation.getPhoneNumber(call_usn.getText().toString());
                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
                startActivity(intent);
            }
        });



    }
}