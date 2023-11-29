package com.example.cis183_djsongsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DjInfo extends AppCompatActivity
{
    Button btn_j_di_update;
    Button btn_j_di_delete;
    Intent djHomeIntent;
    Intent mainActivityIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dj_info);

        btn_j_di_update = findViewById(R.id.btn_v_di_update);
        btn_j_di_delete = findViewById(R.id.btn_v_di_delete);

        djHomeIntent = new Intent(DjInfo.this, DjHome.class);
        mainActivityIntent = new Intent(DjInfo.this, MainActivity.class);

        UpdateButtonEventHandler();
        DeleteButtonEventHandler();
    }

    private void UpdateButtonEventHandler()
    {
        btn_j_di_update.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(djHomeIntent);
            }
        });
    }

    private void DeleteButtonEventHandler()
    {
        btn_j_di_delete.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(mainActivityIntent);
            }
        });
    }
}