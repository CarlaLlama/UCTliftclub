package com.example.user.uctliftclub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import com.firebase.client.Firebase;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 7/23/2016.
 */
public class GivingALift extends Activity{
    Firebase ref;

    public Button but1;

    public void setTime(){
        final Bundle extras = getIntent().getExtras();
        but1 = (Button)findViewById(R.id.button3);
        final TimePicker t = (TimePicker)findViewById(R.id.timePicker);
        final TextView timel = (TextView)findViewById(R.id.textView30);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time = t.toString();
                Firebase usersRef = ref.child("users");
                Map<String, String> journey = new HashMap<String, String>();
                journey.put("User", extras.getString("USER_NAME"));
                journey.put("Time", time);
                journey.put("Timelapse", timel.toString());
                Map<String, Map<String, String>> users = new HashMap<String, Map<String, String>>();
                users.put("journey", journey);
                usersRef.setValue(users);
                Intent leaving = new Intent(GivingALift.this, MainActivity.class);
                leaving.putExtra("USER_NAME", extras.getString("USER_NAME"));
                leaving.putExtra("TIME", time);
                leaving.putExtra("TIMELAPSE", timel.toString());
                startActivity(leaving);
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.leaving_time_give);
        ref = new Firebase("https://uctliftclub.firebaseio.com");
        setTime();
    }

}
