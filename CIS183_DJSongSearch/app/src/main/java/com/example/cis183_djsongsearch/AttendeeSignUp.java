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

public class AttendeeSignUp extends AppCompatActivity
{
    TextView tv_j_asu_error;
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
    ArrayList<Attendee> listOfAttendees;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendee_sign_up);

        tv_j_asu_error = findViewById(R.id.tv_v_asu_error);
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

        listOfAttendees = dbHelper.getAllAttendees();

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
                if(!et_j_asu_uName.getText().toString().equals("") && !et_j_asu_fName.getText().toString().equals("") && !et_j_asu_lName.getText().toString().equals("") && !et_j_asu_pass.getText().toString().equals(""))
                {
                    for(int i = 0; i < listOfAttendees.size(); i++)
                    {
                        if(listOfAttendees.get(i).getUsername().equals(et_j_asu_uName.getText().toString()))
                        {
                            tv_j_asu_error.setText("Username already exists.");

                            tv_j_asu_error.setVisibility(View.VISIBLE);

                            return;
                        }
                    }

                    Attendee newAttendee = new Attendee(et_j_asu_uName.getText().toString(),et_j_asu_fName.getText().toString(),et_j_asu_lName.getText().toString(),et_j_asu_pass.getText().toString());

                    dbHelper.addNewAttendee(newAttendee);

                    AppData.setCurAttendee(newAttendee);

                    startActivity(eventSearchIntent);
                }
                else
                {
                    tv_j_asu_error.setText("Please fill all fields.");

                    tv_j_asu_error.setVisibility(View.VISIBLE);
                }
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