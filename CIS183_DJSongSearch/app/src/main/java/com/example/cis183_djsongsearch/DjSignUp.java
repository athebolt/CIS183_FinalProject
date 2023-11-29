package com.example.cis183_djsongsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DjSignUp extends AppCompatActivity
{
    EditText et_j_dsu_dName;
    EditText et_j_dsu_pass;
    Button btn_j_dsu_signUp;
    Button btn_j_dsu_back;
    Intent djHomeIntent;
    Intent djSignInIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dj_sign_up);

        et_j_dsu_dName = findViewById(R.id.et_v_dsu_dName);
        et_j_dsu_pass = findViewById(R.id.et_v_dsu_pass);
        btn_j_dsu_signUp = findViewById(R.id.btn_v_dsu_signUp);
        btn_j_dsu_back = findViewById(R.id.btn_v_dsu_back);

        djHomeIntent = new Intent(DjSignUp.this, DjHome.class);
        djSignInIntent = new Intent(DjSignUp.this, DjSignIn.class);

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