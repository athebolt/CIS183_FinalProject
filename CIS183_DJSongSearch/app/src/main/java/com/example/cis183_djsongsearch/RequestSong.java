package com.example.cis183_djsongsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class RequestSong extends AppCompatActivity
{
    ImageButton btn_j_rs_request;
    ImageButton btn_j_rs_home;
    ImageButton btn_j_rs_back;
    ListView lv_j_rs_songs;
    Intent eventSearchIntent;
    Intent mainActivityIntent;
    Intent songSearchIntent;
    SongLibraryListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_song);

        btn_j_rs_request = findViewById(R.id.btn_v_rs_request);
        btn_j_rs_home = findViewById(R.id.btn_v_rs_home);
        btn_j_rs_back = findViewById(R.id.btn_v_rs_back);
        lv_j_rs_songs = findViewById(R.id.lv_v_rs_songs);

        eventSearchIntent = new Intent(RequestSong.this, EventSearch.class);
        mainActivityIntent = new Intent(RequestSong.this, MainActivity.class);
        songSearchIntent = new Intent(RequestSong.this, SongSearch.class);

        adapter = new SongLibraryListAdapter(this, AppData.getReqSongs());

        lv_j_rs_songs.setAdapter(adapter);




        RequestButtonEventHandler();
        HomeButtonEventHandler();
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

    private void HomeButtonEventHandler()
    {
        btn_j_rs_home.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(mainActivityIntent);
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