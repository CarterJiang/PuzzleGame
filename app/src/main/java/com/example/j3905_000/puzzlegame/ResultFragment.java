package com.example.j3905_000.puzzlegame;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * Created by j3905_000 on 4/6/2015.
 */
public class ResultFragment extends Fragment {

    Button Entry;
    TextView Congra;
    EditText UserName;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.result_layout, container, false);

    /*    Entry = (Button)v.findViewById(R.id.Enter_Button);
        Congra=(TextView)v.findViewById(R.id.Congratulation);
        UserName=(EditText)v.findViewById((R.id.user_name_edit_text));
        Score score=new Score();
    //    score.setmScore(0);
        Calendar c= Calendar.getInstance();
        Date date=new Date(Calendar.YEAR,Calendar.MONTH,Calendar.DAY_OF_MONTH,Calendar.HOUR,Calendar.MINUTE);
        score.setmDate(date);
        score.setName(UserName.getText().toString());

*/
        return v;
    }
}
