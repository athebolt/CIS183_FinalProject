package com.example.cis183_djsongsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity
{
    ImageButton btn_j_ma_djSignIn;
    ImageButton btn_j_ma_attendeeSignIn;
    Intent djSignInIntent;
    Intent attendeeSignInIntent;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_j_ma_djSignIn = findViewById(R.id.btn_v_ma_djSignIn);
        btn_j_ma_attendeeSignIn = findViewById(R.id.btn_v_ma_attendeeSignIn);

        djSignInIntent = new Intent(MainActivity.this, DjSignIn.class);
        attendeeSignInIntent = new Intent(MainActivity.this, AttendeeSignIn.class);

        dbHelper = new DatabaseHelper(this);

        //if any rows are empty, not anymore
        dbHelper.initializeDB();

        if(AppData.getReqSongs() == null)
        {
            AppData.initReqSongs();
        }

        dJSignInButtonEventHandler();
        attendeeSignInButtonEventHandler();
    }

    public void dJSignInButtonEventHandler()
    {
        btn_j_ma_djSignIn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(djSignInIntent);
            }
        });
    }

    public void attendeeSignInButtonEventHandler()
    {
        btn_j_ma_attendeeSignIn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(attendeeSignInIntent);
            }
        });
    }
}