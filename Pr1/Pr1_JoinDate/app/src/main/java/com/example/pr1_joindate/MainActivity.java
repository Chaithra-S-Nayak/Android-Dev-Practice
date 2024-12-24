package com.example.pr1_joindate;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
EditText join;
CalendarView calendarView;
Spinner spinner;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        join=findViewById(R.id.join);
        calendarView=findViewById(R.id.calendarView);
        spinner=findViewById(R.id.spinner);
        button=findViewById(R.id.button);

        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendarView.setVisibility(View.VISIBLE);
                calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                    @Override
                    public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                        String date= dayOfMonth+"/"+month+"/"+year;
                        join.setText(date);
                        calendarView.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String branch=spinner.getSelectedItem().toString();
                String doj=join.getText().toString();
                Toast.makeText(MainActivity.this, "You selected"+branch+" on"+doj, Toast.LENGTH_SHORT).show();
            }
        });

    }
}