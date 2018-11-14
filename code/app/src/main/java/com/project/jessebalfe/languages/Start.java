package com.project.jessebalfe.languages;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Start extends AppCompatActivity implements View.OnClickListener {

    private Button buttonAdd;
    private EditText editTextVerbs;
    private Button buttonContinue;
    private ArrayList<String> verbs = new ArrayList<String>();
    private Boolean verb = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        editTextVerbs = (EditText) findViewById(R.id.editText);
        buttonAdd = (Button) findViewById(R.id.button);
        buttonContinue = (Button) findViewById(R.id.button2);

        buttonAdd.setOnClickListener(this);
        buttonContinue.setOnClickListener(this);

        buttonAdd.getBackground().setColorFilter(0xFF00FF00, PorterDuff.Mode.MULTIPLY);
        buttonContinue.getBackground().setColorFilter(0xFF00FF00, PorterDuff.Mode.MULTIPLY);
    }

    //adds verbs to arraylist one at a time, tells user via toast
    private void addVerb(){
        String s = editTextVerbs.getText().toString();
        if(s.equals(null) || s.equals("")|| s.equals(" ")){
            Toast.makeText(this,"Please enter a verb ", Toast.LENGTH_SHORT).show();
        }else{
            verb = true;
            verbs.add(s);
            editTextVerbs.setText("");
            Toast.makeText(this, s + " Added", Toast.LENGTH_SHORT).show();
        }

    }


    private void next(){
        Intent intent = new Intent(this, EnterSentences.class);
        intent.putStringArrayListExtra("verbs2", verbs);
        startActivity(intent);
    }

    public void onClick(View v) {
        if(v == buttonAdd){
            addVerb();
        }
        if(v == buttonContinue){
            if(verb) {
                next();
            }else{
                //stops user from continuing with no verbs added
                Toast.makeText(this, "At least one verb needed!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

