package com.project.jessebalfe.languages;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Options extends AppCompatActivity implements View.OnClickListener{

    private Button buttonType;
    private Button buttonFile;
    private ArrayList<String> verbs = new ArrayList<>();
    private ArrayList<String> sentences = new ArrayList<>();
    private ArrayList<String> answers = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        buttonFile = (Button) findViewById(R.id.button5);
        buttonType = (Button) findViewById(R.id.button6);

        buttonType.setOnClickListener(this);
        buttonFile.setOnClickListener(this);

        buttonFile.getBackground().setColorFilter(0xFF00FF00, PorterDuff.Mode.MULTIPLY);
        buttonType.getBackground().setColorFilter(0xFF00FF00, PorterDuff.Mode.MULTIPLY);
    }

    public void onClick(View v) {
        if(v == buttonType){
            Intent intent = new Intent(this, Start.class);
            startActivity(intent);
        }
        if(v == buttonFile){
            loadFiles();
            loadSentences();
        }
    }

    //check if sdcard can be read, for testing purposes
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            Log.d("J", "External Storage is readable");
            return true;
        }
        Log.d("J", "External Storage is not readable");
        return false;
    }

    //attempts to read a file called verbs.txt from external storage
    public void loadFiles(){
        isExternalStorageReadable();
        //gets sdcard directory as it may not be same on every phone
        String sdcard = Environment.getExternalStorageDirectory().getAbsolutePath();
        Toast.makeText(this, sdcard + " Added", Toast.LENGTH_SHORT).show();
        //Get the text file
        File file = new File(sdcard,"verbs.txt");




        StringBuilder t = new StringBuilder();
        //read verbs from file into arraylist, if file is there
        if(file.exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while ((line = br.readLine()) != null) {
                    verbs.add(line);
                    verbs.add("\n");
                    Toast.makeText(this, line + " Added", Toast.LENGTH_SHORT).show();
                }
                br.close();
                Intent intent = new Intent(this, EnterSentences.class);
                intent.putStringArrayListExtra("verbs2", verbs);
                startActivity(intent);

            } catch (IOException e) {
                Toast.makeText(this, "Error reading the file!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, Start.class);
                startActivity(intent);
            }

        }

        try {
            BufferedReader bReader = new BufferedReader(new InputStreamReader(getAssets().open("verbs.txt")));
            String line;
            while ((line = bReader.readLine()) != null){
                verbs.add(line);
                verbs.add("\n");
            }
            bReader.close();
            loadSentences();
            for (String v : verbs)
                Log.i("Array is ", v);
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "verbs.txt not found!", Toast.LENGTH_SHORT).show();
        }



    }

    private void loadSentences(){
        try {
            BufferedReader bReader = new BufferedReader(new InputStreamReader(getAssets().open("sentences.txt")));
            String line;
            while ((line = bReader.readLine()) != null){
                sentences.add(line);
                findVerb(line);
            }
            bReader.close();
            Intent intent = new Intent(this, LevelSelection.class);
            intent.putStringArrayListExtra("verbs2", verbs);
            intent.putStringArrayListExtra("sentences", sentences);
            intent.putStringArrayListExtra("answers", answers);
            startActivity(intent);
            for (String v : verbs)
                Log.i("Array is ", v);
        } catch (IOException e) {
            e.printStackTrace();
            Intent intent = new Intent(this, EnterSentences.class);
            intent.putStringArrayListExtra("verbs2", verbs);
            Toast.makeText(this, "sentences.txt not found!", Toast.LENGTH_SHORT).show();
        }
    }

    //identify verb in sentence by splitting it by spaces then pattern matching
    private void findVerb(String x){
        String s = x;
        String [] split = s.split("\\s");
        for(int j = 0; j < verbs.size(); j++){
            for(int q = 0; q < split.length; q++){
                if(split[q].equals(verbs.get(j))){
                    String k = split[q];
                    answers.add(k);
                }
            }
        }

    }
}
