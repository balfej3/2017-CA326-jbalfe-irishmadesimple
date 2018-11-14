package com.project.jessebalfe.languages;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class Level3 extends AppCompatActivity {

    private Spinner spinner;
    private ArrayList<String> sentences;
    private ArrayList<String> answers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level3);
        initializeUI();
        Intent i = getIntent();
        sentences = i.getStringArrayListExtra("sentences2");
        answers = i.getStringArrayListExtra("answers2");

    }

    private void initializeUI() {

        spinner = (Spinner) findViewById(R.id.testSpin);


        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, answers);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

    }
}
