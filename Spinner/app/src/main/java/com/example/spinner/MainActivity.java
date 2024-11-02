package com.example.spinner;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    Spinner sp;
    EditText joindate;
    CalendarView cal;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp=findViewById(R.id.Spinner);
        joindate=findViewById(R.id.EditTextDate);
        cal=findViewById(R.id.CalendarView);
        btn=findViewById(R.id.Button);
        cal.setVisibility(View.INVISIBLE);
        joindate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cal.setVisibility(View.VISIBLE);
                cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                    @Override
                    public void onSelectedDayChange(@NonNull CalendarView view, int year, int
                            month, int dayOfMonth) {
                        String date=dayOfMonth+"/"+month+"/"+year;
                        joindate.setText(date);
                        cal.setVisibility(view.INVISIBLE);
                    }
                });
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String branch=sp.getSelectedItem().toString();
                String doj=joindate.getText().toString();
                Toast.makeText(MainActivity.this,"you joined to "+branch+" on "+doj,Toast.LENGTH_SHORT).show();
            }
        });
    }
}