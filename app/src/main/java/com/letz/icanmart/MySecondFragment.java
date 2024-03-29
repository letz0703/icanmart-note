package com.letz.icanmart;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MySecondFragment extends Fragment {

    TextView info;

    EditText name, email;
    Button send;

    public MySecondFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_second, container, false);

        name = view.findViewById(R.id.editText2ndFragName);
        email = view.findViewById(R.id.editTextText2ndFragEmail);
        info = view.findViewById(R.id.textViewFirstFragInfoData);
        send = view.findViewById(R.id.btn2ndFragSendData);

        Bundle bundle = getArguments();
        String userInfo = bundle.getString("userInfo");

        info.setText(userInfo);

        String userName = name.getText().toString();
        String userEmail = email.getText().toString();


        // Main activity 가져오기
        MainActivity mainActivity = (MainActivity) getActivity();

        mainActivity.takeData(userName, userEmail);

        return view;
    }
}