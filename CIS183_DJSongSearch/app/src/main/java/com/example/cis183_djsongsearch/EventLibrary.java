package com.example.cis183_djsongsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class EventLibrary extends AppCompatActivity
{
    ImageButton btn_j_el_create;
    ImageButton btn_j_el_home;
    ImageButton btn_j_el_back;
    ListView lv_j_el_active;
    ListView lv_j_el_upcoming;
    Intent createEventIntent;
    Intent djHomeIntent;
    Intent eventInfoIntent;
    Intent activeEventIntent;
    DatabaseHelper dbHelper;
    ArrayList<Event> listOfEvents;
    ArrayList<Event> activeEvents;
    ArrayList<Event> upcomingEvents;
    EventLibraryListAdapter activeAdapter;
    EventLibraryListAdapter upcomingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_library);

        btn_j_el_create = findViewById(R.id.btn_v_el_create);
        btn_j_el_home = findViewById(R.id.btn_v_el_home);
        btn_j_el_back = findViewById(R.id.btn_v_el_back);
        lv_j_el_active = findViewById(R.id.lv_v_el_active);
        lv_j_el_upcoming = findViewById(R.id.lv_v_el_upcoming);

        createEventIntent = new Intent(EventLibrary.this, CreateEvent.class);
        djHomeIntent = new Intent(EventLibrary.this, DjHome.class);
        eventInfoIntent = new Intent(EventLibrary.this, EventInfo.class);
        activeEventIntent = new Intent(EventLibrary.this, ActiveEvent.class);

        dbHelper = new DatabaseHelper(this);

        listOfEvents = dbHelper.getEventsOfDj(AppData.getUser().getDjId());

        for(int i = 0; i < listOfEvents.size(); i++)
        {
            if(listOfEvents.get(i).getActive().equals("true"))
            {
                activeEvents.add(listOfEvents.get(i));
            }
            else
            {
                upcomingEvents.add(listOfEvents.get(i));
            }
        }

        activeAdapter = new EventLibraryListAdapter(this, activeEvents);
        upcomingAdapter = new EventLibraryListAdapter(this, upcomingEvents);

        lv_j_el_active.setAdapter(activeAdapter);
        lv_j_el_upcoming.setAdapter(upcomingAdapter);

        CreateButtonEventHandler();
        BackButtonEventHandler();
        ActiveClickEventHandler();
        ActiveLongClickEventHandler();
        UpcomingClickEventHandler();
        UpcomingLongClickEventHandler();
    }
    private void CreateButtonEventHandler()
    {
        btn_j_el_create.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(createEventIntent);
            }
        });
    }

    private void BackButtonEventHandler()
    {
        btn_j_el_back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(djHomeIntent);
            }
        });
    }

    private void ActiveClickEventHandler()
    {
        lv_j_el_active.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id)
            {
                AppData.setCurEvent(activeEvents.get(i));

                startActivity(activeEventIntent);
            }
        });
    }

    private void ActiveLongClickEventHandler()
    {
        lv_j_el_active.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long id)
            {
                AppData.setCurEvent(activeEvents.get(i));


                startActivity(eventInfoIntent);

                return false;
            }
        });
    }

    private void UpcomingClickEventHandler()
    {
        lv_j_el_upcoming.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id)
            {
                AppData.setCurEvent(upcomingEvents.get(i));

                startActivity(eventInfoIntent);
            }
        });
    }

    private void UpcomingLongClickEventHandler()
    {
        lv_j_el_upcoming.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long id)
            {
                dbHelper.activateEvent(upcomingEvents.get(i).getEventCode());

                AppData.setCurEvent(upcomingEvents.get(i));

                startActivity(activeEventIntent);

                return false;
            }
        });
    }
}