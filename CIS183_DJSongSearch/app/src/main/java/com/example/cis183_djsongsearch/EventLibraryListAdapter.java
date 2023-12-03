package com.example.cis183_djsongsearch;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EventLibraryListAdapter extends BaseAdapter
{
    Context context;
    ArrayList<Event> listOfEvents;

    public EventLibraryListAdapter(Context c, ArrayList<Event> ls)
    {
        context = c;
        listOfEvents = ls;
    }

    @Override
    public int getCount() {
        return listOfEvents.size();
    }

    @Override
    public Object getItem(int i) {
        return listOfEvents.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        if(view == null)
        {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = mInflater.inflate(R.layout.event_library_custom_cell, null);
        }

        TextView code = view.findViewById(R.id.tv_v_elcc_code);
        TextView date = view.findViewById(R.id.tv_v_elcc_date);
        TextView location = view.findViewById(R.id.tv_v_elcc_loc);

        Event event = listOfEvents.get(i);

        code.setText(event.getEventCode());
        date.setText(event.getDate());
        location.setText(event.getLocation());

        return view;
    }
}
