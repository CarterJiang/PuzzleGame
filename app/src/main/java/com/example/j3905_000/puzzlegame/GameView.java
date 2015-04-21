package com.example.j3905_000.puzzlegame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
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
    private ArrayList<Jewlery> mJewlery= new ArrayList<Jewlery>();
    float startx;
    float starty;
    float endx;
    float endy;
    int rows = 8;
    int cols = 7;
    float cellHeight;
    float cellWidth;
    Jewlery[][] jewleries = new Jewlery[rows][cols];


    public GameView(Context context) {
        this(context, null);
    }
    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        ruby= BitmapFactory.decodeResource(getResources(), R.drawable.gem_ruby);
        pearl= BitmapFactory.decodeResource(getResources(), R.drawable.gem_pearl);
        sapphire= BitmapFactory.decodeResource(getResources(), R.drawable.gem_sapphire);
        Random r = new Random();
        for(int i=0; i<rows; ++i) {
            for(int j=0; j<cols; ++j) {
                Jewlery jewlery = new Jewlery();
                int k = r.nextInt(3);
                if(k==0) {
                    jewlery.setImage(ruby);
                    jewlery.setType("ruby");
                } else if(k==1) {
                    jewlery.setImage(pearl);
                    jewlery.setType("pearl");
                } else {
                    jewlery.setImage(sapphire);
                    jewlery.setType("sapphire");
                }
                jewleries[i][j] = jewlery;
            }
        }
        //invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

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
        for(int i=0; i<rows; ++i) {
            int x = 0;
            for (int j = 0; j < cols; ++j) {
                Jewlery jewlery = jewleries[i][j];
                canvas.drawBitmap(jewlery.getImage(), x, y, paint);

                x += cellWidth;
            }
            y += cellHeight;
        }





        /*// Draw the text.
        canvas.drawText(mExampleString,
                paddingLeft + (contentWidth - mTextWidth) / 2,
                paddingTop + (contentHeight + mTextHeight) / 2,
                mTextPaint);

        // Draw the example drawable on top of the text.
        if (mExampleDrawable != null) {
            mExampleDrawable.setBounds(paddingLeft, paddingTop,
                    paddingLeft + contentWidth, paddingTop + contentHeight);
            mExampleDrawable.draw(canvas);
        }*/
    }

  void swap(Jewlery[][] array,int a, int b, int c, int d){
        jewleries[a][b]  = array[1][1];
        jewleries[a][b]= jewleries[c][d];
        jewleries[c][d]=array[1][1];

    }



    void updateCells(float sx, float sy, float ex, float ey) {
        //find out which cell was initially pressed
        int row = (int)(sy / cellHeight);
        int col = (int) (sx / cellWidth);
        int row2=(int)(endy/cellHeight);
        int col2=(int)(endx/cellHeight);
        //swap(row,col,row2,col2);









        jewleries[row][col].setImage(ruby);

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

                updateCells(startx, starty, endx, endy);
                break;
            case MotionEvent.ACTION_CANCEL:
        }
        return true;
    }

}
