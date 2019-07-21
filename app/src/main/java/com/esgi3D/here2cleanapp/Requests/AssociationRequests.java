package com.esgi3D.here2cleanapp.Requests;

import android.app.ListActivity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.esgi3D.here2cleanapp.Association;
import com.esgi3D.here2cleanapp.AssociationAdapter;
import com.esgi3D.here2cleanapp.Constants;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.gson.Gson;

import org.json.JSONArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AssociationRequests {
    private Context context;

    public AssociationRequests(Context context) {
        this.context = context;
    }

    public JsonArrayRequest GetAllAssociation(final String token) {
        Log.e("GETALL", "GetAllAssociation: _a plante ici" );
        JsonArrayRequest output = new JsonArrayRequest(Request.Method.GET, Constants.API_GET_ALL_ASSOC, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.e("JSONObject", response.toString());
                Association[] associations = new Gson().fromJson(response.toString(), Association[].class);
                AssociationAdapter associationAdapter = new AssociationAdapter(context, 0, Arrays.asList(associations));
                ((ListActivity) context).setListAdapter(associationAdapter);



            }
        }, GetDefaultErrorListner())

        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                final Map<String, String> header = new HashMap<>();
                header.put("Authorization", "Bearer "+token);



                Log.e("Authorization", "getHeaders: "+ header.get("Authorization"));
                return header;
            }

        };

        return  output;
    }

    private Response.ErrorListener GetDefaultErrorListner() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error volley", error.toString());
            }
        };
    }
}
