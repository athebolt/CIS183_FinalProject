package com.example.cis183_djsongsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AttendeeInfo extends AppCompatActivity
{
    Button btn_j_ai_update;
    Button btn_j_ai_delete;
    Intent mainActivityIntent;
    Intent eventSearchIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendee_info);

        btn_j_ai_update = findViewById(R.id.btn_v_ai_update);
        btn_j_ai_delete = findViewById(R.id.btn_v_ai_delete);

        mainActivityIntent = new Intent(AttendeeInfo.this, MainActivity.class);
        eventSearchIntent = new Intent(AttendeeInfo.this, EventSearch.class);

        UpdateButtonEventHandler();
        DeleteButtonEventHandler();
    }

    private void UpdateButtonEventHandler()
    {
        btn_j_ai_update.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(eventSearchIntent);
            }
        });
    }

    private void DeleteButtonEventHandler()
    {
        btn_j_ai_delete.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(mainActivityIntent);
            }
        });
    }
}