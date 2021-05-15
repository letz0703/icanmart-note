package com.letz.icanmart;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class GuessingGameActivity extends AppCompatActivity {
    private TextView textViewLast, textViewRight, textViewHint;
    private Button buttonConfim;
    private EditText editTextGuess;
    boolean twoDigits, threeDigits, fourDigits;
    Random r = new Random();
    int random;
    int remainingRight = 10; // ? 이걸 왜 하지??

    // guess 한 것들 저장 하기
    ArrayList<Integer> guessesList = new ArrayList<>();
    int userAttempts = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guessing_game);

        textViewLast = findViewById(R.id.textViewLast);
        textViewRight = findViewById(R.id.textViewRight);
        textViewHint = findViewById(R.id.textViewHint);
        buttonConfim = findViewById(R.id.buttonConfirm);
        editTextGuess = findViewById(R.id.editTextGuess);

        twoDigits = getIntent().getBooleanExtra("two", false);
        threeDigits = getIntent().getBooleanExtra("three", false);
        fourDigits = getIntent().getBooleanExtra("four", false);

        if (twoDigits) {
            random = r.nextInt(100) + 10;
        }
        if (threeDigits) {
            random = r.nextInt(1000) + 100;
        }
        if (fourDigits) {
            random = r.nextInt(10000) + 1000;
        }
        // add click listener for the button 'buttonConfim'
        buttonConfim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // confirm 하면 뭐할래? => String guess variable 생성
                String guess = editTextGuess.getText().toString();
                //마약 guess가 공백이면.
                if (guess.equals("")) {
                    //토스트 메시지 날리기.
                    Toast.makeText(GuessingGameActivity.this, "Please enter your guess", Toast.LENGTH_LONG).show();
                } else {
                    // 결과 보이게 하기
                    textViewLast.setVisibility(View.VISIBLE);
                    textViewRight.setVisibility(View.VISIBLE);
                    textViewHint.setVisibility(View.VISIBLE);

                    //시도 횟수 증가 시키기
                    userAttempts ++;

                    // 횟수 차감.
                    remainingRight--;
                    //Convert Guess value to Int type.
                    int userGuess = Integer.parseInt(guess);
                    guessesList.add(userGuess);

                    textViewLast.setText(guess);
                    textViewRight.setText(remainingRight);

                    if (random == userGuess) {
                        // 경고 박스 만들기
                        AlertDialog.Builder builder = new AlertDialog.Builder(GuessingGameActivity.this);
                        //타이틀 설정
                        builder.setTitle("Guessing Game");
                        //취소 못하게 하b b
                        builder.setCancelable(false);
                        builder.setMessage("Conglatulations. My guess was "+random
                                + "\n\n You know my number in "+userAttempts
                                + "attempts. \n\n Your guesses : "+guessesList
                                + "\n\n Would you like to play again?"
                        );
                        // Positive Button , new dialogue interface
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(GuessingGameActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        });

                        //Negative Button and Click Listener
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //task back
                                moveTaskToBack(true);
                                //kill myPid
                                android.os.Process.killProcess(android.os.Process.myPid());
                                //system 종료
                                System.exit(1);
                            }
                        });
                        //생성 후 보여주기
                        builder.create().show();
                    }

                    if (random < userGuess) {
                        textViewHint.setText("Increase your guess");
                    }

                    if (random > userGuess) {
                        textViewHint.setText("Decrease your guess");
                    }

                    if (remainingRight == 0){

                    }

                    editTextGuess.setText("");
                }
            }
        });
    }
}
