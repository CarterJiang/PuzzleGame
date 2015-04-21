package com.example.j3905_000.puzzlegame;

import android.content.Context;
import android.media.MediaPlayer;

public class AudioPlayer {

    private MediaPlayer mPlayer;
    
    public void stop() {
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
    }

    public void play(Context c) {
        if(mPlayer==null) {
            stop();

            mPlayer = MediaPlayer.create(c, R.raw.background);

        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                stop();

            }
        });


        mPlayer.start();

        }



    }

    public void pause(Context c){
        mPlayer.pause();
    }
    
    public boolean isPlaying() {
        return mPlayer != null;
    }
    
}
