package com.letz.icanmart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView name, email, phone;
    Button bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        name = findViewById(R.id.TextViewName);
        email = findViewById(R.id.TextViewEmail);
        phone = findViewById(R.id.TextViewPhone);
        bmi = findViewById(R.id.buttonBMI);

        Intent i = getIntent();
        // putExtra 한 값 받아오
        String userName = i.getStringExtra("name");
        String userEmail = i.getStringExtra("email");
        // Integer 선언
        int userPhone = i.getIntExtra("phone", 0);

        name.setText("Hello " + userName);
        email.setText("Your email address is "+userEmail);
        // phone 을 스트링 타입으로 바꿔요.
        phone.setText("Your phone numbe is "+ String.valueOf(userPhone));

        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this, AtoFActivity.class);
                startActivity(i);
            }
        });

    }
}