package com.example.randomcolor;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
ConstraintLayout main;
TextView rgb;
Button magic, reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        main=findViewById(R.id.main);
        magic=findViewById(R.id.magic);
        reset=findViewById(R.id.reset);
        rgb=findViewById(R.id.rgb);

        magic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random=new Random();
                int red=random.nextInt(256);
                int blue=random.nextInt(256);
                int green=random.nextInt(256);
//                int color= Color.argb(255,random.nextInt(256),random.nextInt(256),random.nextInt(256));
                int color=Color.argb(255,red,green,blue);
                main.setBackgroundColor(color);
//                rgb.setText(String.valueOf(color));
                rgb.setText("Red "+red+" Blue "+blue+ " Green "+green);
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int color= Color.argb(0,0,0,0);
                main.setBackgroundColor(color);
                rgb.setText(String.valueOf(color));
            }
        });
    }
}