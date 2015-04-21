package com.example.j3905_000.puzzlegame;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by j3905_000 on 2015/4/9.
 */
public class ScoreListActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return new ScoreListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
}
