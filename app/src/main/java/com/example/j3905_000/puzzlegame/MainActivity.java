package com.example.j3905_000.puzzlegame;

import android.os.Bundle;
import android.support.v4.app.Fragment;


public class MainActivity  extends SingleFragmentActivity {
    static boolean bPlay = true;

    @Override
    protected Fragment createFragment() {
        return new MainFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }
        if(bPlay) {
            background.play(this);
            bPlay = false;
        }
    }
}
