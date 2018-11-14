package com.project.jessebalfe.languages;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class LevelSelection extends AppCompatActivity implements View.OnClickListener {
    private Button l1;
    private Button l2;
    private Button l3;
    private Button l4;
    private ArrayList<String> sentences;
    private ArrayList<String> answers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_selection);
        l1 = (Button) findViewById(R.id.l1);
        l2 = (Button) findViewById(R.id.l2);
        l3 = (Button) findViewById(R.id.l3);
        l4 = (Button) findViewById(R.id.l4);
        l1.setOnClickListener(this);
        l2.setOnClickListener(this);
        l3.setOnClickListener(this);
        l4.setOnClickListener(this);

        Intent i = getIntent();
        sentences = i.getStringArrayListExtra("sentences");
        answers = i.getStringArrayListExtra("answers");

        l1.getBackground().setColorFilter(0xFFF44336, PorterDuff.Mode.MULTIPLY);
        l2.getBackground().setColorFilter(0xFFFF8F00, PorterDuff.Mode.MULTIPLY);
        l3.getBackground().setColorFilter(0xFF00FF00, PorterDuff.Mode.MULTIPLY);
        l4.getBackground().setColorFilter(0xFFF44336, PorterDuff.Mode.MULTIPLY);
    }

    private void levelOne(){
            Intent intent = new Intent(this, Level1.class);
            intent.putStringArrayListExtra("sentences", sentences);
            intent.putStringArrayListExtra("answers", answers);
            startActivity(intent);
    }

    private void levelTwo(){
        Intent intent = new Intent(this, Level2.class);
        intent.putStringArrayListExtra("sentences2", sentences);
        intent.putStringArrayListExtra("answers2", answers);
        startActivity(intent);
    }

    private void levelThree(){
        Intent intent = new Intent(this, Level3.class);
        intent.putStringArrayListExtra("sentences2", sentences);
        intent.putStringArrayListExtra("answers2", answers);
        startActivity(intent);
    }

    private void logout(){
        FirebaseAuth.getInstance().signOut();
        Toast.makeText(this, "See You Soon!", Toast.LENGTH_SHORT).show();
        Context c = this.getApplicationContext();
        saveArray(sentences, "sentences", c);
        saveArray(answers, "answers", c);
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public boolean saveArray(ArrayList<String> array, String arrayName, Context mContext) {
        SharedPreferences prefs = mContext.getSharedPreferences("preferenceName", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(arrayName +"_size", array.size());
        for(int i=0;i<array.size();i++){
            editor.putString(arrayName + "_" + i, array.get(i));
            Log.d("V",array.get(i) + " ADDED");
        }

        return editor.commit();
    }
    //load different level based on user selection
    public void onClick(View v) {
        if(v == l1){
            levelOne();
        }

        if(v == l2){
            levelTwo();
        }

        if(v == l3){
            levelThree();
        }

        if(v == l4){
            logout();
        }
    }
}
