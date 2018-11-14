package com.project.jessebalfe.languages;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;


public class Level1 extends AppCompatActivity implements View.OnClickListener {

    // arraylists to hold the sentences and the correct answers
    private ArrayList<String> sentences;
    private ArrayList<String> answers;
    private int score = 0;
    //private ArrayList<ArrayList<String>> tense = new ArrayList<ArrayList<String>>();
    //private HashMap<String, ArrayList<String>> tenseAnswers = new HashMap<String, ArrayList<String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);




        //load the arrays from previous activity
        Intent i = getIntent();
        sentences = i.getStringArrayListExtra("sentences");
        answers = i.getStringArrayListExtra("answers");

        //populateTenses();

        //setup the layout
        final LinearLayout lm = (LinearLayout) findViewById(R.id.linearL1);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        Drawable myIcon = getResources().getDrawable( R.drawable.bg );
        lm.setBackground(myIcon);

      TextView myText = new TextView(this);
        lm.addView(myText);
        myText.setTextSize(2,15);
        myText.setTextColor(Color.BLACK);

        //possibleAnswers();

        //add button for when the user is finished
        final Button c = new Button(this);
        c.getBackground().setColorFilter(0xFF00FF00, PorterDuff.Mode.MULTIPLY);
        c.setText("Click Here When Finished");
        lm.addView(c);
        c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(view.getContext(),
                        "Score: " + score, Toast.LENGTH_SHORT)
                        .show();
                Intent intent = new Intent(c.getContext(), Score.class);
                startActivity(intent);
            }
        });


        final EditText et[] = new EditText[answers.size()];

        //dynamically add textview, edittext and button for each sentence
        for(int g = 0; g < sentences.size(); g++) {
            LinearLayout ll = new LinearLayout(this);
            ll.setOrientation(LinearLayout.HORIZONTAL);


            //adds question number, and blank where verb was
            TextView sent = new TextView(this);
            sent.setTextColor(Color.BLACK);
            sent.setTextSize(2,20);
            sent.setEms(80);
            int j = g + 1;
            sent.setText(j + ":");
            Character bracket = '(';
            String q = sentences.get(g);
            String [] split = q.split("\\s");
            for(int l = 0; l < split.length; l++){
                if(split[l].equals(answers.get(g))){
                    int r  = l + 1;
                    if(split[r].contains(Character.toString(bracket))&& r < split.length){
                        sent.append(split[r] + " ");
                        l++;
                    }else{
                        sent.append(" ____ ");
                    }

                } else {
                    sent.append(split[l] + " ");
                    Log.d("V", "Reached end");
                }

            }
            lm.addView(sent);

            //editText for typing the verb, singleLine as verb will not need more than that
            int r = g + 1;
            et[g] = new EditText(this);
            et[g].setSingleLine(true);
            et[g].setEms(5);
            ll.addView(et[g]);

            //create green button
            final Button b = new Button(this);
            b.getBackground().setColorFilter(0xFF00FF00, PorterDuff.Mode.MULTIPLY);
            b.setId(g);
            String s = Integer.toString(r);
            b.setText("Check");
            b.setLayoutParams(params);
            final int ans = g;
            final String correct = answers.get(ans);
            //check if user input is correct and let them know if so
            b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    String ss = et[ans].getText().toString();
                    if(ss.equals(correct)){
                        Toast.makeText(view.getContext(),
                                "Correct!", Toast.LENGTH_SHORT)
                                .show();
                        score++;
                        b.setEnabled(false);
                        b.setClickable(false);
                    }else{
                        Toast.makeText(view.getContext(),
                                "Try again ", Toast.LENGTH_SHORT)
                                .show();
                    }
                }
            });

            ll.addView(b);
            //Add button to LinearLayout defined in XML
            lm.addView(ll);
        }

    }

 /*
    private void possibleAnswers() {
        for(int g = 0; g < sentences.size();g++){
            String a  = answers.get(g);
            Toast.makeText(this, a, Toast.LENGTH_SHORT).show();
            for(int x = 0; x < sentences.size(); x++){
                ArrayList<String> t = tense.get(x);
                for(int k = 0; k < t.size();k++){
                    Log.d("V", t.get(k));
                    if(a.equals(t.get(k))){
                        Log.d("V", "added to hashmap");
                        tenseAnswers.put(a, t);
                    }
                }
            }
        }
    }
*/

  /*  private void populateTenses(){
        int r = 0;
        try {
            BufferedReader bReader = new BufferedReader(new InputStreamReader(getAssets().open("tenses.txt")));
            String line;
            while ((line = bReader.readLine()) != null){
                String [] split = line.split("\\s");
                tense.add(new ArrayList<String>());
                for(int q = 0; q < split.length; q++){
                    tense.get(r).add(split[q]);
                }
            }
            bReader.close();

        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "tenses.txt not found!", Toast.LENGTH_SHORT).show();
        }
    }
*/
    @Override
    public void onClick(View v) {

    }
}
