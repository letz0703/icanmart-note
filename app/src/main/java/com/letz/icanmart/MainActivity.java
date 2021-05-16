package com.letz.icanmart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    Button calculator;
    Button barcode;
    Button todo;
    private Button buttonStart;
    private RadioButton btn2digts, btn3digits, btn4digits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculator = findViewById(R.id.buttonCalc);
        barcode = findViewById(R.id.buttonBarcode);
        todo = findViewById(R.id.buttonTodo);

        buttonStart = findViewById(R.id.buttonStart);
        btn2digts = findViewById(R.id.radioButton2digits);
        btn3digits = findViewById(R.id.radioButton3digits);
        btn4digits = findViewById(R.id.radioButton4ditis);




        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GuessingGameActivity.class);

                if (!btn2digts.isChecked() && !btn3digits.isChecked() && !btn4digits.isChecked()) {
                    // material 설치 요함. build.gradle에 ==> for Snackbar
                    // implementation 'com.google.android.material:material:1.3.0' 추가
                    Snackbar.make(v, "Choose number of digits!",Snackbar.LENGTH_LONG).show();
                } else {
                    if(btn2digts.isChecked()){
                        intent.putExtra("two", true);
                    } else if (btn3digits.isChecked()){
                        intent.putExtra("three", true);
                    } else if (btn4digits.isChecked()){
                        intent.putExtra("four", true);
                    }
                    startActivity(intent);
                }
            }

        });

        todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Todo.class);
                startActivity(intent);
            }
        });

        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Calculator.class);
                startActivity(intent);
            }
        });
    }
}