package com.example.dialoguebox;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout layout;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.main);
        tv = findViewById(R.id.textView);
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);

        alert.setMessage("Do you really want to change the background color?");
        alert.setTitle("Alert Box");

        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Random random = new Random();
                int color = Color.argb(255,random.nextInt(256),random.nextInt(256),random.nextInt(256));
                layout.setBackgroundColor(color);
            }
        });

        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                alert.setCancelable(true);
            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog myAlertDialogBox = alert.create();
                myAlertDialogBox.show();
            }
        });
    }
}
