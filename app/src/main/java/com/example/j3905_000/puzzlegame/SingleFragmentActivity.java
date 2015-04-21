package com.example.j3905_000.puzzlegame;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by j3905_000 on 2015/4/9.
 */
public abstract class SingleFragmentActivity extends ActionBarActivity {
    protected abstract Fragment createFragment();
    AudioPlayer background= new AudioPlayer();



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //background.play(this);


        setContentView(R.layout.activity_fragment);
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragmentContainer);

        if (fragment == null) {
            fragment = createFragment();
            manager.beginTransaction()
                    .add(R.id.fragmentContainer, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

      switch (item.getItemId()) {
             case R.id.BGM:

                if(getTitle()=="Music Off"){
                   background.pause(this);
                    setTitle("Music On");
                }
                else{
                    setTitle("Music Off");
                    background.play(this);
                }
                return true;



            case R.id.exit_the_app:
            DialogFragment exitFragment = new ExitDialog();
            exitFragment.show(getFragmentManager(),"ExitDialog");


            return true;

        }

        return super.onOptionsItemSelected(item);
    }
}