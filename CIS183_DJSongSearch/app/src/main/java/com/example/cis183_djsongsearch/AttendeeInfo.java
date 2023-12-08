package com.example.cis183_djsongsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class AttendeeInfo extends AppCompatActivity
{
    EditText et_j_ai_fName;
    EditText et_j_ai_lName;
    TextView tv_v_ai_uName;
    EditText et_v_ai_pass;
    ImageButton btn_j_ai_update;
    ImageButton btn_j_ai_delete;
    Intent mainActivityIntent;
    Intent eventSearchIntent;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendee_info);

        et_j_ai_fName = findViewById(R.id.et_v_ai_fName);
        et_j_ai_lName = findViewById(R.id.et_v_ai_lName);
        et_v_ai_pass = findViewById(R.id.et_v_ai_pass);
        tv_v_ai_uName = findViewById(R.id.tv_v_ai_uName);
        btn_j_ai_update = findViewById(R.id.btn_v_ai_update);
        btn_j_ai_delete = findViewById(R.id.btn_v_ai_delete);

        mainActivityIntent = new Intent(AttendeeInfo.this, MainActivity.class);
        eventSearchIntent = new Intent(AttendeeInfo.this, EventSearch.class);

        dbHelper = new DatabaseHelper(this);

        et_j_ai_fName.setText(AppData.getCurAttendee().getFirstName());
        et_j_ai_lName.setText(AppData.getCurAttendee().getLastName());
        tv_v_ai_uName.setText(AppData.getCurAttendee().getUsername());
        et_v_ai_pass.setText(AppData.getCurAttendee().getPassword());

        UpdateButtonEventHandler();
        DeleteButtonEventHandler();
    }

    private void UpdateButtonEventHandler()
    {
        btn_j_ai_update.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Attendee updateAttendee = new Attendee(AppData.getCurAttendee().getUsername(), et_j_ai_fName.getText().toString(), et_j_ai_lName.getText().toString(), et_v_ai_pass.getText().toString());

                AppData.setCurAttendee(updateAttendee);

                dbHelper.updateAttendee(updateAttendee);

                startActivity(eventSearchIntent);
            }
        });
    }

    private void DeleteButtonEventHandler()
    {
        btn_j_ai_delete.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dbHelper.deleteAttendee(AppData.getCurAttendee().getUsername());

                startActivity(mainActivityIntent);
            }
        });
    }
}