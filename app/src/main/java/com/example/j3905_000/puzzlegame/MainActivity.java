package com.example.j3905_000.puzzlegame;

import android.os.Bundle;
import android.support.v4.app.Fragment;


public class MainActivity  extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return new MainFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
