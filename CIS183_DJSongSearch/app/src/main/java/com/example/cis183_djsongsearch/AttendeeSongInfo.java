package com.example.cis183_djsongsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AttendeeSongInfo extends AppCompatActivity
{
    Button btn_j_as_select;
    Button btn_j_as_back;
    Intent requestSongIntent;
    Intent songSearchIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendee_song_info);

        btn_j_as_select = findViewById(R.id.btn_v_as_select);
        btn_j_as_back = findViewById(R.id.btn_v_as_back);

        requestSongIntent = new Intent(AttendeeSongInfo.this, RequestSong.class);
        songSearchIntent = new Intent(AttendeeSongInfo.this, RequestSong.class);

        SelectButtonEventHandler();
        BackButtonEventHandler();
    }

    private void SelectButtonEventHandler()
    {
        btn_j_as_select.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(requestSongIntent);
            }
        });
    }

    private void BackButtonEventHandler()
    {
        btn_j_as_back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(songSearchIntent);
            }
        });
    }
}