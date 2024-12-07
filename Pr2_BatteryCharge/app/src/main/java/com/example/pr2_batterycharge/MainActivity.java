package com.example.pr2_batterycharge;

import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.textView);
        layout=findViewById(R.id.main);
        BroadcastReceiver broadcastReceiver=new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int level=intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
                textView.setText(level+"%");
                if(level>70){
                    layout.setBackgroundColor(Color.GREEN);
                }else if(level<70 && level>30){
                    layout.setBackgroundColor(Color.YELLOW);
                }else{
                    layout.setBackgroundColor(Color.RED);
                }
            }
        };
        registerReceiver(broadcastReceiver,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

    }
}