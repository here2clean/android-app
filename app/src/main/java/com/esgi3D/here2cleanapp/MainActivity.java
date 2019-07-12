package com.esgi3D.here2cleanapp;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ArrayAdapter<Event> events = new EventAdapter(this,0,new MockEventDAO().getAllEvents());
        setListAdapter(events);



    }

}
