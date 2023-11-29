package com.example.cis183_djsongsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EventConfirm extends AppCompatActivity
{
    TextView tv_j_ec_dj;
    Button btn_j_ec_no;
    Button btn_j_ec_yes;
    Intent eventSearchIntent;
    Intent requestSongIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_confirm);

        tv_j_ec_dj = findViewById(R.id.tv_v_ec_dj);
        btn_j_ec_no = findViewById(R.id.btn_v_ec_no);
        btn_j_ec_yes = findViewById(R.id.btn_v_ec_yes);

        eventSearchIntent = new Intent(EventConfirm.this, EventSearch.class);
        requestSongIntent = new Intent(EventConfirm.this, RequestSong.class);

        NoButtonEventHandler();
        YesButtonEventHandler();
    }

    private void NoButtonEventHandler()
    {
        btn_j_ec_no.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(eventSearchIntent);
            }
        });
    }

    private void YesButtonEventHandler()
    {
        btn_j_ec_yes.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(requestSongIntent);
            }
        });
    }
}