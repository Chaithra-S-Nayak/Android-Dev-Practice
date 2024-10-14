package com.example.fooditems;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
CheckBox idli,vada,dosa,palav;
Button button;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        idli=findViewById(R.id.idli);
        vada=findViewById(R.id.vada);
        dosa=findViewById(R.id.dosa);
        palav=findViewById(R.id.palav);
        button=findViewById(R.id.button);
        textView=findViewById(R.id.textView);

        int idliPrice=10;
        int vadaPrice=20;
        int dosaPrice=30;
        int palavPrive=40;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder stringBuilder=new StringBuilder();
                int count=0;
                int totalPrice=0;
                if(idli.isChecked()){
                    totalPrice+=idliPrice;
                    count++;
                    stringBuilder.append("Idli,");
                }
                if(vada.isChecked()){
                    totalPrice+=vadaPrice;
                    count++;
                    stringBuilder.append("vada,");
                }
                if(dosa.isChecked()){
                    totalPrice+=dosaPrice;
                    count++;
                    stringBuilder.append("dosa,");
                }
                if(palav.isChecked()){
                    totalPrice+=palavPrive;
                    count++;
                    stringBuilder.append("palav,");
                }

//                Toast.makeText(MainActivity.this, "Total amount "+totalPrice, Toast.LENGTH_SHORT).show();
//                Toast.makeText(MainActivity.this, "Total count "+count, Toast.LENGTH_SHORT).show();
//                Toast.makeText(MainActivity.this, "Total items "+stringBuilder, Toast.LENGTH_SHORT).show();
                textView.setText("Items:"+stringBuilder+" count "+count+" Amount:"+totalPrice);
            }
        });
    }
}