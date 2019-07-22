package com.esgi3D.here2cleanapp;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.esgi3D.here2cleanapp.Requests.EventRequests;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GetTokenResult;

public class EventActivity extends AppCompatActivity {

    FloatingActionButton FABinscription;
    Event event;
    TextView descriptionTxt;
    TextView nameTxt;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_event);
        descriptionTxt = findViewById(R.id.tv_event_description_detail);
        nameTxt = findViewById(R.id.tv_event_nom_detail);



        if (getIntent() == null)
            return;
        if(getIntent().hasExtra("event"))
            event = (Event)(getIntent().getExtras().get("event"));

        if (event != null){
            descriptionTxt.setText(event.getDescription());
            nameTxt.setText(event.getName());
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

        FragmentManager manager = this.getSupportFragmentManager();
        MapViewFragment map = new MapViewFragment();
        Bundle bundle = new Bundle();
        bundle.putString("ADDRESS", event.getLocation());
        map.setArguments(bundle);
        manager.beginTransaction().replace(R.id.fragment, map).commit();
    }

}
