package com.example.cis183_djsongsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AttendeeSignUp extends AppCompatActivity
{
    Button btn_j_asu_signUp;
    Button btn_j_asu_back;
    Intent eventSearchIntent;
    Intent attendeeSignInIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendee_sign_up);

        btn_j_asu_signUp = findViewById(R.id.btn_v_asu_signUp);
        btn_j_asu_back = findViewById(R.id.btn_v_asu_back);

        eventSearchIntent = new Intent(AttendeeSignUp.this, EventSearch.class);
        attendeeSignInIntent = new Intent(AttendeeSignUp.this, AttendeeSignIn.class);

        SignUpButtonEventHandler();
        BackButtonEventHandler();
    }

    private void SignUpButtonEventHandler()
    {
        btn_j_asu_signUp.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(eventSearchIntent);
            }
        });
    }

    private void BackButtonEventHandler()
    {
        btn_j_asu_back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(attendeeSignInIntent);
            }
        });
    }
}