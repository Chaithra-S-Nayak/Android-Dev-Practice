package com.example.optionsmenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=new MenuInflater(this);
        menuInflater.inflate(R.menu.mymenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        int myItem= item.getItemId();
        if(myItem==R.id.activity2){
            intent=new Intent(this, MainActivity2.class);
            startActivity(intent);
        }
        if(myItem==R.id.activity3){
            intent=new Intent(this, MainActivity3.class);
            startActivity(intent);
        }
        if(myItem==R.id.activity4){
            intent=new Intent(this, MainActivity4.class);
            startActivity(intent);
        }
        return true;
    }
}