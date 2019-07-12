package com.esgi3D.here2cleanapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class AssociationAdapter extends ArrayAdapter<Association> {
    public AssociationAdapter(Context context, int resource, List<Association> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Context context = getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View row = layoutInflater.inflate(R.layout.row_association, null);

        final TextView tvEventName = row.findViewById(R.id.tv_association_name);
        tvEventName.setText(String.format(getItem(position).getName()));

        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToAssocs = new Intent(getContext() ,AssociationActivity.class);
                goToAssocs.putExtra("association",getItem(position));
                context.startActivity(goToAssocs);
            }
        });
        Association association = getItem(position);
        return  row;
    }
}
