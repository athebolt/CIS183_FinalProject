package com.example.cis183_djsongsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class AttendeeSignIn extends AppCompatActivity
{
    TextView tv_j_asi_error;
    EditText et_j_asi_uName;
    EditText et_j_asi_pass;
    ImageButton btn_j_asi_signIn;
    ImageButton btn_j_asi_signUp;
    ImageButton btn_j_asi_home;
    Intent mainActivityIntent;
    Intent eventSearchIntent;
    Intent attendeeSignUpIntent;
    DatabaseHelper dbHelper;
    ArrayList<Attendee> listOfAttendees;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendee_sign_in);

        tv_j_asi_error = findViewById(R.id.tv_v_asi_error);
        et_j_asi_uName = findViewById(R.id.et_v_asi_uName);
        et_j_asi_pass = findViewById(R.id.et_v_asi_pass);
        btn_j_asi_signIn = findViewById(R.id.btn_v_asi_signIn);
        btn_j_asi_signUp = findViewById(R.id.btn_v_asi_signUp);
        btn_j_asi_home = findViewById(R.id.btn_v_asi_home);

        mainActivityIntent = new Intent(AttendeeSignIn.this, MainActivity.class);
        eventSearchIntent = new Intent(AttendeeSignIn.this, EventSearch.class);
        attendeeSignUpIntent = new Intent(AttendeeSignIn.this, AttendeeSignUp.class);

        dbHelper = new DatabaseHelper(this);

        SignInButtonEventHandler();
        SignUpButtonEventHandler();
        HomeButtonEventHandler();
    }

    private void SignInButtonEventHandler()
    {
        btn_j_asi_signIn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int i = 0;

                listOfAttendees = dbHelper.getAllAttendees();

                while(i < listOfAttendees.size())
                {
                    if(et_j_asi_uName.getText().toString().equals(listOfAttendees.get(i).getUsername()))
                    {
                        if(et_j_asi_pass.getText().toString().equals(listOfAttendees.get(i).getPassword()))
                        {
                            AppData.setCurAttendee(listOfAttendees.get(i));

                            startActivity(eventSearchIntent);
                        }
                    }

                    i++;
                }

                et_j_asi_uName.setText("");
                et_j_asi_pass.setText("");
                tv_j_asi_error.setVisibility(View.VISIBLE);
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

    private void HomeButtonEventHandler()
    {
        btn_j_asi_home.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(mainActivityIntent);
            }
        });
    }
}