package com.example.cis183_djsongsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreateEvent extends AppCompatActivity
{
    Button btn_j_ce_create;
    Button btn_j_ce_back;
    Intent eventLibraryIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        btn_j_ce_create = findViewById(R.id.btn_v_ce_create);
        btn_j_ce_back = findViewById(R.id.btn_v_ce_back);

        eventLibraryIntent = new Intent(CreateEvent.this, EventLibrary.class);

        CreateButtonEventHandler();
        BackButtonEventHandler();
    }

    private void CreateButtonEventHandler()
    {
        btn_j_ce_create.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(eventLibraryIntent);
            }
        });
    }

    private void BackButtonEventHandler()
    {
        btn_j_ce_back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(eventLibraryIntent);
            }
        });
    }
}