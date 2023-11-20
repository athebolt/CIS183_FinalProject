package com.example.cis183_djsongsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    Button btn_j_ma_djSignIn;
    Button btn_j_ma_attendeeSignIn;
    Intent signInIntent;
    Boolean isDj;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_j_ma_djSignIn = findViewById(R.id.btn_v_ma_djSignIn);
        btn_j_ma_attendeeSignIn = findViewById(R.id.btn_v_ma_attendeeSignIn);

        signInIntent = new Intent(MainActivity.this, SignIn.class);

        //isDj = false;

        dJSignInButtonEventHandler();
        attendeeSignInButtonEventHandler();
    }

    public void dJSignInButtonEventHandler()
    {
        btn_j_ma_djSignIn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                isDj = true;

                signInIntent.putExtra("isDj", isDj);
                startActivity(signInIntent);
            }
        });
    }

    public void attendeeSignInButtonEventHandler()
    {
        btn_j_ma_attendeeSignIn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                isDj = false;

                signInIntent.putExtra("isDj", isDj);
                startActivity(signInIntent);
            }
        });
    }
}