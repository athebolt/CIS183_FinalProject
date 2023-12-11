package com.example.cis183_djsongsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class ActiveEvent extends AppCompatActivity
{
    ImageButton btn_j_ae_home;
    ImageButton btn_j_ae_back;
    ImageButton btn_j_ae_end;
    ListView lv_j_ae_reqSongs;
    Intent eventLibraryIntent;
    Intent songInfoIntent;
    Intent mainActivityIntent;
    DatabaseHelper dbHelper;
    SongLibraryListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_event);

        btn_j_ae_home = findViewById(R.id.btn_v_ae_home);
        btn_j_ae_back = findViewById(R.id.btn_v_ae_back);
        btn_j_ae_end = findViewById(R.id.btn_v_ae_end);
        lv_j_ae_reqSongs = findViewById(R.id.lv_v_ae_reqSongs);

        eventLibraryIntent = new Intent(ActiveEvent.this, EventLibrary.class);
        songInfoIntent = new Intent(ActiveEvent.this, SongInfo.class);
        mainActivityIntent = new Intent(ActiveEvent.this, MainActivity.class);

        dbHelper = new DatabaseHelper(this);

        adapter = new SongLibraryListAdapter(this, AppData.getReqSongs());

        lv_j_ae_reqSongs.setAdapter(adapter);

        
        HomeButtonEventHandler();
        BackButtonEventHandler();
        EndButtonEventHandler();
        ListClickEventHandler();
        ListLongClickEventHandler();
    }

    private void HomeButtonEventHandler()
    {
        btn_j_ae_home.setOnClickListener(new View.OnClickListener()
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
        btn_j_ae_back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(eventLibraryIntent);
            }
        });
    }

    private void EndButtonEventHandler()
    {
       btn_j_ae_end.setOnClickListener(new View.OnClickListener()
       {
           @Override
           public void onClick(View v)
           {
               dbHelper.deleteEvent(AppData.getCurEvent().getEventCode());

               startActivity(eventLibraryIntent);
           }
       });
    }

    private void ListClickEventHandler()
    {
        lv_j_ae_reqSongs.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id)
            {
                AppData.setCurSong(AppData.getReqSongs().get(i));

                startActivity(songInfoIntent);
            }
        });
    }

    private void ListLongClickEventHandler()
    {
        lv_j_ae_reqSongs.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long id)
            {
                AppData.removeReqSong(i);

                adapter.notifyDataSetChanged();

                return false;
            }
        });
    }
}