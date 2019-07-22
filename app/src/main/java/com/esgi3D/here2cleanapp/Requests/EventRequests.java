package com.esgi3D.here2cleanapp.Requests;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.esgi3D.here2cleanapp.Constants;
import com.esgi3D.here2cleanapp.Event;
import com.esgi3D.here2cleanapp.EventAdapter;
import com.esgi3D.here2cleanapp.R;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EventRequests {
    private Context context;

    public EventRequests(Context context) {
        this.context = context;
    }

    public JsonArrayRequest GetAllEvents(final String token) {
        JsonArrayRequest output = new JsonArrayRequest(Request.Method.GET, Constants.API_GET_ALL_EVENT, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.e("JSONObject", response.toString());
                Event[] events = new Gson().fromJson(response.toString(), Event[].class);
                EventAdapter eventAdapter = new EventAdapter(context, 0, Arrays.asList(events));
                ((ListActivity) context).setListAdapter(eventAdapter);
            }
        }, GetDefaultErrorListner()) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                final Map<String, String> header = new HashMap<>();
                header.put("Authorization", "Bearer " + token);
                Log.e("Authorization", "getHeaders: " + header.get("Authorization"));
                return header;
            }
        };


        return output;
    }

    public StringRequest AddVolunteerToAnEvent(final String token, final long volunteer, final long event) {
       StringRequest request =  new StringRequest(Request.Method.POST, Constants.API_ADD_VOLUNTEER_EVENT, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("", response.toString());
                Toast.makeText(context, "Inscription confirmée", Toast.LENGTH_SHORT).show();
            }
        }, GetDefaultErrorListner()) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                final Map<String, String> header = new HashMap<>();
                header.put("Authorization", "Bearer " + token);
                return header;

            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("volunteer_id","1");
                params.put("event_id", String.valueOf(event));
                return params;
            }


        };

        try {
            Log.e("REQUEST_X", "AddVolunteerToAnEvent: "+ new String(request.getBody())  );
        } catch (AuthFailureError authFailureError) {
            authFailureError.printStackTrace();
        }

        return request;
    }

    public StringRequest RemoveVolunteerToAnEvent(final String token, final int volunteer, final int event) {
        StringRequest request =  new StringRequest(Request.Method.POST, Constants.API_REMOVE_VOLUNTEER_EVENT, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("", response.toString());
                Toast.makeText(context, "Inscription confirmée", Toast.LENGTH_SHORT).show();
            }
        }, GetDefaultErrorListner()) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                final Map<String, String> header = new HashMap<>();
                header.put("Authorization", "Bearer " + token);
                return header;

            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("volunteer_id","1");
                params.put("event_id", String.valueOf(event));
                return params;
            }


        };

        try {
            Log.e("REQUEST_X", "AddVolunteerToAnEvent: "+ new String(request.getBody())  );
        } catch (AuthFailureError authFailureError) {
            authFailureError.printStackTrace();
        }

        return request;
    }


    private Response.ErrorListener GetDefaultErrorListner() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error", "onErrorResponse: ");

                error.printStackTrace();
                Toast.makeText(context, "Quelque chose ne s'est pas passé comme prévu", Toast.LENGTH_SHORT).show();
            }
        };
    }


}
