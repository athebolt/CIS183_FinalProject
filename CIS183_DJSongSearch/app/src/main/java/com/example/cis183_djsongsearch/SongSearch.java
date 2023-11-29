package com.example.cis183_djsongsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class SongSearch extends AppCompatActivity
{
    Button btn_j_ss_back;
    ListView lv_j_ss_songs;
    Intent attendeeSongInfoIntent;
    Intent requestSongIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_search);

        btn_j_ss_back = findViewById(R.id.btn_v_ss_back);
        lv_j_ss_songs = findViewById(R.id.lv_v_ss_songs);

        attendeeSongInfoIntent = new Intent(SongSearch.this, AttendeeSongInfo.class);
        requestSongIntent = new Intent(SongSearch.this, RequestSong.class);

        BackButtonEventHandler();
        SongsClickEventHandler();
        SongsLongClickEventHandler();
    }

    private void BackButtonEventHandler()
    {
        btn_j_ss_back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(requestSongIntent);
            }
        });
    }

    private void SongsClickEventHandler()
    {
        lv_j_ss_songs.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                startActivity(attendeeSongInfoIntent);
            }
        });
    }

    private void SongsLongClickEventHandler()
    {
        lv_j_ss_songs.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)
            {
                startActivity(requestSongIntent);

                return false;
            }
        });
    }
}