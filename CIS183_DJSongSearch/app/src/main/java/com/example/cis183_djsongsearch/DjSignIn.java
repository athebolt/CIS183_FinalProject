package com.example.cis183_djsongsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class DjSignIn extends AppCompatActivity
{
    TextView tv_j_dsi_error;
    EditText et_j_dsi_dName;
    EditText et_j_dsi_pass;
    ImageButton btn_j_dsi_signIn;
    ImageButton btn_j_dsi_signUp;
    ImageButton btn_j_dsi_home;
    Intent mainActivityIntent;
    Intent djSignUpIntent;
    Intent djHomeIntent;
    DatabaseHelper dbHelper;
    ArrayList<Dj> listOfDjs;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dj_sign_in);

        tv_j_dsi_error = findViewById(R.id.tv_v_dsi_error);
        et_j_dsi_dName = findViewById(R.id.et_v_dsi_dName);
        et_j_dsi_pass = findViewById(R.id.et_v_dsi_pass);
        btn_j_dsi_signIn = findViewById(R.id.btn_v_dsi_signIn);
        btn_j_dsi_signUp = findViewById(R.id.btn_v_dsi_signUp);
        btn_j_dsi_home = findViewById(R.id.btn_v_dsi_home);

        mainActivityIntent = new Intent(DjSignIn.this, MainActivity.class);
        djSignUpIntent = new Intent(DjSignIn.this, DjSignUp.class);
        djHomeIntent = new Intent(DjSignIn.this, DjHome.class);

        dbHelper = new DatabaseHelper(this);

        signInButtonEventHandler();
        signUpButtonEventHandler();
        homeButtonEventHandler();
    }

    public void signInButtonEventHandler()
    {
        btn_j_dsi_signIn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int i = 0;

                listOfDjs = dbHelper.getAllDjs();

                while(i < listOfDjs.size())
                {
                    if(et_j_dsi_dName.getText().toString().equals(listOfDjs.get(i).getDjName()))
                    {
                        if(et_j_dsi_pass.getText().toString().equals(listOfDjs.get(i).getPassword()))
                        {
                            AppData.setUser(listOfDjs.get(i));

                            Log.d("Logged in DJ id", AppData.getUser().getDjId() + "");

                            startActivity(djHomeIntent);
                        }
                    }

                    i++;
                }

                tv_j_dsi_error.setVisibility(View.VISIBLE);
                et_j_dsi_dName.setText("");
                et_j_dsi_pass.setText("");
            }
        });
    }

    public void signUpButtonEventHandler()
    {
        btn_j_dsi_signUp.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(djSignUpIntent);
            }
        });
    }

    public void homeButtonEventHandler()
    {
        btn_j_dsi_home.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(mainActivityIntent);
            }
        });
    }
}