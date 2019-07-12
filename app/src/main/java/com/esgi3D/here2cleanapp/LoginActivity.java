package com.esgi3D.here2cleanapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    VolunteerDAO volunteerDAO;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Context myContext = this;
        super.onCreate(savedInstanceState);
        VolunteerDAO volunteerDAO = new HttpVolunteerDAO();

        setContentView(R.layout.activity_main);
        login = findViewById(R.id.btn_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  FirebaseApp.initializeApp(myContext);
                ActionCodeSettings actionCodeSettings = ActionCodeSettings.newBuilder()
                        .setAndroidPackageName("com.dijouxdamien.here2cleanapp" , true,
                        null)
                        .setHandleCodeInApp(true)
                        .setUrl("heretoclean-876f4.firebaseapp.com")
                        .build();

                startActivityForResult(
                        AuthUI.getInstance()
                                .createSignInIntentBuilder()
                                .setAvailableProviders(Arrays.asList(
                                        new AuthUI.IdpConfig.EmailBuilder().enableEmailLinkSignIn()
                                                .setActionCodeSettings(actionCodeSettings).build()))
                                        .build(),
                                        RC_SIGN_IN);
              */
                Intent goToMain = new Intent(LoginActivity.this, MenuActivity.class);

                startActivity(goToMain);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /*if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {
                // Successfully signed in
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                Intent goToMain = new Intent(LoginActivity.this, MenuActivity.class);
                goToMain.putExtra("user",user);
                startActivity(goToMain);

            } else {
                Toast.makeText(this, R.string.Erreur_0, Toast.LENGTH_SHORT).show();
            }/
        }*/
    }
}
