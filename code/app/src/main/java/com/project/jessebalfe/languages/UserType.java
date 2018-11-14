package com.project.jessebalfe.languages;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class UserType extends AppCompatActivity implements View.OnClickListener {

    private Button complete;
    private Button generate;
    private ArrayList<String> sentences = new ArrayList<>();
    private ArrayList<String> answers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_type);
        complete = (Button) findViewById(R.id.bComplete);
        generate = (Button) findViewById(R.id.bGenerate);
        complete.setOnClickListener(this);
        generate.setOnClickListener(this);
        complete.getBackground().setColorFilter(0xFF00FF00, PorterDuff.Mode.MULTIPLY);
        generate.getBackground().setColorFilter(0xFF00FF00, PorterDuff.Mode.MULTIPLY);
    }

    public ArrayList<String> loadArray(String arrayName, Context mContext) {
        SharedPreferences prefs = mContext.getSharedPreferences("preferenceName", 0);
        int size = prefs.getInt(arrayName + "_size", 0);
        ArrayList<String> array  = new ArrayList<>();
        for(int i=0;i<size;i++) {
            String x = prefs.getString(arrayName + "_" + i, null);
            array.add(i, x);
            Log.d("V",array.get(i) + " ADDED");
        }
        return array;
    }
    @Override
    public void onClick(View v) {
        if(v == complete){
            Context c = this.getApplicationContext();
            sentences = loadArray("sentences", c);
            answers = loadArray("answers", c);
            Intent intent = new Intent(this, LevelSelection.class);
            intent.putStringArrayListExtra("sentences", sentences);
            intent.putStringArrayListExtra("answers", answers);
            startActivity(intent);
        }

        if(v == generate){
            Intent intent = new Intent(this, Options.class);
            startActivity(intent);
        }
    }
}

