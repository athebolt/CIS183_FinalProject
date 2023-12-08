package com.example.cis183_djsongsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class AttendeeSongInfo extends AppCompatActivity
{
    TextView tv_j_as_name;
    TextView tv_j_as_artist;
    TextView tv_j_as_duration;
    TextView tv_j_as_explicitY;
    TextView tv_j_as_explicitN;
    ImageButton btn_j_as_select;
    ImageButton btn_j_as_home;
    ImageButton btn_j_as_back;
    Intent requestSongIntent;
    Intent mainActivityIntent;
    Intent songSearchIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendee_song_info);

        tv_j_as_name = findViewById(R.id.tv_v_as_name);
        tv_j_as_artist = findViewById(R.id.tv_v_as_artist);
        tv_j_as_duration = findViewById(R.id.tv_v_as_duration);
        tv_j_as_explicitY = findViewById(R.id.tv_v_as_explicitY);
        tv_j_as_explicitN = findViewById(R.id.tv_v_as_explicitN);
        btn_j_as_select = findViewById(R.id.btn_v_as_select);
        btn_j_as_home = findViewById(R.id.btn_v_as_home);
        btn_j_as_back = findViewById(R.id.btn_v_as_back);

        requestSongIntent = new Intent(AttendeeSongInfo.this, RequestSong.class);
        mainActivityIntent = new Intent(AttendeeSongInfo.this, MainActivity.class);
        songSearchIntent = new Intent(AttendeeSongInfo.this, RequestSong.class);

        tv_j_as_name.setText(AppData.getCurSong().getSongName());
        tv_j_as_artist.setText(AppData.getCurSong().getArtist());
        tv_j_as_duration.setText(AppData.getCurSong().getDuration());

        if(AppData.getCurSong().getExplicit().equals("true"))
        {
            tv_j_as_explicitY.setVisibility(View.VISIBLE);
        }
        else
        {
            tv_j_as_explicitN.setVisibility(View.VISIBLE);
        }

        SelectButtonEventHandler();
        HomeButtonEventHandler();
        BackButtonEventHandler();
    }

    private void SelectButtonEventHandler()
    {
        btn_j_as_select.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AppData.addReqSong(AppData.getCurSong());

                startActivity(requestSongIntent);
            }
        });
    }

    private void HomeButtonEventHandler()
    {
        btn_j_as_home.setOnClickListener(new View.OnClickListener()
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