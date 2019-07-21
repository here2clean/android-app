package com.esgi3D.here2cleanapp;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.esgi3D.here2cleanapp.Requests.EventRequests;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GetTokenResult;

public class EventActivity extends AppCompatActivity {

    FloatingActionButton FABinscription;
    Event event;
    TextView descriptionTxt;
    Context context;
    Boolean IsVolunteer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
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
                    FirebaseAuth.getInstance().getAccessToken(true).addOnCompleteListener(new OnCompleteListener<GetTokenResult>() {
                        @Override
                        public void onComplete(@NonNull Task<GetTokenResult> task) {
                            if(!task.isSuccessful()) return;
                            RequestQueue q = Volley.newRequestQueue(context);
                            q.add(new EventRequests(context).AddVolunteerToAnEvent(task.getResult().getToken(),1,event.getId()));
                        }
                    });


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
