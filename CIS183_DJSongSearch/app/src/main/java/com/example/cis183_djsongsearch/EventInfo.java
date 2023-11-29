package com.example.cis183_djsongsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EventInfo extends AppCompatActivity
{
    Button btn_j_ei_update;
    Button btn_j_ei_delete;
    Intent eventLibraryIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_info);

        btn_j_ei_update = findViewById(R.id.btn_v_ei_update);
        btn_j_ei_delete = findViewById(R.id.btn_v_ei_delete);

        eventLibraryIntent = new Intent(EventInfo.this, EventLibrary.class);

        UpdateButtonEventHandler();
        DeleteButtonEventHandler();
    }

    private void UpdateButtonEventHandler()
    {
        btn_j_ei_update.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(eventLibraryIntent);
            }
        });
    }

    private void DeleteButtonEventHandler()
    {
        btn_j_ei_delete.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(eventLibraryIntent);
            }
        });
    }
}