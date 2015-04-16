package com.example.j3905_000.puzzlegame;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by j3905_000 on 2015/4/16.
 */
public class MainFragment extends Fragment {
    Button StartButton;
    Button RankButton;
    Button QuitButton;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_main, container, false);
        StartButton= (Button)v.findViewById(R.id.start_button);
        StartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),GameActivity.class);
                startActivity(i);
            }
        });
        RankButton=(Button)v.findViewById(R.id.rank_button);
        RankButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),ScoreListActivity.class);
                startActivity(i);
            }
        });
        QuitButton=(Button)v.findViewById(R.id.quit_button);
        QuitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment exitFragment = new ExitDialog();
                exitFragment.show(getActivity().getFragmentManager(),"ExitDialog");

            }
        });
   return v;
    }
}