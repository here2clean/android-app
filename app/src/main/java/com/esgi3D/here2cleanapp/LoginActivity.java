package com.esgi3D.here2cleanapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    VolunteerDAO volunteerDAO;
    private Button login;

    private EditText email;
    private EditText pw;
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Context myContext = this;
        super.onCreate(savedInstanceState);
        VolunteerDAO volunteerDAO = new HttpVolunteerDAO();

        setContentView(R.layout.activity_main);
        login = findViewById(R.id.btn_login);

        email = (EditText) findViewById(R.id.emailET);
        pw = (EditText) findViewById(R.id.pwET);

        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        login.setOnClickListener(signWithEmail);

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


    public void signIn() {
        String emailText = email.getText().toString();
        String pwText = pw.getText().toString();
        final Intent goToMain = new Intent(LoginActivity.this, MenuActivity.class);


        mAuth.signInWithEmailAndPassword(emailText, pwText).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    startActivity(goToMain);
                } else {
                    Toast.makeText(LoginActivity.this, "L'authentification a échoué ! ", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    }


}
