package com.project.jessebalfe.languages;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

public class Level2 extends AppCompatActivity implements View.OnClickListener {

    // arraylists to hold the sentences and the correct answers
    private ArrayList<String> sentences;
    private ArrayList<String> answers;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);


        //load the arrays from previous activity
        Intent i = getIntent();
        sentences = i.getStringArrayListExtra("sentences2");
        answers = i.getStringArrayListExtra("answers2");

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
        for(int g = 0; g < answers.size(); g++) {
            LinearLayout ll = new LinearLayout(this);
            ll.setOrientation(LinearLayout.HORIZONTAL);


            //adds question number, and blank where verb was
            TextView sent = new TextView(this);
            sent.setTextColor(Color.BLACK);
            sent.setTextSize(2,20);
            sent.setEms(50);
            int j = g + 1;
            sent.setText(j + ":");
            String q = sentences.get(g);
            String [] split = q.split("\\s");
            for(int l = 0; l < split.length; l++){
                if(split[l].equals(answers.get(g))){
                    sent.append(" __ ");
                }
                else sent.append(split[l] + " ");
            }
            lm.addView(sent);

            //editText for typing the verb, singleLine as verb will not need more than that
            int r = g + 1;
            et[g] = new EditText(this);
            et[g].setSingleLine(true);
            ll.addView(et[g]);

            //create green button
            final Button b = new Button(this);
            b.getBackground().setColorFilter(0xFF00FF00, PorterDuff.Mode.MULTIPLY);
            b.setId(g);
            String s = Integer.toString(r);
            b.setText("Check");
            b.setLayoutParams(params);
            final int id_ = b.getId();
            final int ans = g;
            final String correct = answers.get(ans);
            final Boolean first = true;
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


    @Override
    public void onClick(View v) {

    }
}
