package com.esgi3D.here2cleanapp;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.esgi3D.here2cleanapp.Requests.AssociationRequests;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AssociationsActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_associations);
        List<Association> assocs = new ArrayList<>();
        ArrayAdapter<Association> adapter = new AssociationAdapter(this,0, new ArrayList<Association>());

        RequestQueue q = Volley.newRequestQueue(this);

        q.add(new AssociationRequests(this).GetAllAssociation());
       // setListAdapter(a, assocs);
    }

}
