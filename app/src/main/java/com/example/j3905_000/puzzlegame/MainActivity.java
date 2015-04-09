package com.example.j3905_000.puzzlegame;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    Button StartButton;
    Button RankButton;
    Button QuitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StartButton= (Button)findViewById(R.id.start_button);
        RankButton=(Button)findViewById(R.id.rank_button);
        RankButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,ScoreListActivity.class);
                startActivity(i);
            }
        });
        QuitButton=(Button)findViewById(R.id.quit_button);
        QuitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment exitFragment = new ExitDialog();
                exitFragment.show(getFragmentManager(),"ExitDialog");

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        else if (id==R.id.exit_the_app){
            DialogFragment exitFragment = new ExitDialog();
            exitFragment.show(getFragmentManager(),"ExitDialog");


            return true;

        }

        return super.onOptionsItemSelected(item);
    }
}
