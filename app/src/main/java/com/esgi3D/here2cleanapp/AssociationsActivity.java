package com.esgi3D.here2cleanapp;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class AssociationsActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_associations);

        ArrayAdapter<Association> assocs = new AssociationAdapter(this,0,new MockAssociationDao().getAssociations());
        setListAdapter(assocs);
    }
}
