package com.example.contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView mytextView;
    ConstraintLayout mylayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mylayout=findViewById(R.id.layout);
        mytextView=findViewById(R.id.textView);
        registerForContextMenu(mytextView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Choose any below color");
        menu.add("YELLOW");
        menu.add("GREEN");
        menu.add("MAGENTA");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getTitle()=="YELLOW")
            mylayout.setBackgroundColor(Color.YELLOW);
        if (item.getTitle()=="GREEN")
            mylayout.setBackgroundColor(Color.GREEN);
        if (item.getTitle()=="MAGENTA")
            mylayout.setBackgroundColor(Color.MAGENTA);
        return true;
    }
}
