package com.example.cis183_djsongsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class EventSearch extends AppCompatActivity
{
    Button btn_j_es_manual;
    Button btn_j_es_signOut;
    Button btn_j_es_info;
    ListView lv_j_es_events;
    Intent eventConfirmIntent;
    Intent eventManualSearchIntent;
    Intent attendeeInfoIntent;
    Intent mainActivityIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_search);

        btn_j_es_manual = findViewById(R.id.btn_v_es_manual);
        btn_j_es_signOut = findViewById(R.id.btn_v_es_signOut);
        btn_j_es_info = findViewById(R.id.btn_v_es_info);
        lv_j_es_events = findViewById(R.id.lv_v_es_events);

        eventConfirmIntent = new Intent(EventSearch.this, EventConfirm.class);
        eventManualSearchIntent = new Intent(EventSearch.this, EventManualSearch.class);
        attendeeInfoIntent = new Intent(EventSearch.this, AttendeeInfo.class);
        mainActivityIntent = new Intent(EventSearch.this, MainActivity.class);

        ManualButtonEventHandler();
        SignOutButtonEventHandler();
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

    private void SignOutButtonEventHandler()
    {
        btn_j_es_signOut.setOnClickListener(new View.OnClickListener()
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
        btn_j_es_info.setOnClickListener(new View.OnClickListener()
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
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                startActivity(eventConfirmIntent);
            }
        });
    }
}