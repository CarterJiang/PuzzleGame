package com.example.j3905_000.puzzlegame;

import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by j3905_000 on 2015/4/9.
 */
public class ScoreListFragment extends ListFragment {
    private ArrayList<Score> mScores;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.scores_title);
        mScores=ScoreSingleton.get(getActivity()).getScore();

        ArrayAdapter<Score> adapter = new ArrayAdapter<Score>(getActivity(),android.R.layout.simple_list_item_1,mScores);
        setListAdapter(adapter);



    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Score s= (Score)(getListAdapter()).getItem(position);
    }


}
