package com.esgi3D.here2cleanapp.Requests;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.esgi3D.here2cleanapp.Constants;
import com.esgi3D.here2cleanapp.LoginActivity;
import com.esgi3D.here2cleanapp.MenuActivity;
import com.esgi3D.here2cleanapp.R;
import com.esgi3D.here2cleanapp.Volunteer;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class VolunteerRequests {

    private Context context;

    public VolunteerRequests(Context context) {
        this.context = context;
    }

    public JsonObjectRequest GetVolunteerByMail(final String token, String mail){
        JSONObject postparams = new JSONObject();
        try {
            postparams.put("mail", mail);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new JsonObjectRequest(Request.Method.POST, Constants.API_GET_VOLUNTEER_BY_MAIL, postparams, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Volunteer volunteer= new Gson().fromJson(response.toString(),Volunteer.class);
                final Intent goToMain = new Intent(context, MenuActivity.class);
                goToMain.putExtra("VOLUNTEER",goToMain);
                context.startActivity(goToMain);
            }
        }, GetDefaultErrorListner()){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                final Map<String, String> header = new HashMap<>();
                header.put("Authorization", "Bearer "+token);
                Log.e("Authorization", "getHeaders: "+ header.get("Authorization"));
                return header;            }
        };
    }


    private Response.ErrorListener GetDefaultErrorListner() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error volley", error.toString());
                Toast.makeText(context, "Quelque chose ne s'est pas passé comme prévu", Toast.LENGTH_SHORT).show();
            }
        };
    }
}
