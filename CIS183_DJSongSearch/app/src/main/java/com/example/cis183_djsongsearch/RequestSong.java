package com.example.cis183_djsongsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class RequestSong extends AppCompatActivity
{
    Button btn_j_rs_request;
    Button btn_j_rs_back;
    ListView lv_j_rs_songs;
    Intent eventSearchIntent;
    Intent songSearchIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_song);

        btn_j_rs_request = findViewById(R.id.btn_v_rs_request);
        btn_j_rs_back = findViewById(R.id.btn_v_rs_back);
        lv_j_rs_songs = findViewById(R.id.lv_v_rs_songs);

        eventSearchIntent = new Intent(RequestSong.this, EventSearch.class);
        songSearchIntent = new Intent(RequestSong.this, SongSearch.class);

        RequestButtonEventHandler();
        BackButtonEventHandler();
    }

    private void RequestButtonEventHandler()
    {
        btn_j_rs_request.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(songSearchIntent);
            }
        });
    }

    private void BackButtonEventHandler()
    {
        btn_j_rs_back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(eventSearchIntent);
            }
        });
    }
}