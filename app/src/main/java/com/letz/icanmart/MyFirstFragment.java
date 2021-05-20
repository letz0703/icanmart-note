package com.letz.icanmart;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyFirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyFirstFragment extends Fragment {

    TextView info;
    Button send;

    TextView result;
    public MyFirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_first, container, false);
        //match textView with it's id
        result = view.findViewById(R.id.textViewResultInFragment);

        Bundle bundle = getArguments();
        int userWeight = bundle.getInt("weight");
        int userHeight = bundle.getInt("height");

        //calculate
        double userBmi = userWeight*1000/(userHeight*userHeight);
        result.setText("Your BMI is : "+userBmi);

        return view;
    }
}