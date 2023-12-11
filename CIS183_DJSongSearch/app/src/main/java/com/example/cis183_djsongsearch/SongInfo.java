package com.example.cis183_djsongsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class SongInfo extends AppCompatActivity
{
    TextView tv_j_si_explicitY;
    TextView tv_j_si_explicitN;
    EditText et_j_si_name;
    EditText et_j_si_artist;
    EditText et_j_si_duration;
    ImageButton btn_j_si_explicitY;
    ImageButton btn_j_si_explicitN;
    ImageButton btn_j_si_update;
    ImageButton btn_j_si_home;
    ImageButton btn_j_si_back;
    Intent returnIntent;
    Intent mainActivityIntent;
    DatabaseHelper dbHelper;
    Boolean isExplicit;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_info);

        tv_j_si_explicitY = findViewById(R.id.tv_v_si_explicitY);
        tv_j_si_explicitN = findViewById(R.id.tv_v_si_explicitN);
        et_j_si_name = findViewById(R.id.et_v_si_name);
        et_j_si_artist = findViewById(R.id.et_v_si_artist);
        et_j_si_duration = findViewById(R.id.et_v_si_duration);
        btn_j_si_explicitY = findViewById(R.id.btn_v_si_explicitY);
        btn_j_si_explicitN = findViewById(R.id.btn_v_si_explicitN);
        btn_j_si_update = findViewById(R.id.btn_v_si_update);
        btn_j_si_home = findViewById(R.id.btn_v_si_home);
        btn_j_si_back = findViewById(R.id.btn_v_si_back);

        //determines what event we go back to because theres 2 different intents we could come from
        //we determine by seeing if there is an active event going on
        if(AppData.getCurEvent() == null)
        {
            returnIntent = new Intent(SongInfo.this, SongLibrary.class);
        }
        else
        {
            returnIntent = new Intent(SongInfo.this, ActiveEvent.class);
        }

        mainActivityIntent = new Intent(SongInfo.this, MainActivity.class);

        dbHelper = new DatabaseHelper(this);

        et_j_si_name.setText(AppData.getCurSong().getSongName());
        et_j_si_artist.setText(AppData.getCurSong().getArtist());
        et_j_si_duration.setText(AppData.getCurSong().getDuration());



        if(AppData.getCurSong().getExplicit().equals("true"))
        {
            tv_j_si_explicitY.setVisibility(View.VISIBLE);

            isExplicit = true;
        }
        else
        {
            tv_j_si_explicitN.setVisibility(View.VISIBLE);

            isExplicit = false;
        }

        ExplicitYButtonEventHandler();
        ExplicitNButtonEventHandler();
        UpdateButtonEventHandler();
        BackButtonEventHandler();
        HomeButtonEventHandler();
    }

    private void ExplicitYButtonEventHandler()
    {
        btn_j_si_explicitY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isExplicit = true;

                tv_j_si_explicitY.setVisibility(View.VISIBLE);
                tv_j_si_explicitN.setVisibility(View.INVISIBLE);
            }
        });
    }

    private void ExplicitNButtonEventHandler()
    {
        btn_j_si_explicitN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isExplicit = false;

                tv_j_si_explicitY.setVisibility(View.INVISIBLE);
                tv_j_si_explicitN.setVisibility(View.VISIBLE);
            }
        });
    }

    private void UpdateButtonEventHandler()
    {
        btn_j_si_update.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Song updatedSong = new Song(AppData.getCurSong().getSongId(), et_j_si_name.getText().toString(), et_j_si_artist.getText().toString(), isExplicit.toString(), et_j_si_duration.getText().toString(), AppData.getUser().getDjId());

                dbHelper.updateSong(updatedSong);

                startActivity(returnIntent);
            }
        });
    }

    private void BackButtonEventHandler()
    {
        btn_j_si_back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(returnIntent);
            }
        });
    }

    private void HomeButtonEventHandler()
    {
        btn_j_si_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(mainActivityIntent);
            }
        });
    }
}