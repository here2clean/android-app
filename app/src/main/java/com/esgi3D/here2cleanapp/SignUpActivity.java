package com.esgi3D.here2cleanapp;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.esgi3D.here2cleanapp.Requests.EventRequests;
import com.esgi3D.here2cleanapp.Requests.VolunteerRequests;

public class SignUpActivity extends Activity {

    Button btnSgnUp;
    TextView txtName;
    TextView txtSurname;
    TextView txtPassword;
    TextView txtPasswordR;
    TextView txtMail;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btnSgnUp = findViewById(R.id.btn_sign_up);
        txtMail = findViewById(R.id.tb_mail_su);
        txtName = findViewById(R.id.tb_name_su);
        txtPassword =findViewById(R.id.tb_pwd_su);
        txtSurname = findViewById(R.id.tb_surname_su);
        txtPasswordR = findViewById(R.id.tb_pwdr_su);
        context = this;


        btnSgnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(txtPassword.getText().toString().equals(txtPasswordR.getText().toString()))){
                    Toast.makeText(SignUpActivity.this, "Les mots de passe ne correspondent pas", Toast.LENGTH_SHORT).show();
                }

                if((txtMail.getText().length()  == 0) && (txtPassword.getText().length()  == 0) ){
                    Toast.makeText(SignUpActivity.this, "Les champs mail et mot de passe sont obliggatoires", Toast.LENGTH_SHORT).show();
                }


                RequestQueue q = Volley.newRequestQueue(context);

                q.add(new VolunteerRequests(context).SignUp(txtMail.getText().toString(), txtPassword.getText().toString(), txtName.getText().toString(), txtSurname.getText().toString()));

            }
        });
    }
}
