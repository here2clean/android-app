package com.esgi3D.here2cleanapp;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ArrayAdapter;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.esgi3D.here2cleanapp.Requests.AssociationRequests;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GetTokenResult;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AssociationsActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context context = this;
        Log.e("ONCREATE1", "onCreate: ça plnte au début" );
        setContentView(R.layout.activity_associations);
        List<Association> assocs = new ArrayList<>();
        ArrayAdapter<Association> adapter = new AssociationAdapter(this,0, new ArrayList<Association>());
        FirebaseAuth.getInstance().getAccessToken(true).addOnCompleteListener(new OnCompleteListener<GetTokenResult>() {
            @Override
            public void onComplete(@NonNull Task<GetTokenResult> task) {
                if(!task.isSuccessful()) return;

                RequestQueue q = Volley.newRequestQueue(context);
                q.add(new AssociationRequests(context).GetAllAssociation(task.getResult().getToken()));
            }
        });

    }

}
