package com.letz.icanmart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GuessingGameActivity extends AppCompatActivity {
    private TextView TextViewLast, TextViewRight, TextViewHint;
    private Button ButtonConfirm;
    private EditText EditTextGuess;
    boolean twoDigits, threeDigits, fourDigits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guessing_game);

        TextViewLast = findViewById(R.id.textViewLast);
        TextViewRight = findViewById(R.id.textViewRight);
        TextViewHint = findViewById(R.id.textViewHint);
        ButtonConfirm = findViewById(R.id.buttonConfirm);
        EditTextGuess = findViewById(R.id.editTextTextGuess);

        twoDigits = getIntent().getBooleanExtra("two", false);
        threeDigits = getIntent().getBooleanExtra("three", false);
        fourDigits = getIntent().getBooleanExtra("four", false);
        
    }
}
