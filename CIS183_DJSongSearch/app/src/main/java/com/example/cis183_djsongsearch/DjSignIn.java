package com.example.cis183_djsongsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DjSignIn extends AppCompatActivity
{
    TextView tv_j_dsi_title;
    TextView tv_j_dsi_name;
    TextView tv_j_dsi_pass;
    EditText et_j_dsi_name;
    EditText et_j_dsi_pass;
    Button btn_j_dsi_signIn;
    Button btn_j_dsi_signUp;
    Button btn_j_dsi_back;
    Intent mainActivityIntent;
    Intent djSignUpIntent;
    Intent djHomeIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dj_sign_in);

        tv_j_dsi_title = findViewById(R.id.tv_v_dsi_title);
        tv_j_dsi_name = findViewById(R.id.tv_v_dsi_name);
        tv_j_dsi_pass = findViewById(R.id.tv_v_dsi_pass);
        et_j_dsi_name = findViewById(R.id.et_v_dsi_name);
        et_j_dsi_pass = findViewById(R.id.et_v_dsi_pass);
        btn_j_dsi_signIn = findViewById(R.id.btn_v_dsi_signIn);
        btn_j_dsi_signUp = findViewById(R.id.btn_v_dsi_signUp);
        btn_j_dsi_back = findViewById(R.id.btn_v_dsi_back);

        mainActivityIntent = new Intent(DjSignIn.this, MainActivity.class);
        djSignUpIntent = new Intent(DjSignIn.this, DjSignUp.class);
        djHomeIntent = new Intent(DjSignIn.this, DjHome.class);

        signInButtonEventHandler();
        signUpButtonEventHandler();
        backButtonEventHandler();
    }

    public void signInButtonEventHandler()
    {
        btn_j_dsi_signIn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(djHomeIntent);
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

    public void backButtonEventHandler()
    {
        btn_j_dsi_back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(mainActivityIntent);
            }
        });
    }
}