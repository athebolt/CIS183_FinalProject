package com.example.cis183_djsongsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class DjSignUp extends AppCompatActivity
{
    TextView tv_j_dsu_error;
    EditText et_j_dsu_dName;
    EditText et_j_dsu_pass;
    ImageButton btn_j_dsu_signUp;
    ImageButton btn_j_dsu_home;
    ImageButton btn_j_dsu_back;
    Intent djSignInIntent;
    Intent djHomeIntent;
    DatabaseHelper dbHelper;
    ArrayList<Dj> listOfDjs;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dj_sign_up);

        tv_j_dsu_error = findViewById(R.id.tv_v_dsu_error);
        et_j_dsu_dName = findViewById(R.id.et_v_dsu_dName);
        et_j_dsu_pass = findViewById(R.id.et_v_dsu_pass);
        btn_j_dsu_signUp = findViewById(R.id.btn_v_dsu_signUp);
        btn_j_dsu_home = findViewById(R.id.btn_v_dsu_home);
        btn_j_dsu_back = findViewById(R.id.btn_v_dsu_back);

        djSignInIntent = new Intent(DjSignUp.this, DjSignIn.class);
        djHomeIntent = new Intent(DjSignUp.this, DjHome.class);

        dbHelper = new DatabaseHelper(this);

        listOfDjs = dbHelper.getAllDjs();

        SignUpButtonEventHandler();
        BackButtonEventHandler();
    }

    private void SignUpButtonEventHandler()
    {
        btn_j_dsu_signUp.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                for (int i = 0; i < listOfDjs.size(); i++)
                {
                    if(listOfDjs.get(i).getDjName().equals(et_j_dsu_dName.getText().toString()))
                    {
                        tv_j_dsu_error.setVisibility(View.VISIBLE);

                        return;
                    }
                }

                Dj dj = new Dj(et_j_dsu_dName.getText().toString(),et_j_dsu_pass.getText().toString());

                dbHelper.addNewDJ(dj);

                AppData.setUser(dj);

                startActivity(djHomeIntent);
            }
        });
    }

    private void BackButtonEventHandler()
    {
        btn_j_dsu_back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(djSignInIntent);
            }
        });
    }
}