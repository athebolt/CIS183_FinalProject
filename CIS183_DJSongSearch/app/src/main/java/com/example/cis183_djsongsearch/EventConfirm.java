package com.example.cis183_djsongsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class EventConfirm extends AppCompatActivity
{
    TextView tv_j_ec_dj;
    ImageButton btn_j_ec_n;
    ImageButton btn_j_ec_y;
    Intent eventSearchIntent;
    Intent requestSongIntent;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_confirm);

        tv_j_ec_dj = findViewById(R.id.tv_v_ec_dj);
        btn_j_ec_n = findViewById(R.id.btn_v_ec_n);
        btn_j_ec_y = findViewById(R.id.btn_v_ec_y);

        eventSearchIntent = new Intent(EventConfirm.this, EventSearch.class);
        requestSongIntent = new Intent(EventConfirm.this, RequestSong.class);

        dbHelper = new DatabaseHelper(this);

        tv_j_ec_dj.setText(dbHelper.getDjOfEvent(AppData.getCurEvent().getEventCode()));

        NoButtonEventHandler();
        YesButtonEventHandler();
    }

    private void NoButtonEventHandler()
    {
        btn_j_ec_n.setOnClickListener(new View.OnClickListener()
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
        btn_j_ec_y.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(requestSongIntent);
            }
        });
    }
}