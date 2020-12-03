package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseObject;
import com.parse.ParseUser;

public class WELCOMEACTIVITY extends AppCompatActivity {
TextView txtwelcome;
Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_w_e_l_c_o_m_e_a_c_t_i_v_i_t_y);
        txtwelcome=(TextView)findViewById(R.id.textView) ;
        b1=(Button)findViewById(R.id.button3);

        Bundle extras = getIntent().getExtras();
        String name=extras.getString("name");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.getCurrentUser().logOut();
                Toast.makeText(WELCOMEACTIVITY.this,"You Logged Out SuccessFully",Toast.LENGTH_LONG).show();
                finish();
            }
        });

        txtwelcome.setText("WELCOME "+name);
    }
}