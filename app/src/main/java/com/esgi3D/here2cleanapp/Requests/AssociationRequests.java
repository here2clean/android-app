package com.esgi3D.here2cleanapp.Requests;

import android.app.ListActivity;
import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.esgi3D.here2cleanapp.Association;
import com.esgi3D.here2cleanapp.AssociationAdapter;
import com.esgi3D.here2cleanapp.Constants;
import com.google.gson.Gson;

import org.json.JSONArray;

import java.util.Arrays;

public class AssociationRequests {
    private Context context;

    public AssociationRequests(Context context) {
        this.context = context;
    }

    public JsonArrayRequest GetAllAssociation() {
        return new JsonArrayRequest(Request.Method.GET, Constants.API_GET_ALL_ASSOC, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.e("JSONObject", response.toString());
                Association[] associations = new Gson().fromJson(response.toString(), Association[].class);
                AssociationAdapter associationAdapter = new AssociationAdapter(context, 0, Arrays.asList(associations));
                ((ListActivity) context).setListAdapter(associationAdapter);
            }
        }, GetDefaultErrorListner());
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
