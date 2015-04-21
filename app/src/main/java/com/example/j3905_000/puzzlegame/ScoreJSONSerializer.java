package com.example.j3905_000.puzzlegame;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

/**
 * Created by j3905_000 on 2015/4/20.
 */
public class ScoreJSONSerializer {
    private Context mContext;
    private String mFilename;

    public  ScoreJSONSerializer(Context c,String f){
        mContext=c;
        mFilename=f;
    }


    public ArrayList<Score> loadScores() throws IOException, JSONException {
        ArrayList<Score> scores= new ArrayList<Score>();
        BufferedReader reader = null;
        try {
            InputStream in = mContext.openFileInput(mFilename);
            reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder jsonString = new StringBuilder();
            String line = null;
            while ((line=reader.readLine())!=null){
                jsonString.append(line);
            }
            JSONArray array = (JSONArray) new JSONTokener(jsonString.toString()).nextValue();

            for(int i=0;i<array.length();i++){
                scores.add(new Score(array.getJSONObject(i)));
            }
        }
        catch (FileNotFoundException e){

        }
        finally {
            if(reader!=null)
                reader.close();
        }
            return scores;
    }

    public void saveScore(ArrayList<Score> scores) throws JSONException,IOException{
        JSONArray array = new JSONArray();
        for(Score s: scores)
            array.put(s.toJSON());

        Writer writer =null;
        try {
            OutputStream out = mContext.openFileOutput(mFilename, Context.MODE_PRIVATE);
            writer = new OutputStreamWriter(out);
            writer.write(array.toString());
        } finally {
            if (writer != null)
                writer.close();
        }
    }
}
