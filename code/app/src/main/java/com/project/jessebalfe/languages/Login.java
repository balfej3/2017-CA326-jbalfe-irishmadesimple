package com.project.jessebalfe.languages;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity implements View.OnClickListener {

    //required variables
    private static final String TAG = "EmailPassword";

    private Button buttonRegister;
    private Button textViewForgot;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button textViewSignin;

    private FirebaseAuth mAuth;

    private FirebaseAuth.AuthStateListener mAuthListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //setup buttons, make them green
        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        textViewSignin = (Button) findViewById(R.id.textViewSignin);
        textViewForgot = (Button) findViewById(R.id.forgot);

        buttonRegister.getBackground().setColorFilter(0xFF00FF00, PorterDuff.Mode.MULTIPLY);
        textViewSignin.getBackground().setColorFilter(0xFF00FF00, PorterDuff.Mode.MULTIPLY);
        textViewForgot.getBackground().setColorFilter(0xFF00FF00, PorterDuff.Mode.MULTIPLY);

        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        buttonRegister.setOnClickListener(this);
        textViewSignin.setOnClickListener(this);
        textViewForgot.setOnClickListener(this);

        //for firebase authentication
        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
            }
        };

    }

    @Override
    public void onClick(View v) {
        if(v == textViewSignin){
            registerUser();
        }
        if(v == buttonRegister){
            signIn();
        }
        if(v == textViewForgot){
            reset();
        }
    }

    private void signIn(){
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        signIn(email, password);
    }


    private void signIn(final String email, final String password) {
        //if not correct format, don't log in
        if (!validateForm()) {
            return;
        }
        Toast.makeText(this, "Attempting Login", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "signIn:" + email);

        //default firebase method for loggin in users
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "signInWithEmail:failed", task.getException());
                            Toast.makeText(Login.this, "Login Failed",
                                    Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(Login.this, "Welcome " + email,
                                    Toast.LENGTH_SHORT).show();
                                    nextPage();
                        }
                    }
                });
        // [END sign_in_with_email]
    }

    public void registerUser(){
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }

    public void nextPage(){
        Intent intent = new Intent(this, UserType.class);
        startActivity(intent);
    }

    private boolean validateForm() {
        boolean valid = true;

        String email = editTextEmail.getText().toString();
        if (TextUtils.isEmpty(email)) {
            editTextEmail.setError("Required.");
            valid = false;
        } else {
            editTextEmail.setError(null);
        }

        String password = editTextPassword.getText().toString();
        if (TextUtils.isEmpty(password)) {
            editTextPassword.setError("Required.");
            valid = false;
        } else {
            editTextPassword.setError(null);
        }

        return valid;
    }

    //method to send users an email if they can't recall their password, requires email
    private void reset(){
        String email = editTextEmail.getText().toString().trim();
        if(android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mAuth.sendPasswordResetEmail(email)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Login.this, "We have sent you instructions to reset your password!", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(Login.this, "Failed to send reset email!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }else{
            editTextEmail.setError("Enter your email to reset password.");
        }
    }

}
