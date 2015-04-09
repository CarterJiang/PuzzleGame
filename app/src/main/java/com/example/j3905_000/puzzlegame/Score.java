package com.example.j3905_000.puzzlegame;

import java.util.Date;

/**
 * Created by j3905_000 on 2015/4/9.
 */
public class Score {
    int mScore;
    Date mDate;
    int mRank;


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

    String mTitle;


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


}
