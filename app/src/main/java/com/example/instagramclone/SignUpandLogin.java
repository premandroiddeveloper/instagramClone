package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpandLogin extends AppCompatActivity {
EditText ed1,ed2,ed3,ed1_2,ed2_2;
Button log,sign;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_upand_login);
        log=(Button)findViewById(R.id.login);
        sign=(Button)findViewById(R.id.signup);
        ed1=(EditText)findViewById(R.id.signupemail);
        ed2=(EditText)findViewById(R.id.signuppassword);
        ed3=(EditText)findViewById(R.id.username);
        ed1_2=(EditText)findViewById(R.id.loginemail);
        ed2_2=(EditText)findViewById(R.id.pass);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser p1=new ParseUser();
                p1.setUsername(ed3.getText().toString());
                p1.setPassword(ed2.getText().toString());
                p1.setEmail(ed1.getText().toString());
                p1.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if(e==null){
                            Toast.makeText(SignUpandLogin.this,"Now sign in fast ",Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logInInBackground(ed1_2.getText().toString(), ed2_2.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if(user!=null && e==null)
                            Toast.makeText(SignUpandLogin.this,"you Log in SuccessFully",Toast.LENGTH_SHORT).show();
                        Intent i2=new Intent(SignUpandLogin.this,WELCOMEACTIVITY.class);
                        i2.putExtra("name",user.getUsername());
                        startActivity(i2);
                    }
                });
            }
        });

    }
}