package com.example.cis183_djsongsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class CreateEvent extends AppCompatActivity
{
    EditText et_j_ce_code;
    EditText et_j_ce_date;
    EditText et_j_ce_time;
    EditText et_j_ce_location;
    TextView tv_j_ce_privateY;
    TextView tv_j_ce_privateN;
    ImageButton btn_j_ce_privateY;
    ImageButton btn_j_ce_privateN;
    ImageButton btn_j_ce_create;
    ImageButton btn_j_ce_home;
    ImageButton btn_j_ce_back;
    Intent eventLibraryIntent;
    Intent mainActivityIntent;
    DatabaseHelper dbHelper;
    Boolean isPrivate;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        et_j_ce_code = findViewById(R.id.et_v_ce_code);
        et_j_ce_date = findViewById(R.id.et_v_ce_date);
        et_j_ce_time = findViewById(R.id.et_v_ce_time);
        et_j_ce_location = findViewById(R.id.et_v_ce_location);
        tv_j_ce_privateY = findViewById(R.id.tv_v_ce_privateY);
        tv_j_ce_privateN = findViewById(R.id.tv_v_ce_privateN);
        btn_j_ce_privateY = findViewById(R.id.btn_v_ce_privateY);
        btn_j_ce_privateN = findViewById(R.id.btn_v_ce_privateN);
        btn_j_ce_create = findViewById(R.id.btn_v_ce_create);
        btn_j_ce_home = findViewById(R.id.btn_v_ce_home);
        btn_j_ce_back = findViewById(R.id.btn_v_ce_back);

        eventLibraryIntent = new Intent(CreateEvent.this, EventLibrary.class);
        mainActivityIntent = new Intent(CreateEvent.this, MainActivity.class);

        dbHelper = new DatabaseHelper(this);

        isPrivate = null;

        PrivateYButtonEventHandler();
        PrivateNButtonEventHandler();
        CreateButtonEventHandler();
        HomeButtonEventHandler();
        BackButtonEventHandler();
    }

    private void PrivateYButtonEventHandler()
    {
        btn_j_ce_privateY.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                isPrivate = true;

                tv_j_ce_privateY.setVisibility(View.VISIBLE);
                tv_j_ce_privateN.setVisibility(View.INVISIBLE);
            }
        });
    }

    private void PrivateNButtonEventHandler()
    {
        btn_j_ce_privateN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isPrivate = false;

                tv_j_ce_privateY.setVisibility(View.INVISIBLE);
                tv_j_ce_privateN.setVisibility(View.VISIBLE);
            }
        });
    }

    private void CreateButtonEventHandler()
    {
        btn_j_ce_create.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Event event = new Event(
                        et_j_ce_code.getText().toString(),
                        AppData.getUser().getDjId(),
                        et_j_ce_date.getText().toString(),
                        et_j_ce_time.getText().toString(),
                        et_j_ce_location.getText().toString(),
                        isPrivate.toString(),
                        "false"
                        );

                dbHelper.addNewEvent(event);

                startActivity(eventLibraryIntent);
            }
        });
    }

    private void HomeButtonEventHandler()
    {
        btn_j_ce_home.setOnClickListener(new View.OnClickListener()
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
        btn_j_ce_back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(eventLibraryIntent);
            }
        });
    }
}