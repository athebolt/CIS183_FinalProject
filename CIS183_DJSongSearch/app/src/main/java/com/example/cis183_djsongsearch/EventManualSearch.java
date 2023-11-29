package com.example.cis183_djsongsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EventManualSearch extends AppCompatActivity
{
    EditText et_j_ems_codeEntry;
    Button btn_j_ems_enter;
    Button btn_j_ems_back;
    Intent eventConfirmIntent;
    Intent eventSearchIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_manual_search);

        et_j_ems_codeEntry = findViewById(R.id.et_v_ems_codeEntry);
        btn_j_ems_enter = findViewById(R.id.btn_v_ems_enter);
        btn_j_ems_back = findViewById(R.id.btn_v_ems_back);

        eventConfirmIntent = new Intent(EventManualSearch.this, EventConfirm.class);
        eventSearchIntent = new Intent(EventManualSearch.this, EventSearch.class);

        EnterButtonEventHandler();
        BackButtonEventHandler();
    }

    private void EnterButtonEventHandler()
    {
        btn_j_ems_enter.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(eventConfirmIntent);
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