package com.example.cis183_djsongsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class DjHome extends AppCompatActivity
{
    ImageButton btn_j_dh_events;
    ImageButton btn_j_dh_songLib;
    ImageButton btn_j_dh_djInfo;
    ImageButton btn_j_dh_home;
    Intent eventLibraryIntent;
    Intent songLibraryIntent;
    Intent djInfoIntent;
    Intent mainActivityIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dj_home);

        btn_j_dh_events = findViewById(R.id.btn_v_dh_events);
        btn_j_dh_songLib = findViewById(R.id.btn_v_dh_songLib);
        btn_j_dh_djInfo = findViewById(R.id.btn_v_dh_djInfo);
        btn_j_dh_home = findViewById(R.id.btn_v_dh_home);

        eventLibraryIntent = new Intent(DjHome.this, EventLibrary.class);
        songLibraryIntent = new Intent(DjHome.this, SongLibrary.class);
        djInfoIntent = new Intent(DjHome.this, DjInfo.class);
        mainActivityIntent = new Intent(DjHome.this, MainActivity.class);

        EventsButtonEventHandler();
        SongLibraryButtonEventHandler();
        InfoButtonEventHandler();
        SignOutButtonEventHandler();
    }

    private void EventsButtonEventHandler()
    {
        btn_j_dh_events.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(eventLibraryIntent);
            }
        });
    }

    private void SongLibraryButtonEventHandler()
    {
        btn_j_dh_songLib.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(songLibraryIntent);
            }
        });
    }

    private void InfoButtonEventHandler()
    {
        btn_j_dh_djInfo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(djInfoIntent);
            }
        });
    }

    private void SignOutButtonEventHandler()
    {
        btn_j_dh_home.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(mainActivityIntent);
            }
        });
    }
}