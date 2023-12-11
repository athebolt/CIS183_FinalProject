package com.example.cis183_djsongsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class EventManualSearch extends AppCompatActivity
{
    TextView tv_j_ems_error;
    EditText et_j_ems_code;
    ImageButton btn_j_ems_enter;
    ImageButton btn_j_ems_home;
    ImageButton btn_j_ems_back;
    Intent eventConfirmIntent;
    Intent eventSearchIntent;
    Intent mainActivityIntent;
    DatabaseHelper dbHelper;
    ArrayList<Event> listOfEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_manual_search);

        tv_j_ems_error = findViewById(R.id.tv_v_ems_error);
        et_j_ems_code = findViewById(R.id.et_v_ems_code);
        btn_j_ems_enter = findViewById(R.id.btn_v_ems_enter);
        btn_j_ems_home = findViewById(R.id.btn_v_ems_home);
        btn_j_ems_back = findViewById(R.id.btn_v_ems_back);

        eventConfirmIntent = new Intent(EventManualSearch.this, EventConfirm.class);
        eventSearchIntent = new Intent(EventManualSearch.this, EventSearch.class);
        mainActivityIntent = new Intent(EventManualSearch.this, MainActivity.class);

        dbHelper = new DatabaseHelper(this);

        listOfEvents = dbHelper.getAllEvents();

        EnterButtonEventHandler();
        HomeButtonEventHandler();
        BackButtonEventHandler();
    }

    private void EnterButtonEventHandler()
    {
        btn_j_ems_enter.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                for(int i = 0; i < listOfEvents.size(); i++)
                {
                    if(et_j_ems_code.getText().toString().equals(listOfEvents.get(i).getEventCode()))
                    {
                        AppData.setCurEvent(listOfEvents.get(i));

                        startActivity(eventConfirmIntent);
                    }
                }

                et_j_ems_code.setText("");
                tv_j_ems_error.setVisibility(View.VISIBLE);
            }
        });
    }

    private void HomeButtonEventHandler()
    {
        btn_j_ems_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(mainActivityIntent);
            }
        });
    }

    private void BackButtonEventHandler()
    {
        btn_j_ems_back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(eventSearchIntent);
            }
        });
    }
}