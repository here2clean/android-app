package com.esgi3D.here2cleanapp;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class GetAllAssociationHttpRequest extends AsyncTask<String, Void, Association[]> {
    private static final String HTTP_CALL_TAG = "GetAllAssocs" ;
    private List<Association> assocs;
    private Context context;

    public GetAllAssociationHttpRequest(List<Association> assocs, Context context) {
        this.assocs = assocs;
        this.context = context;
    }

    @Override
    protected Association[] doInBackground(String... strings) {
        String stringUrl = strings[0];

        try {
            //creation de la connexion
            URL url = new URL(Constants.API_GET_ALL_ASSOC);
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setConnectTimeout(1000);
            urlConnection.setReadTimeout(1000);
            urlConnection.setRequestMethod("GET");
            //call
            urlConnection.connect();
            Log.i(HTTP_CALL_TAG, String.format("status = %d", urlConnection.getResponseCode()));

            //read
            InputStream is = urlConnection.getInputStream();
            Association[] assocs = new Gson().fromJson(new InputStreamReader(is), Association[].class);

            for (Association assoc : assocs) {
                Log.e("AssocTag",assoc.toString());
            }
            //close
            is.close();
            urlConnection.disconnect();
            return assocs;//sb.toString();
        } catch (MalformedURLException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Association[] associations) {
        this.assocs = Arrays.asList(associations);
    }
}


