package com.example.pr1_checkboxes;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    CheckBox idli,vada,palav,dosa;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        idli=findViewById(R.id.idli);
        vada=findViewById(R.id.vada);
        palav=findViewById(R.id.palav);
        dosa=findViewById(R.id.dosa);
        btn=findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder str = new StringBuilder();
                if(idli.isChecked()){
                    str.append("idli ,");
                }
                if(vada.isChecked()){
                    str.append("vada ,");
                }
                if(palav.isChecked()){
                    str.append("palav ,");
                }
                if(dosa.isChecked()){
                    str.append("dosa ,");
                }
                Toast.makeText(MainActivity.this, "You selected "+str, Toast.LENGTH_SHORT).show();

            }
        });
    }
}