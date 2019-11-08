package com.example.auth_test_2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;


public class CustomAdapter extends ArrayAdapter<Event> {
    private final Activity context;
    private final List<Event> listEvent;
    public CustomAdapter(Activity context, List<Event> eventList) {
        super(context, R.layout.list_item, eventList);
        this.context = context;
        this.listEvent = eventList;
    }

    static class ViewHolder{
        public TextView id;
        public TextView device_mac;
        public TextView event;
        public TextView meta;

        ViewHolder(View view){
            this.id = view.findViewById(R.id.id);
            this.device_mac = view.findViewById(R.id.device_mac);
            this.event = view.findViewById(R.id.event);
            this.meta = view.findViewById(R.id.meta);
        }

        void setData (Event event){
            this.id.setText(event.getId());
            this.device_mac.setText(event.getDevice_mac());
            this.event.setText(event.getEvent());
            this.meta.setText(event.getMeta());
        }
    }

    public View getView(int position, View convertView, ViewGroup parent){
        CustomAdapter.ViewHolder holder;
        View rowView;
        LayoutInflater inflater = context.getLayoutInflater();
        rowView = inflater.inflate(R.layout.list_item, null, true);
        holder = new CustomAdapter.ViewHolder(rowView);
        holder.setData(listEvent.get(position));
        return rowView;
    }
}
