package com.esgi3D.here2cleanapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

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
        final ImageView ivAssocImage = row.findViewById(R.id.iv_assoc_image);
        tvEventName.setText(String.format(getItem(position).getName()));
        Picasso.get().load(getItem(position).getUrlImage()).centerCrop().into(ivAssocImage);

        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToAssocs = new Intent(getContext() ,AssociationActivity.class);
                Log.e("AssocAvantPut", "onClick: "+getItem(position).toString());

                goToAssocs.putExtra(String.valueOf(R.string.ASSOCIATION),getItem(position));
                context.startActivity(goToAssocs);
            }
        });
        return  row;
    }
}
