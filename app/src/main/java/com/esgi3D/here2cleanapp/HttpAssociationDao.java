package com.esgi3D.here2cleanapp;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class HttpAssociationDao implements AssociationDao {

    @Override
    public List<Association> getAssociations() {
        List<Association> output = new ArrayList<Association>();
        /*GetAllAssociationHttpRequest request = new GetAllAssociationHttpRequest(output,);
        request.execute(Constants.API_GET_ALL_ASSOC);
        Log.e("assocSize", "Size : "+output.size());
        for (Association o : output) {
            Log.e("assocstag",o.toString());
        }*/
        return output;
    }

    @Override
    public Association getAssociationByMail(String mail) {
        return null;
    }

    @Override
    public Association getAssociationByName(String name) {
        return null;
    }
}
