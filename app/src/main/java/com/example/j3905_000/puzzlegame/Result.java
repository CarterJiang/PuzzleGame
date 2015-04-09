package com.example.j3905_000.puzzlegame;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by j3905_000 on 4/6/2015.
 */
public class Result extends Activity {

    Button Entry;
    EditText Congra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Entry = (Button)findViewById(R.id.Enter_Button);
        Congra=(EditText)findViewById(R.id.Congratulation);
    }
}
