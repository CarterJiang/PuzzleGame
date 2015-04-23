package com.example.j3905_000.puzzlegame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;


/**
 * TODO: document your custom view class.
 */
public class GameView extends View {

    Bitmap ruby;
    Bitmap pearl;
    Bitmap sapphire;
    private ArrayList<Jewlery> mJewlery = new ArrayList<Jewlery>();
    float startx;
    float starty;
    float endx;
    float endy;
    int rows = 8;
    int cols = 7;
    int ScorePoint=0;
    float cellHeight;
    float cellWidth;
    Score score;


    Jewlery[][] jewleries = new Jewlery[rows][cols];


    public GameView(Context context) {
        this(context, null);
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        ruby = BitmapFactory.decodeResource(getResources(), R.drawable.gem_ruby);
        pearl = BitmapFactory.decodeResource(getResources(), R.drawable.gem_pearl);
        sapphire = BitmapFactory.decodeResource(getResources(), R.drawable.gem_sapphire);


        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                Jewlery jewlery = new Jewlery();
                randomlyDraw(jewlery);
                jewleries[i][j] = jewlery;


            }
        }
        //invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
      checkrow(jewleries);
      checkcol(jewleries);
      replace(jewleries);
        checkrow(jewleries);
        checkcol(jewleries);
        replace(jewleries);






        // TODO: consider storing these as member variables to reduce
        // allocations per draw cycle.
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();

        int contentWidth = getWidth() - paddingLeft - paddingRight;
        int contentHeight = getHeight() - paddingTop - paddingBottom;

        Paint paint = new Paint();
        cellHeight = getHeight() / rows;
        cellWidth = getWidth() / cols;

        int y = 0;
        for (int i = 0; i < rows; ++i) {
            int x = 0;
            for (int j = 0; j < cols; ++j) {
                Jewlery jewlery = jewleries[i][j];
                if (jewlery.getNeedEliminate() != true) {
                    canvas.drawBitmap(jewlery.getImage(), x, y, paint);
                }
                else{randomlyDraw(jewlery);
                    checkrow(jewleries);
                    checkcol(jewleries);
                    replace(jewleries);




                    ScorePoint+=20;
                    canvas.drawBitmap(jewlery.getImage(), x, y, paint);}

                x += cellWidth;
            }
            y += cellHeight;
        }

    }

    void randomlyDraw(Jewlery jewlery){
        Random r = new Random();
        int k = r.nextInt(3);
       if (k == 0) {
            jewlery.setImage(ruby);
            jewlery.setType("ruby");
        } else if (k == 1) {
            jewlery.setImage(pearl);
            jewlery.setType("pearl");
        } else {
            jewlery.setImage(sapphire);
            jewlery.setType("sapphire");
        }


    }

    void replace(Jewlery[][] jewlery){
        for(int i = 0;i<rows;++i){
            for(int j=0;j<cols;++j){
                if(jewlery[i][j].getNeedEliminate()==true){
                    randomlyDraw(jewlery[i][j]);
                    jewlery[i][j].setNeedEliminate(false);
                    ScorePoint+=20;

                }
            }
        }

    }


    void swap(int row, int col, int row2, int col2) {
        Log.d("GameView", row + " " + col + " " + row2 + " " + col2);
        Jewlery tmp = jewleries[row][col];
        //    tmp.setImage(jewleries[row][col].getImage());
        jewleries[row][col] = jewleries[row2][col2];
        //  jewleries[row][col].setImage(jewleries[row2][col2].getImage());
        jewleries[row2][col2] = tmp;


    }


    void checkrow(Jewlery[][] jewlery) {
        for (int i = 0; i < rows; ++i) {
            ArrayList<Jewlery> same = new ArrayList<Jewlery>();
            same.add(jewlery[i][0]);
            for (int j = 1; j < cols; ++j) {
                if (jewlery[i][j].getType() == jewlery[i][j - 1].getType()) {
                    same.add(jewlery[i][j]);
                }
                else {
                    if (same.size() >= 3) {
                        for (int k = 0; k < same.size(); ++k) {
                            same.get(k).setNeedEliminate(true);
                        }

                    }
                    else {for (int k = 0; k < same.size(); ++k) {
                        same.get(k).setNeedEliminate(false);
                    }}

                    same.clear();
                    same.add(jewlery[i][j]);
                }
            }
            if (same.size() >= 3) {
                for (int k = 0; k < same.size(); ++k) {
                    same.get(k).setNeedEliminate(true);
            }

            }
        }



       }


    void checkcol(Jewlery[][] jewlery) {
    for( int j = 0; j<cols;++j) {
        ArrayList<Jewlery> same = new ArrayList<Jewlery>();
        same.add(jewlery[0][j]);
        for (int i = 1; i < rows; ++i) {
            if (jewlery[i][j].getType() == jewlery[i - 1][j].getType()) {
                same.add(jewlery[i][j]);
            } else {
                if (same.size() >= 3) {
                    for (int k = 0; k < same.size(); ++k) {
                        same.get(k).setNeedEliminate(true);
                    }

                }
                else {for (int k = 0; k < same.size(); ++k) {
                    same.get(k).setNeedEliminate(false);
                }}
                same.clear();
                same.add(jewlery[i][j]);
            }
        }
        if (same.size() >= 3) {
                for (int k = 0; k < same.size(); ++k) {
                    same.get(k).setNeedEliminate(true);
                }
        }

    }

}






    void updateCells(float sx, float sy, float ex, float ey) {
        //find out which cell was initially pressed
        int row = (int) (sy / cellHeight);
        int col = (int) (sx / cellWidth);
        int row2 = (int) (ey / cellHeight);
        int col2 = (int) (ex / cellWidth);
        row = (row < 0) ? 0: row;
        row = (row > rows-1) ? rows-1: row;
        row2 = (row2 < 0) ? 0: row2;
        row2 = (row2 > rows-1) ? rows-1: row2;
        col = (col < 0) ? 0: col;
        col = (col > cols-1) ? cols-1: col;
        col2 = (col2 < 0) ? 0: col2;
        col2 = (col2 > cols-1) ? cols-1: col2;

        swap(row,col,row2,col2);



   //     jewleries[row][col].setImage(tmp.getImage());

        invalidate();
    }


    public boolean onTouchEvent(MotionEvent event) {
        PointF curr = new PointF(event.getX(), event.getY());

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // reset our drawing state
                startx = event.getX();
                starty = event.getY();
                break;

            case MotionEvent.ACTION_MOVE:
                break;

            case MotionEvent.ACTION_UP:
                endx = event.getX();
                endy = event.getY();

                if(Math.abs(endx-startx)>=Math.abs(endy-starty)){
                //move vertically
                    if(endx>=startx){
                        endx=startx+cellWidth;
                        endy=starty;
                    }
                  else  if(endx<startx){
                        endx=startx-cellWidth;
                        endy=starty;
                    }
                }
                else  if(Math.abs(endx-startx)<Math.abs(endy-starty)){
                    //move horizontally
                    if(endy>=starty){
                        endy=starty+cellHeight;
                        endx=startx;
                    }
                  else  if(endy<starty){
                        endy=starty-cellHeight;
                        endx=startx;
                    }
                }
                /*else{
                    endy=starty;
                    endx=startx;
                }*/







                updateCells(startx, starty, endx, endy);
                break;
            case MotionEvent.ACTION_CANCEL:
        }
        return true;
    }

}
