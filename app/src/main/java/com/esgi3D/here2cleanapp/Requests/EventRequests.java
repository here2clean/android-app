package com.esgi3D.here2cleanapp.Requests;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.esgi3D.here2cleanapp.Constants;
import com.esgi3D.here2cleanapp.Event;
import com.esgi3D.here2cleanapp.EventAdapter;
import com.google.gson.Gson;

import org.json.JSONArray;

import java.util.Arrays;

public class EventRequests {
    private Context context;

    public EventRequests(Context context) {
        this.context = context;
    }

    public JsonArrayRequest GetAllEvents() {
        return new JsonArrayRequest(Request.Method.GET, Constants.API_GET_ALL_EVENT, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.e("JSONObject", response.toString());
                Event[] events = new Gson().fromJson(response.toString(), Event[].class);
                EventAdapter eventAdapter = new EventAdapter(context, 0, Arrays.asList(events));
                ((ListActivity) context).setListAdapter(eventAdapter);
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
