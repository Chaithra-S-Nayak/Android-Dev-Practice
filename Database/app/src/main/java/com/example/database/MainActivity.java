package com.example.database;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MainActivity extends AppCompatActivity {
    EditText name,usn,sem,branch,ph_no;
    Button btn;
    MyDatabaseOperations myDatabaseOperations;
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
        name = findViewById(R.id.name);
        usn = findViewById(R.id.usn);
        sem = findViewById(R.id.sem);
        branch = findViewById(R.id.branch);
        ph_no = findViewById(R.id.phone);
        btn = findViewById(R.id.submit);
        myDatabaseOperations = new MyDatabaseOperations(this,"MyDatabase.db",null,1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean submission = false;
                String st_name = name.getText().toString();
                String st_usn = usn.getText().toString();
                int st_sem = Integer.parseInt(sem.getText().toString()) ;
                String st_branch = branch.getText().toString();
                String st_ph_no = ph_no.getText().toString();
                submission =
                        myDatabaseOperations.dataInsert(st_name,st_usn,st_sem,st_branch,st_ph_no);
                if(submission){
                    Toast.makeText(MainActivity.this, "Data Entry Successful",
                            Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Data Entry Failed",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}