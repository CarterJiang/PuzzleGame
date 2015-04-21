package com.example.j3905_000.puzzlegame;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by j3905_000 on 4/6/2015.
 */
public class ResultFragment extends Fragment {

    Button Entry;
    EditText Congra;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.result_layout, container, false);

        Entry = (Button)v.findViewById(R.id.Enter_Button);
        Congra=(EditText)v.findViewById(R.id.Congratulation);

        return v;
    }
}
