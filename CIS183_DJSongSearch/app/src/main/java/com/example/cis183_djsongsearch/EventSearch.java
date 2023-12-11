package com.example.cis183_djsongsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class EventSearch extends AppCompatActivity
{
    TextView tv_j_es_error;
    ImageButton btn_j_es_manual;
    ImageButton btn_j_es_home;
    ImageButton btn_j_es_attendeeInfo;
    ListView lv_j_es_events;
    Intent eventConfirmIntent;
    Intent eventManualSearchIntent;
    Intent attendeeInfoIntent;
    Intent mainActivityIntent;
    DatabaseHelper dbHelper;
    ArrayList<Event> listOfEvents;
    EventLibraryListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_search);

        tv_j_es_error = findViewById(R.id.tv_v_es_error);
        btn_j_es_manual = findViewById(R.id.btn_v_es_manual);
        btn_j_es_home = findViewById(R.id.btn_v_es_home);
        btn_j_es_attendeeInfo = findViewById(R.id.btn_v_es_attendeeInfo);
        lv_j_es_events = findViewById(R.id.lv_v_es_events);

        eventConfirmIntent = new Intent(EventSearch.this, EventConfirm.class);
        eventManualSearchIntent = new Intent(EventSearch.this, EventManualSearch.class);
        attendeeInfoIntent = new Intent(EventSearch.this, AttendeeInfo.class);
        mainActivityIntent = new Intent(EventSearch.this, MainActivity.class);

        dbHelper = new DatabaseHelper(this);

        listOfEvents = dbHelper.getAllNonPrivateEvents();

        adapter = new EventLibraryListAdapter(this, listOfEvents);

        lv_j_es_events.setAdapter(adapter);

        ManualButtonEventHandler();
        HomeButtonEventHandler();
        InfoButtonEventHandler();
        EventClickEventHandler();
    }

    private void ManualButtonEventHandler()
    {
        btn_j_es_manual.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(eventManualSearchIntent);
            }
        });
    }

    private void HomeButtonEventHandler()
    {
        btn_j_es_home.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(mainActivityIntent);
            }
        });
    }

    private void InfoButtonEventHandler()
    {
        btn_j_es_attendeeInfo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(attendeeInfoIntent);
            }
        });
    }

    private void EventClickEventHandler()
    {
        lv_j_es_events.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id)
            {
                if(listOfEvents.get(i).getActive().equals("true"))
                {
                    AppData.setCurEvent(listOfEvents.get(i));

                    startActivity(eventConfirmIntent);
                }
                else
                {
                    tv_j_es_error.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}