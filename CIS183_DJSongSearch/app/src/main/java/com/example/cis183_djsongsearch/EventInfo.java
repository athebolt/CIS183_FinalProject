package com.example.cis183_djsongsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class EventInfo extends AppCompatActivity
{
    TextView tv_j_ei_code;
    EditText et_j_ei_date;
    EditText et_j_ei_time;
    EditText et_j_ei_location;
    CheckBox cb_j_ei_private;
    Button btn_j_ei_update;
    Button btn_j_ei_delete;
    Intent eventLibraryIntent;
    Dj dj;
    Event event;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_info);

        tv_j_ei_code = findViewById(R.id.tv_v_ei_code);
        et_j_ei_date = findViewById(R.id.et_v_ei_date);
        et_j_ei_time = findViewById(R.id.et_v_ei_time);
        et_j_ei_location = findViewById(R.id.et_v_ei_location);
        cb_j_ei_private = findViewById(R.id.cb_v_ei_private);
        btn_j_ei_update = findViewById(R.id.btn_v_ei_update);
        btn_j_ei_delete = findViewById(R.id.btn_v_ei_delete);

        eventLibraryIntent = new Intent(EventInfo.this, EventLibrary.class);

        dbHelper = new DatabaseHelper(this);

        Intent cameFrom = getIntent();

        dj = (Dj) cameFrom.getSerializableExtra("DJ");

        event = (Event) cameFrom.getSerializableExtra("Event");

        tv_j_ei_code.setText(event.getEventCode());
        et_j_ei_date.setText(event.getDate());
        et_j_ei_time.setText(event.getTime());
        et_j_ei_location.setText(event.getLocation());

        if(event.getPrivate().equals("true"))
        {
            cb_j_ei_private.setChecked(true);
        }

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
                String priv = "false";

                if(cb_j_ei_private.isChecked())
                {
                    priv = "true";
                }

                Event updatedEvent = new Event(event.getEventCode(), dj.getDjId(), et_j_ei_date.getText().toString(), et_j_ei_time.getText().toString(), et_j_ei_location.getText().toString(), priv,null);

                dbHelper.updateEvent(updatedEvent);

                eventLibraryIntent.putExtra("DJ", dj);

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
                dbHelper.deleteEvent(event.getEventCode());

                eventLibraryIntent.putExtra("DJ", dj);

                startActivity(eventLibraryIntent);
            }
        });
    }
}