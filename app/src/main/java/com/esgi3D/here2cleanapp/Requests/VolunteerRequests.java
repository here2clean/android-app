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
import com.android.volley.toolbox.StringRequest;
import com.esgi3D.here2cleanapp.Constants;
import com.esgi3D.here2cleanapp.LoginActivity;
import com.esgi3D.here2cleanapp.MenuActivity;
import com.esgi3D.here2cleanapp.R;
import com.esgi3D.here2cleanapp.Volunteer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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

    public JsonObjectRequest GetVolunteerByMail(final String token, String mail) {
        JSONObject postparams = new JSONObject();
        try {
            postparams.put("mail", mail);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new JsonObjectRequest(Request.Method.POST, Constants.API_GET_VOLUNTEER_BY_MAIL, postparams, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Volunteer volunteer = new Gson().fromJson(response.toString(), Volunteer.class);
                final Intent goToMain = new Intent(context, MenuActivity.class);
                goToMain.putExtra("VOLUNTEER", goToMain);
                context.startActivity(goToMain);
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

    public StringRequest SignUp(final String mail, final String pwd, final String name, final String surname) {
        StringRequest output = new StringRequest(Request.Method.POST, Constants.API_VOLUNTEER_SIGNUP, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(context, "Inscription réussie", Toast.LENGTH_SHORT).show();
                Intent login = new Intent(context, LoginActivity.class);
                context.startActivity(login);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Inscription impossible", Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }


        }){
            @Override
            public byte[] getBody() throws AuthFailureError {
                Volunteer v = new Volunteer(mail,pwd,surname,name);
                Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").serializeNulls().serializeNulls().create();
                String output = gson.toJson(v);
                Log.e("Body", "getBody: "+ output );
                return output.getBytes();
            }

            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }
        };
        return output;
    }

}
