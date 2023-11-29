package com.example.cis183_djsongsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SongInfo extends AppCompatActivity
{
    Button btn_j_si_select;
    Button btn_j_si_back;
    Intent requestSongIntent;
    Intent songSearchIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_info);

        btn_j_si_select = findViewById(R.id.btn_v_si_select);
        btn_j_si_back = findViewById(R.id.btn_v_si_back);

        requestSongIntent = new Intent(SongInfo.this, RequestSong.class);
        songSearchIntent = new Intent(SongInfo.this, SongSearch.class);

        SelectButtonEventHandler();
        BackButtonEventHandler();
    }

    private void SelectButtonEventHandler()
    {
        btn_j_si_select.setOnClickListener(new View.OnClickListener()
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
        btn_j_si_back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(songSearchIntent);
            }
        });
    }
}