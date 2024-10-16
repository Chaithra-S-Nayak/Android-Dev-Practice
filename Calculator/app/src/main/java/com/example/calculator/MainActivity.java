package com.example.calculator;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
EditText num1,num2;
Button add,sub,mul,div,mod,clr,equal,mAdd,mSub,mc,mr;
TextView result;
Double n1,n2,res;
Double  memory=0.00;
RadioButton radioButtonAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        num1=findViewById(R.id.num1);
        num2=findViewById(R.id.num2);
        add=findViewById(R.id.add);
        sub=findViewById(R.id.sub);
        mul=findViewById(R.id.mul);
        div=findViewById(R.id.div);
        mod=findViewById(R.id.mod);
        clr=findViewById(R.id.clr);
        result=findViewById(R.id.result);
        equal=findViewById(R.id.equal);
        radioButtonAdd=findViewById(R.id.radioButtonAdd);
        mAdd=findViewById(R.id.mAdd);
        mSub=findViewById(R.id.mSub);
        mc=findViewById(R.id.mc);
        mr=findViewById(R.id.mr);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validInput()){
                    n1=Double.parseDouble(num1.getText().toString());
                    n2=Double.parseDouble(num2.getText().toString());
                    res=n1+n2;
                    result.setText("Result "+res);
                }
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validInput()){
                    n1=Double.parseDouble(num1.getText().toString());
                    n2=Double.parseDouble(num2.getText().toString());
                    res=n1-n2;
                    result.setText("Result "+res);
                }
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validInput()){
                    n1=Double.parseDouble(num1.getText().toString());
                    n2=Double.parseDouble(num2.getText().toString());
                    res=n1*n2;
                    result.setText("Result "+res);
                }
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validInput()){
                    n1=Double.parseDouble(num1.getText().toString());
                    n2=Double.parseDouble(num2.getText().toString());
                    if(n2==0){
                        Toast.makeText(MainActivity.this, "Cannot div by zero", Toast.LENGTH_SHORT).show();
                    }else{
                        res=n1/n2;
                        result.setText("Result "+res);
                    }
                }
            }
        });

        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validInput()){
                    n1=Double.parseDouble(num1.getText().toString());
                    n2=Double.parseDouble(num2.getText().toString());
                    if(n2==0){
                        Toast.makeText(MainActivity.this, "Cannot mod by zero", Toast.LENGTH_SHORT).show();
                    }else{
                        res=n1%n2;
                        result.setText("Result "+res);
                    }
                }
            }
        });

        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1.setText(null);
                num2.setText(null);
            }
        });
// suppose said to input in this way- operand , operator, operand. rather than operand, operand, operator
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(validInput()){
                        n1=Double.parseDouble(num1.getText().toString());
                        n2=Double.parseDouble(num2.getText().toString());
                        if(radioButtonAdd.isChecked()){
                            res=n1+n2;
                            result.setText("Result "+res);
                        }
                    }
            }
        });
//Memory functions
        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG", "res: "+ res);
                if(res!=null)
                memory+=res;
            }
        });

        mSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG", "res: "+ res);
                n1=Double.parseDouble(num1.getText().toString());
                if(n1!=null)
                    memory-=n1;
            }
        });

        mr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(String.valueOf(memory));
            }
        });

        mc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                memory=0.0;
                result.setText(String.valueOf(memory));
            }
        });

    }
    public boolean validInput(){
        if(num1.getText().toString().isEmpty()||num2.getText().toString().isEmpty()){
            Toast.makeText(MainActivity.this, "Please enter both fields", Toast.LENGTH_SHORT).show();
            return false;
        }
       return true;
    }
}