package com.example.cis183_djsongsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class AttendeeSignUp extends AppCompatActivity
{
    EditText et_j_asu_fName;
    EditText et_j_asu_lName;
    EditText et_j_asu_uName;
    EditText et_j_asu_pass;
    ImageButton btn_j_asu_signUp;
    ImageButton btn_j_asu_home;
    ImageButton btn_j_asu_back;
    Intent eventSearchIntent;
    Intent mainActivityIntent;
    Intent attendeeSignInIntent;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendee_sign_up);

        et_j_asu_fName = findViewById(R.id.et_v_asu_fName);
        et_j_asu_lName = findViewById(R.id.et_v_asu_lName);
        et_j_asu_uName = findViewById(R.id.et_v_asu_uName);
        et_j_asu_pass = findViewById(R.id.et_v_asu_pass);
        btn_j_asu_signUp = findViewById(R.id.btn_v_asu_signIn);
        btn_j_asu_home = findViewById(R.id.btn_v_asu_home);
        btn_j_asu_back = findViewById(R.id.btn_v_asu_back);

        eventSearchIntent = new Intent(AttendeeSignUp.this, EventSearch.class);
        mainActivityIntent = new Intent(AttendeeSignUp.this, MainActivity.class);
        attendeeSignInIntent = new Intent(AttendeeSignUp.this, AttendeeSignIn.class);

        dbHelper = new DatabaseHelper(this);

        SignUpButtonEventHandler();
        HomeButtonEventHandler();
        BackButtonEventHandler();
    }

    private void SignUpButtonEventHandler()
    {
        btn_j_asu_signUp.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Attendee newAttendee = new Attendee(et_j_asu_uName.getText().toString(),et_j_asu_fName.getText().toString(),et_j_asu_lName.getText().toString(),et_j_asu_pass.getText().toString());

                dbHelper.addNewAttendee(newAttendee);

                AppData.setCurAttendee(newAttendee);

                startActivity(eventSearchIntent);
            }
        });
    }

    private void HomeButtonEventHandler()
    {
        btn_j_asu_home.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(mainActivityIntent);
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