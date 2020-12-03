package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class MainActivity extends AppCompatActivity {
Button b1,b2;
EditText edname,edrate,edrun,edfour;
TextView tq;
String objId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ParseObject p1 = new ParseObject("Coder");

        edname = (EditText) findViewById(R.id.editTextTextPersonName);
        edrate = (EditText) findViewById(R.id.editTextTextPersonName2);
        edrun = (EditText) findViewById(R.id.editTextTextPersonName3);
        edfour = (EditText) findViewById(R.id.editTextTextPersonName4);
        b1 = (Button) findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2) ;
        tq=(TextView)findViewById(R.id.textView2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                final ParseObject p1=new ParseObject("Cricket");

                p1.put("nameoftheplayer",edname.getText().toString().trim());
                p1.put("totallStrikeRate",edrate.getText().toString().trim());
                p1.put("totallRun",Integer.parseInt(edrun.getText().toString().trim()));
                p1.put("TotallBoundry",Integer.parseInt(edrun.getText().toString().trim()));
                p1.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if(e == null){
                            Toast.makeText(MainActivity.this,"data is save SuccessFully",Toast.LENGTH_SHORT).show();
                            ParseQuery<ParseObject> parseQuery=ParseQuery.getQuery("Cricket");

                            String objId = p1.getObjectId();
                            parseQuery.getInBackground(objId, new GetCallback<ParseObject>() {
                                @Override
                                public void done(ParseObject object, ParseException e) {
                                    if(object!=null && e==null){
                                        tq.setText(object.get("nameoftheplayer")+"\n"+"StrikeRate: "+object.get("totallStrikeRate")+"\n");
                                    }
                                    else{
                                        tq.setText("sorry");
                                    }
                                }
                            });

                        }
                        else{
                            Toast.makeText(MainActivity.this,"Error Occures", Toast.LENGTH_SHORT).show();
                        }


                    }
                });
            }
                catch (Exception e){
                    Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                }
        }});
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(MainActivity.this,SignUpandLogin.class);
                startActivity(i1);
            }
        });
    }
}