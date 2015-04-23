package com.example.j3905_000.puzzlegame;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Created by j3905_000 on 2015/4/15.
 */
public class GameFragment extends Fragment {

    TextView mPoint;
    TextView mCountdown;
    int p;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.game_fragment, container, false);

        mPoint =(TextView)v.findViewById(R.id.score_point);


        mCountdown=(TextView)v.findViewById(R.id.countdown_timer);

        new CountDownTimer(60000, 1000) {

            public void onTick(long millisUntilFinished) {
                mCountdown.setText("seconds remaining: " + millisUntilFinished / 1000);
                mCountdown.setTextSize(20);
            }

            public void onFinish() {
                mCountdown.setText("done!" );
                Intent i = new Intent(getActivity(),ResultActivity.class);
                startActivity(i);

            }
        }.start();



        return v;

    }
}
