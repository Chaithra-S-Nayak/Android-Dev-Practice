package com.example.broadcastreciever;
import android.content.BroadcastReceiver;
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
    TextView tv;
    ConstraintLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) ->
        {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right,
                    systemBars.bottom);
            return insets;
        });
        tv=findViewById(R.id.textview);
        layout=findViewById(R.id.main);
        this.registerReceiver(this.broadcastReceiver,new
                IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }
    BroadcastReceiver broadcastReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int level= intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
            tv.setText(String.valueOf(level)+"%");
            if(level>70){
                layout.setBackgroundColor(Color.GREEN);
            } else if (level<70 && level>=30) {
                layout.setBackgroundColor(Color.YELLOW);
            }
            else{
                layout.setBackgroundColor(Color.RED);
            }
        }
    };
}