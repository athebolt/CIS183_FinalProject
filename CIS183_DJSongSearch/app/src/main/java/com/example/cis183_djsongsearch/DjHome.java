package com.example.cis183_djsongsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DjHome extends AppCompatActivity
{
    Button btn_j_dh_events;
    Button btn_j_dh_songLib;
    Button btn_j_dh_info;
    Button btn_j_dh_signOut;
    Intent eventLibraryIntent;
    Intent songLibraryIntent;
    Intent djInfoIntent;
    Intent mainActivityIntent;
    Dj dj;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dj_home);

        btn_j_dh_events = findViewById(R.id.btn_v_dh_events);
        btn_j_dh_songLib = findViewById(R.id.btn_v_dh_songLib);
        btn_j_dh_info = findViewById(R.id.btn_v_dh_info);
        btn_j_dh_signOut = findViewById(R.id.btn_v_dh_signOut);

        eventLibraryIntent = new Intent(DjHome.this, EventLibrary.class);
        songLibraryIntent = new Intent(DjHome.this, SongLibrary.class);
        djInfoIntent = new Intent(DjHome.this, DjInfo.class);
        mainActivityIntent = new Intent(DjHome.this, MainActivity.class);

        Intent cameFrom = getIntent();

        dj = (Dj) cameFrom.getSerializableExtra("DJ");

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
                eventLibraryIntent.putExtra("DJ", dj);

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
                songLibraryIntent.putExtra("DJ", dj);

                startActivity(songLibraryIntent);
            }
        });
    }

    private void InfoButtonEventHandler()
    {
        btn_j_dh_info.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                djInfoIntent.putExtra("DJ", dj);

                startActivity(djInfoIntent);
            }
        });
    }

    private void SignOutButtonEventHandler()
    {
        btn_j_dh_signOut.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(mainActivityIntent);
            }
        });
    }
}