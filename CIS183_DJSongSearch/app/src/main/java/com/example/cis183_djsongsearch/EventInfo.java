package com.example.cis183_djsongsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class EventInfo extends AppCompatActivity
{
    TextView tv_j_ei_code;
    TextView tv_j_ei_privateY;
    TextView tv_j_ei_privateN;
    EditText et_j_ei_date;
    EditText et_j_ei_time;
    EditText et_j_ei_location;
    ImageButton btn_j_ei_privateY;
    ImageButton btn_j_ei_privateN;
    ImageButton btn_j_ei_update;
    ImageButton btn_j_ei_delete;
    Intent eventLibraryIntent;
    DatabaseHelper dbHelper;
    Boolean isPrivate;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_info);

        tv_j_ei_code = findViewById(R.id.tv_v_ei_code);
        tv_j_ei_privateY = findViewById(R.id.tv_v_ei_privateY);
        tv_j_ei_privateN = findViewById(R.id.tv_v_ei_priavteN);
        et_j_ei_date = findViewById(R.id.et_v_ei_date);
        et_j_ei_time = findViewById(R.id.et_v_ei_time);
        btn_j_ei_privateY = findViewById(R.id.btn_v_ei_privateY);
        btn_j_ei_privateN = findViewById(R.id.btn_v_ei_privateN);
        et_j_ei_location = findViewById(R.id.et_v_ei_location);
        btn_j_ei_update = findViewById(R.id.btn_v_ei_update);
        btn_j_ei_delete = findViewById(R.id.btn_v_ei_delete);

        eventLibraryIntent = new Intent(EventInfo.this, EventLibrary.class);

        dbHelper = new DatabaseHelper(this);

        isPrivate = null;

        tv_j_ei_code.setText(AppData.getCurEvent().getEventCode());
        et_j_ei_date.setText(AppData.getCurEvent().getDate());
        et_j_ei_time.setText(AppData.getCurEvent().getTime());
        et_j_ei_location.setText(AppData.getCurEvent().getLocation());

        if(AppData.getCurEvent().getPrivate().equals("true"))
        {
            tv_j_ei_privateY.setVisibility(View.VISIBLE);
        }
        else
        {
            tv_j_ei_privateN.setVisibility(View.VISIBLE);
        }

        PrivateYButtonEventHandler();
        PrivateNButtonEventHandler();
        UpdateButtonEventHandler();
        DeleteButtonEventHandler();
    }

    private void PrivateYButtonEventHandler()
    {
        btn_j_ei_privateY.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                isPrivate = true;

                tv_j_ei_privateY.setVisibility(View.VISIBLE);
                tv_j_ei_privateN.setVisibility(View.INVISIBLE);

            }
        });
    }

    private void PrivateNButtonEventHandler()
    {
        btn_j_ei_privateN.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                isPrivate = false;

                tv_j_ei_privateY.setVisibility(View.INVISIBLE);
                tv_j_ei_privateN.setVisibility(View.VISIBLE);
            }
        });
    }

    private void UpdateButtonEventHandler()
    {
        btn_j_ei_update.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Event updatedEvent = new Event(AppData.getCurEvent().getEventCode(), AppData.getUser().getDjId(), et_j_ei_date.getText().toString(), et_j_ei_time.getText().toString(), et_j_ei_location.getText().toString(), isPrivate.toString(), null);

                dbHelper.updateEvent(updatedEvent);

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
                dbHelper.deleteEvent(AppData.getCurEvent().getEventCode());

                startActivity(eventLibraryIntent);
            }
        });
    }
}