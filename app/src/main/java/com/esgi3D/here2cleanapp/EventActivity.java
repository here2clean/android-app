package com.esgi3D.here2cleanapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;

public class EventActivity extends AppCompatActivity {

    FloatingActionButton FABinscription;
    Event event;
    TextView descriptionTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        Toolbar toolbar = findViewById(R.id.toolbar);
        descriptionTxt = findViewById(R.id.txt_event_description);
        setSupportActionBar(toolbar);


        if (getIntent() == null)
            return;
        if(getIntent().hasExtra("event"))
            event = (Event)(getIntent().getExtras().get("event"));

        if (event != null){
            descriptionTxt.setText(event.getDesc());
        }

            FABinscription = (FloatingActionButton) findViewById(R.id.fabIncription);

            FABinscription.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   FABinscription.setBackgroundColor(Color.GREEN);
                   FABinscription.setBackgroundDrawable(null);
                   FABinscription.setBackgroundResource(R.mipmap.ic_plus_round);
                }
            });







    }
    public LatLng getLocationFromAddress(String strAddress) {
        DataLongOperationAsynchTask converter = new DataLongOperationAsynchTask(this);
        try {
           return converter.execute(strAddress).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
