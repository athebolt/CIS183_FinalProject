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

public class SongSearch extends AppCompatActivity
{
    ImageButton btn_j_ss_queue;
    ImageButton btn_j_ss_home;
    ListView lv_j_ss_songs;
    Intent attendeeSongInfoIntent;
    Intent requestSongIntent;
    Intent mainActivityIntent;
    DatabaseHelper dbHelper;
    ArrayList<Song> listOfSongs;
    SongLibraryListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_search);

        btn_j_ss_queue = findViewById(R.id.btn_v_ss_queue);
        btn_j_ss_home = findViewById(R.id.btn_v_ss_home);
        lv_j_ss_songs = findViewById(R.id.lv_v_ss_songs);

        attendeeSongInfoIntent = new Intent(SongSearch.this, AttendeeSongInfo.class);
        requestSongIntent = new Intent(SongSearch.this, RequestSong.class);
        mainActivityIntent = new Intent(SongSearch.this, MainActivity.class);

        dbHelper = new DatabaseHelper(this);

        listOfSongs = dbHelper.getSongsOfDj(AppData.getCurEvent().getDjId());

        adapter = new SongLibraryListAdapter(this, listOfSongs);

        lv_j_ss_songs.setAdapter(adapter);

        QueueButtonEventHandler();
        SongsClickEventHandler();
        SongsLongClickEventHandler();
    }

    private void HomeButtonEventHandler()
    {
        btn_j_ss_home.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(mainActivityIntent);
            }
        });
    }

    private void QueueButtonEventHandler()
    {
        btn_j_ss_queue.setOnClickListener(new View.OnClickListener()
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
            public void onItemClick(AdapterView<?> parent, View view, int i, long id)
            {
                AppData.setCurSong(listOfSongs.get(i));

                startActivity(attendeeSongInfoIntent);
            }
        });
    }

    private void SongsLongClickEventHandler()
    {
        lv_j_ss_songs.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long id)
            {
                AppData.addReqSong(listOfSongs.get(i));

                startActivity(requestSongIntent);

                return false;
            }
        });
    }
}