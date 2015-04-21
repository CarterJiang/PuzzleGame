package com.example.j3905_000.puzzlegame;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

/**
 * Created by j3905_000 on 2015/4/9.
 */
public class Score {

    private static final String JSON_Score="score";
    private static final String JSON_Date="date";
    private static final String JSON_Rank="rank";
    private static final String JSON_Title="title";
    private static final String JSON_Name="name";


    int mScore;
    Date mDate = new Date();
    int mRank;
    String mTitle;
    String name;

    public Score(){
        Score s= new Score();
    }

    public  Score(JSONObject json) throws JSONException{
        mScore = json.getInt(JSON_Score);
        mDate=new Date(json.getLong(JSON_Date));
        name= json.getString(JSON_Name);
        mRank=json.getInt(JSON_Rank);
        mTitle=json.getString(JSON_Title);

    }

    public JSONObject toJSON() throws JSONException{
        JSONObject json = new JSONObject();
        json.put(JSON_Score,mScore);
        json.put(JSON_Name,name);
        json.put(JSON_Date,mDate.getTime());
        json.put(JSON_Rank,mRank);
        return json;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getRank(){
        return mRank;
    }
    public void setRank(int Rank){
        this.mRank=Rank;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }




    public int getmScore() {
        return mScore;
    }

    public void setmScore(int mScore) {
        this.mScore = mScore;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }


    @Override
    public String toString() {
        return mTitle;
    }
}
