package com.letz.icanmart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AtoFActivity extends AppCompatActivity {

    EditText weight,height;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ato_factivity);

        // 1. fragment 매니저
        FragmentManager fragmentManager = getSupportFragmentManager();
        // 2. fragment의 transaction 시작
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        MyFirstFragment myFirstFragment = new MyFirstFragment();

        weight = findViewById(R.id.editTextNumberWeight);
        height = findViewById(R.id.editTextNumberHeight);
        calculate = findViewById(R.id.buttonCalcBMI);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 3. bundle 정의
                Bundle bundle = new Bundle();

                int userWeight = Integer.valueOf(weight.getText().toString());
                int userHeight = Integer.valueOf(height.getText().toString());

                // 4. 값전달
                bundle.putInt("weight", userWeight);
                bundle.putInt("height", userHeight);

                // 5. fragment에 값 전달
                myFirstFragment.setArguments(bundle);

                // 6. Fragment Transaction 시작
                fragmentTransaction.add(R.id.frameBMI, myFirstFragment);
                // 7. Transaction 실행
                fragmentTransaction.commit();
            }
        });


    }
}