package com.example.cis183_djsongsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AttendeeSignIn extends AppCompatActivity
{
    Button btn_j_asi_signIn;
    Button btn_j_asi_signUp;
    Button btn_j_asi_back;
    Intent mainActivityIntent;
    Intent eventSearchIntent;
    Intent attendeeSignUpIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendee_sign_in);

        btn_j_asi_signIn = findViewById(R.id.btn_v_asi_signIn);
        btn_j_asi_signUp = findViewById(R.id.btn_v_asi_signUp);
        btn_j_asi_back = findViewById(R.id.btn_v_asi_back);

        mainActivityIntent = new Intent(AttendeeSignIn.this, MainActivity.class);
        eventSearchIntent = new Intent(AttendeeSignIn.this, EventSearch.class);
        attendeeSignUpIntent = new Intent(AttendeeSignIn.this, AttendeeSignUp.class);

        SignInButtonEventHandler();
        SignUpButtonEventHandler();
        BackButtonEventHandler();
    }

    private void SignInButtonEventHandler()
    {
        btn_j_asi_signIn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(eventSearchIntent);
            }
        });
    }

    private void SignUpButtonEventHandler()
    {
        btn_j_asi_signUp.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(attendeeSignUpIntent);
            }
        });
    }

    private void BackButtonEventHandler()
    {
        btn_j_asi_back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(mainActivityIntent);
            }
        });
    }
}