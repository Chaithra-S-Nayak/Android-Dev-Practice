package com.example.pr1_smsandphone;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
EditText editTextText, editTextPhone;
Button call, msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        call=findViewById(R.id.call);
        msg=findViewById(R.id.msg);
        editTextText=findViewById(R.id.editTextText);
        editTextPhone=findViewById(R.id.editTextPhone);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+editTextPhone.getText().toString()));
                startActivity(intent);
            }
        });

        msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", editTextPhone.getText().toString(),null));
                intent.putExtra("sms_body", editTextText.getText().toString());
                startActivity(intent);
            }
        });
    }
}