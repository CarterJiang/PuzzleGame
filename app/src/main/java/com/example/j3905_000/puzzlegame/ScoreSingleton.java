package com.example.j3905_000.puzzlegame;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by j3905_000 on 2015/4/9.
 */
public class ScoreSingleton {

    private static final String FILENAME ="scores.json";


    private static ScoreSingleton mScoreSingleton;
    private Context mAppContext;
    private ArrayList<Score> mScores;
    private ScoreJSONSerializer mSerializer;


    private ScoreSingleton(Context appContext){
        mAppContext=appContext;
        try{
            mScores=mSerializer.loadScores();
        }
        catch (Exception e){
            mScores= new ArrayList<Score>();
        }

        mSerializer = new ScoreJSONSerializer(mAppContext,FILENAME);
        for(int i=1;i<11;i++){
            Score s=new Score();
            s.setmTitle("Rank "+i+"000000000");

            mScores.add(s);

        }
    }

    public  boolean saveScores(){
        try{
            mSerializer.saveScores(mScores);
            return true;
        }
        catch (Exception e){
            return  false;
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