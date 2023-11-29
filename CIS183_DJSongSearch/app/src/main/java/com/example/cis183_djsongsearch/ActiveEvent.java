package com.example.cis183_djsongsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class ActiveEvent extends AppCompatActivity
{
    Button btn_j_ae_back;
    Button btn_j_ae_end;
    ListView lv_j_ae_reqSongs;
    Intent eventLibraryIntent;
    Intent songInfoIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_event);

        btn_j_ae_back = findViewById(R.id.btn_v_ae_back);
        btn_j_ae_end = findViewById(R.id.btn_v_ae_end);
        lv_j_ae_reqSongs = findViewById(R.id.lv_v_ae_reqSongs);

        eventLibraryIntent = new Intent(ActiveEvent.this, EventLibrary.class);
        songInfoIntent = new Intent(ActiveEvent.this, SongInfo.class);

        BackButtonEventHandler();
        EndButtonEventHandler();
        ListClickEventHandler();
        ListLongClickEventHandler();
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
                startActivity(eventLibraryIntent);
           }
       });
    }

    private void ListClickEventHandler()
    {
        lv_j_ae_reqSongs.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                startActivity(songInfoIntent);
            }
        });
    }

    private void ListLongClickEventHandler()
    {
        lv_j_ae_reqSongs.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)
            {
                return false;
            }
        });
    }
}