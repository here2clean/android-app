package com.esgi3D.here2cleanapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;

public class LoginActivity extends AppCompatActivity {

    VolunteerDAO volunteerDAO;
    private Button login;
    private Button signUp;

    private EditText email;
    private EditText pw;
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Context myContext = this;
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        login = findViewById(R.id.btn_login);
        signUp = findViewById(R.id.btn_sgnup);

        email = (EditText) findViewById(R.id.emailET);
        pw = (EditText) findViewById(R.id.pwET);

        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();

        login.setOnClickListener(signWithEmail);
        signUp.setOnClickListener(goToSignUpForm);


    }

    View.OnClickListener signWithEmail = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if (email.getText().toString().isEmpty()) {
                email.setError("Mail obligatoire");
                return;
            }
            if (pw.getText().toString().isEmpty()) {
                pw.setError("Passeword obligatoire");
                return;
            }
            signIn();
        }
    };

    View.OnClickListener goToSignUpForm = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
                Intent signUpIntent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(signUpIntent);
        }
    };


    public void signIn() {
        final String emailText = email.getText().toString();
        String pwText = pw.getText().toString();
        final Intent goToMain = new Intent(LoginActivity.this, MenuActivity.class);


        mAuth.signInWithEmailAndPassword(emailText, pwText).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    goToMain.putExtra("USER_MAIL",emailText);
                    startActivity(goToMain);
                } else {
                    Toast.makeText(LoginActivity.this, "L'authentification a échoué ! ", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    }




}
