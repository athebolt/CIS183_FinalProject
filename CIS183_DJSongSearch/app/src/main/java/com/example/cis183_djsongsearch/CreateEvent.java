package com.example.cis183_djsongsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class CreateEvent extends AppCompatActivity
{
    EditText et_j_ce_code;
    EditText et_j_ce_date;
    EditText et_j_ce_time;
    EditText et_j_ce_loc;
    CheckBox cb_j_ce_private;
    Button btn_j_ce_create;
    Button btn_j_ce_back;
    Intent eventLibraryIntent;
    DatabaseHelper dbHelper;
    Dj dj;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        et_j_ce_code = findViewById(R.id.et_v_ce_code);
        et_j_ce_date = findViewById(R.id.et_v_ce_date);
        et_j_ce_time = findViewById(R.id.et_v_ce_time);
        et_j_ce_loc = findViewById(R.id.et_v_ce_loc);
        cb_j_ce_private = findViewById(R.id.cb_v_ce_private);
        btn_j_ce_create = findViewById(R.id.btn_v_ce_create);
        btn_j_ce_back = findViewById(R.id.btn_v_ce_back);

        eventLibraryIntent = new Intent(CreateEvent.this, EventLibrary.class);

        dbHelper = new DatabaseHelper(this);

        Intent cameFrom = getIntent();

        dj = (Dj) cameFrom.getSerializableExtra("DJ");

        CreateButtonEventHandler();
        BackButtonEventHandler();
    }

    private void CreateButtonEventHandler()
    {
        btn_j_ce_create.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String priv;

                if(cb_j_ce_private.isChecked())
                {
                    priv = "true";
                }
                else
                {
                    priv = "false";
                }

                Event event = new Event(
                        et_j_ce_code.getText().toString(),
                        dj.getDjId(),
                        et_j_ce_date.getText().toString(),
                        et_j_ce_time.getText().toString(),
                        et_j_ce_loc.getText().toString(),
                        priv,
                        "false"
                        );

                dbHelper.addNewEvent(event);

                eventLibraryIntent.putExtra("DJ", dj);

                startActivity(eventLibraryIntent);
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
                eventLibraryIntent.putExtra("DJ", dj);

                startActivity(eventLibraryIntent);
            }
        });
    }
}