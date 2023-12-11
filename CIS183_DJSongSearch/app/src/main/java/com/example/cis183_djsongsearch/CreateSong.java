package com.example.cis183_djsongsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class CreateSong extends AppCompatActivity
{
    EditText et_j_cs_name;
    EditText et_j_cs_artist;
    EditText et_j_cs_duration;
    TextView tv_j_cs_explicitY;
    TextView tv_j_cs_explicitN;
    ImageButton btn_j_cs_explicitY;
    ImageButton btn_j_cs_explicitN;
    ImageButton btn_j_cs_create;
    ImageButton btn_j_cs_home;
    ImageButton btn_j_cs_back;
    Intent songLibraryIntent;
    Intent mainActivityIntent;
    DatabaseHelper dbHelper;
    Boolean isExplicit;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_song);

        et_j_cs_name = findViewById(R.id.et_v_cs_name);
        et_j_cs_artist = findViewById(R.id.et_v_cs_artist);
        et_j_cs_duration = findViewById(R.id.et_v_cs_duration);
        tv_j_cs_explicitY = findViewById(R.id.tv_v_cs_explicitY);
        tv_j_cs_explicitN = findViewById(R.id.tv_v_cs_explicitN);
        btn_j_cs_explicitY = findViewById(R.id.btn_v_cs_explicitY);
        btn_j_cs_explicitN = findViewById(R.id.btn_v_cs_explicitN);
        btn_j_cs_create = findViewById(R.id.btn_v_cs_create);
        btn_j_cs_home = findViewById(R.id.btn_v_cs_home);
        btn_j_cs_back = findViewById(R.id.btn_v_cs_back);

        songLibraryIntent = new Intent(CreateSong.this, SongLibrary.class);
        mainActivityIntent = new Intent(CreateSong.this, MainActivity.class);

        dbHelper = new DatabaseHelper(this);

        isExplicit = null;

        ExplicitYButtonEventHandler();
        ExplicitNButtonEventHandler();
        CreateButtonEventHandler();
        HomeButtonEventHandler();
        BackButtonEventHandler();
    }

    private void ExplicitYButtonEventHandler()
    {
        btn_j_cs_explicitY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isExplicit = true;

                tv_j_cs_explicitY.setVisibility(View.VISIBLE);
                tv_j_cs_explicitN.setVisibility(View.INVISIBLE);
            }
        });
    }

    private void ExplicitNButtonEventHandler()
    {
        btn_j_cs_explicitN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isExplicit = false;

                tv_j_cs_explicitY.setVisibility(View.INVISIBLE);
                tv_j_cs_explicitN.setVisibility(View.VISIBLE);
            }
        });
    }

    private void CreateButtonEventHandler()
    {
        btn_j_cs_create.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                if(!(isExplicit == null) && !et_j_cs_name.toString().equals("") && !et_j_cs_artist.toString().equals("") && !et_j_cs_duration.toString().equals(""))
                {
                    Song newSong = new Song(
                            et_j_cs_name.getText().toString(),
                            et_j_cs_artist.getText().toString(),
                            isExplicit.toString(),
                            et_j_cs_duration.getText().toString(),
                            AppData.getUser().getDjId()
                    );

                    dbHelper.addNewSong(newSong);

                    startActivity(songLibraryIntent);
                }
            }
        });
    }

    private void HomeButtonEventHandler()
    {
        btn_j_cs_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(mainActivityIntent);
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