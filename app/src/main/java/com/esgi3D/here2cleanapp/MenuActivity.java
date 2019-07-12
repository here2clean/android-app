package com.esgi3D.here2cleanapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    public Button AssociationBtn;
    public Button EventBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        AssociationBtn = findViewById(R.id.AssociationBtn);
        EventBtn = findViewById(R.id.EventBtn);

        AssociationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavToAssocitions();
            }
        });

        EventBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavToEvents();
            }
        });

    }

    private void NavToEvents() {
        Intent navToEvents = new Intent(MenuActivity.this, MainActivity.class);
        startActivity(navToEvents);
    }

    private void NavToAssocitions() {
        Intent navToAssocs = new Intent(MenuActivity.this, AssociationsActivity.class);
        startActivity(navToAssocs);
    }


}
