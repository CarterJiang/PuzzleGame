package com.example.j3905_000.puzzlegame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by j3905_000 on 4/4/2015.
 */
public class Rank extends Activity {

    EditText Rank1;
    EditText Rank2;
    EditText Rank3;
    EditText Rank4;
    EditText Rank5;
    EditText Rank6;
    EditText Rank7;
    EditText Rank8;
    EditText Rank9;
    EditText Rank10;
    Button MainPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Rank1 =(EditText)findViewById(R.id.Highest_Score);
        Rank2 =(EditText)findViewById(R.id.Highest_Score2);
        Rank3 =(EditText)findViewById(R.id.Highest_Score3);
        Rank4 =(EditText)findViewById(R.id.Highest_Score4);
        Rank5 =(EditText)findViewById(R.id.Highest_Score5);
        Rank6 =(EditText)findViewById(R.id.Highest_Score6);
        Rank7 =(EditText)findViewById(R.id.Highest_Score7);
        Rank8 =(EditText)findViewById(R.id.Highest_Score8);
        Rank9 =(EditText)findViewById(R.id.Highest_Score9);
        Rank10 =(EditText)findViewById(R.id.Highest_Score10);
        MainPage=(Button)findViewById(R.id.mainpage_button);
        MainPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Rank.this,MainActivity.class);
                startActivity(i);
            }
        });



    }
}
