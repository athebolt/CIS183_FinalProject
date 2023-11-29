package com.example.cis183_djsongsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreateSong extends AppCompatActivity
{
    Button btn_j_cs_create;
    Button btn_j_cs_back;
    Intent songLibraryIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_song);

        btn_j_cs_create = findViewById(R.id.btn_v_cs_create);
        btn_j_cs_back = findViewById(R.id.btn_v_cs_back);

        songLibraryIntent = new Intent(CreateSong.this, SongLibrary.class);

        CreateButtonEventHandler();
        BackButtonEventHandler();
    }

    private void CreateButtonEventHandler()
    {
        btn_j_cs_create.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(songLibraryIntent);
            }
        });
    }

    private void BackButtonEventHandler()
    {
        btn_j_cs_back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(songLibraryIntent);
            }
        });
    }
}