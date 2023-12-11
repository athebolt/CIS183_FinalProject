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

public class SongLibrary extends AppCompatActivity
{
    ImageButton btn_j_sl_add;
    ImageButton btn_j_sl_home;
    ImageButton btn_j_sl_back;
    ListView lv_j_sl_songs;
    Intent songInfoIntent;
    Intent createSongIntent;
    Intent mainActivityIntent;
    Intent djHomeIntent;
    DatabaseHelper dbHelper;
    ArrayList<Song> songs;
    SongLibraryListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_library);

        btn_j_sl_add = findViewById(R.id.btn_v_sl_add);
        btn_j_sl_home = findViewById(R.id.btn_v_sl_home);
        btn_j_sl_back = findViewById(R.id.btn_v_sl_back);
        lv_j_sl_songs = findViewById(R.id.lv_v_sl_songs);

        songInfoIntent = new Intent(SongLibrary.this, SongInfo.class);
        createSongIntent = new Intent(SongLibrary.this, CreateSong.class);
        mainActivityIntent = new Intent(SongLibrary.this, MainActivity.class);
        djHomeIntent = new Intent(SongLibrary.this, DjHome.class);

        dbHelper = new DatabaseHelper(this);

        songs = dbHelper.getSongsOfDj(AppData.getUser().getDjId());

        adapter = new SongLibraryListAdapter(this, songs);

        lv_j_sl_songs.setAdapter(adapter);

        AppData.setCurEvent(null);

        AddButtonEventHandler();
        BackButtonEventHandler();
        HomeButtonEventHandler();
        SongsClickEventHandler();
        SongsLongClickEventHandler();
    }

    private void AddButtonEventHandler()
    {
        btn_j_sl_add.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(createSongIntent);
            }
        });
    }

    private void BackButtonEventHandler()
    {
        btn_j_sl_back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(djHomeIntent);
            }
        });
    }

    private void HomeButtonEventHandler()
    {
        btn_j_sl_home.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(mainActivityIntent);
            }
        });
    }

    private void SongsClickEventHandler()
    {
        lv_j_sl_songs.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id)
            {
                AppData.setCurSong(songs.get(i));

                startActivity(songInfoIntent);
            }
        });
    }

    private void SongsLongClickEventHandler()
    {
        lv_j_sl_songs.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long id)
            {
                dbHelper.deleteSong(songs.get(i).getSongId());

                return false;
            }
        });
    }
}