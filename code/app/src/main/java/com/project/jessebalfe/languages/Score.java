package com.project.jessebalfe.languages;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Score extends AppCompatActivity implements View.OnClickListener {

    private Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        logout = (Button) findViewById(R.id.bLogout);
        logout.setOnClickListener(this);
        logout.getBackground().setColorFilter(0xFF00FF00, PorterDuff.Mode.MULTIPLY);
    }

    @Override
    public void onClick(View v) {
        //logs user out and returns to first activity register/login
        if(v == logout){
            FirebaseAuth.getInstance().signOut();
            Toast.makeText(this, "See You Soon!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
        }
    }
}
