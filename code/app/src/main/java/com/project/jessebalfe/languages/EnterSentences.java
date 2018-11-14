package com.project.jessebalfe.languages;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class EnterSentences extends AppCompatActivity implements View.OnClickListener {
    //variables
    private Button buttonAdd2;
    private EditText editTextSentences;
    private Button buttonContinue2;
    private ArrayList<String> sentences = new ArrayList<>();
    private ArrayList<String> answers = new ArrayList<>();
    private ArrayList<String> hints = new ArrayList<>();
    private ArrayList<String> verbs;
    private boolean sentence = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_sentences);
        editTextSentences = (EditText) findViewById(R.id.editText2);
        buttonAdd2 = (Button) findViewById(R.id.button3);
        buttonContinue2 = (Button) findViewById(R.id.button4);

        buttonAdd2.setOnClickListener(this);
        buttonContinue2.setOnClickListener(this);
        Intent i = getIntent();
        verbs = i.getStringArrayListExtra("verbs2");

        //set buttons green
        buttonAdd2.getBackground().setColorFilter(0xFF00FF00, PorterDuff.Mode.MULTIPLY);
        buttonContinue2.getBackground().setColorFilter(0xFF00FF00, PorterDuff.Mode.MULTIPLY);

    }

    //method to add Sentence to array, first checking it isn't blank
    private void addSentence(){
        String s = editTextSentences.getText().toString();
        if(s.equals(null) || s.equals("")|| s.equals(" ")){
            Toast.makeText(this, "Please enter a sentence", Toast.LENGTH_SHORT).show();
        }else{
            sentence = true;
            sentences.add(s);
            findVerb();
            editTextSentences.setText("");
            Toast.makeText(this, "Sentence Added", Toast.LENGTH_SHORT).show();
        }

    }

    //pass the arraylists of verbs + sentences to next activity, load next activity
    private void next(){
        Intent intent = new Intent(this, LevelSelection.class);
        intent.putStringArrayListExtra("sentences", sentences);
        intent.putStringArrayListExtra("answers", answers);
        startActivity(intent);
    }

    //identify verb in sentence by splitting it by spaces then pattern matching
    private void findVerb(){
        String s = editTextSentences.getText().toString();
        String [] split = s.split("\\s");
        for(int j = 0; j < verbs.size(); j++){
            for(int q = 0; q < split.length; q++){
                if(split[q].equals(verbs.get(j))){
                    String x = split[q];
                    answers.add(x);
                }
            }
        }

    }

    /*private void findHint(){
        String s = editTextSentences.getText().toString();
        String [] split = s.split("\\s");
        for(int q = 0; q < split.length; q++){
                if(split[q].startsWith("(")){
                    String x = split[q];
                    hints.add(x);
                }
            }
        }
    }*/

    //check which button is clicked, disallow continuing without sentences
    public void onClick(View v) {
        if(v == buttonAdd2){
            addSentence();
        }
        if(v == buttonContinue2){
            if(sentence){
                next();
            }else{
                Toast.makeText(this, "At least one sentence needed!", Toast.LENGTH_SHORT).show();
            }

        }

    }
}
