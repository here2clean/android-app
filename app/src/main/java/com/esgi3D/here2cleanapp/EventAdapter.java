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

public class EventAdapter extends ArrayAdapter<Event> {


    public EventAdapter(Context context, int resource, List<Event> objects) {
        super(context, resource, objects);
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Context context = getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View row = layoutInflater.inflate(R.layout.row_event, null);

        final TextView tvEventName = row.findViewById(R.id.tv_event_name);
        final ImageView ivEventImage = row.findViewById(R.id.iv_event_image);

        Log.e("Urlimage", "getView: "+ getItem(position).getUrlImage() );

        Picasso.get().load(getItem(position).getUrlImage()).into(ivEventImage);
        tvEventName.setText(String.format(getItem(position).getName()));

        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToEvent = new Intent(getContext() ,EventActivity.class);
                Log.e("Assoc", "onClick: "+getItem(position).toString());
                goToEvent.putExtra("event",getItem(position));
                context.startActivity(goToEvent);
            }
        });
        Event event = getItem(position);

        return  row;
    }
}
