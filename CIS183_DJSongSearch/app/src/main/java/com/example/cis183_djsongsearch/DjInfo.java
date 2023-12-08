package com.example.cis183_djsongsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class DjInfo extends AppCompatActivity
{
    EditText et_j_di_name;
    EditText et_j_di_pass;
    ImageButton btn_j_di_home;
    ImageButton btn_j_di_update;
    ImageButton btn_j_di_delete;
    Intent djHomeIntent;
    Intent mainActivityIntent;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dj_info);

        et_j_di_name = findViewById(R.id.et_v_di_name);
        et_j_di_pass = findViewById(R.id.et_v_di_pass);
        btn_j_di_home = findViewById(R.id.btn_v_di_home);
        btn_j_di_update = findViewById(R.id.btn_v_di_update);
        btn_j_di_delete = findViewById(R.id.btn_v_di_delete);

        djHomeIntent = new Intent(DjInfo.this, DjHome.class);
        mainActivityIntent = new Intent(DjInfo.this, MainActivity.class);

        dbHelper = new DatabaseHelper(this);

        et_j_di_name.setText(AppData.getUser().getDjName());
        et_j_di_pass.setText(AppData.getUser().getPassword());

        HomeButtonEventHandler();
        UpdateButtonEventHandler();
        DeleteButtonEventHandler();
    }

    private void HomeButtonEventHandler()
    {
        btn_j_di_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(mainActivityIntent);
            }
        });
    }

    private void UpdateButtonEventHandler()
    {
        btn_j_di_update.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Dj newDj = new Dj(AppData.getUser().getDjId(), et_j_di_name.getText().toString(), et_j_di_pass.getText().toString());

                dbHelper.updateDj(newDj);

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
                dbHelper.deleteDj(AppData.getUser().getDjId());

                startActivity(mainActivityIntent);
            }
        });
    }
}