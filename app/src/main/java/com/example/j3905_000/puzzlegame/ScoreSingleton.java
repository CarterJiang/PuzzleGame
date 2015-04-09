package com.example.j3905_000.puzzlegame;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by j3905_000 on 2015/4/9.
 */
public class ScoreSingleton {
    private static ScoreSingleton mScoreSingleton;
    private Context mAppContext;
    private ArrayList<Score> mScores;

    private ScoreSingleton(Context appContext){
        mAppContext=appContext;
        mScores= new ArrayList<Score>();
        for(int i=0;i<10;i++){
            Score s=new Score();
            s.setmTitle("Rank #"+i);
            mScores.add(s);

        }

    }

    public static ScoreSingleton get(Context c){
        if(mScoreSingleton==null){
            mScoreSingleton=new ScoreSingleton(c.getApplicationContext());
        }
        return mScoreSingleton;
    }

    public ArrayList<Score> getScore(){
        return mScores;
    }

}