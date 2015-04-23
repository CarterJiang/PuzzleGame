package com.example.j3905_000.puzzlegame;

import android.graphics.Bitmap;

/**
 * Created by j3905_000 on 2015/4/15.
 */
public class Jewlery {
    private String type;
    private Bitmap image;
    boolean needEliminate;
    public boolean getNeedEliminate() {
        return needEliminate;
    }

    public void setNeedEliminate(boolean needEliminate) {
        this.needEliminate = needEliminate;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
