package com.example.j3905_000.puzzlegame;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;

/**
 * Created by j3905_000 on 2015/4/9.
 */
public class ScoreListActivity extends SingleFragmentActivity {

    Button MainPage;
    @Override
    protected Fragment createFragment() {
        return new ScoreListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainPage=(Button)findViewById(R.id.mainpage_button);
        MainPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }
}
