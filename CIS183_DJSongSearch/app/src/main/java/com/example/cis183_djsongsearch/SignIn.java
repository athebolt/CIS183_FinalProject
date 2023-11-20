package com.example.cis183_djsongsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignIn extends AppCompatActivity
{
    TextView tv_j_si_title;
    TextView tv_j_si_id;
    TextView tv_j_si_pass;
    EditText et_j_si_id;
    EditText et_j_si_pass;
    Button btn_j_si_signIn;
    Button btn_j_si_signUp;
    Button btn_j_si_back;
    Intent mainActivityIntent;
    Boolean isDj;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        tv_j_si_title = findViewById(R.id.tv_v_si_title);
        tv_j_si_id = findViewById(R.id.tv_v_si_id);
        tv_j_si_pass = findViewById(R.id.tv_v_si_pass);
        et_j_si_id = findViewById(R.id.et_v_si_id);
        et_j_si_pass = findViewById(R.id.et_v_si_pass);
        btn_j_si_signIn = findViewById(R.id.btn_v_si_signIn);
        btn_j_si_signUp = findViewById(R.id.btn_v_si_signUp);
        btn_j_si_back = findViewById(R.id.btn_v_si_back);

        Intent cameFrom = getIntent();

        isDj = (Boolean) cameFrom.getSerializableExtra("isDj");

        if(isDj)
        {
            tv_j_si_title.setText("DJ Sign in");
        }
        else
        {
            tv_j_si_title.setText("Attendee Sign in");
        }

        signInButtonEventHandler();
        signUpButtonEventHandler();
        backButtonEventHandler();
    }

    public void signInButtonEventHandler()
    {
        btn_j_si_signIn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });
    }

    public void signUpButtonEventHandler()
    {
        btn_j_si_signUp.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });
    }

    public void backButtonEventHandler()
    {
        btn_j_si_back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mainActivityIntent = new Intent(SignIn.this, MainActivity.class);

                startActivity(mainActivityIntent);
            }
        });
    }
}