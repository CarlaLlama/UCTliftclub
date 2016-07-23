package com.example.user.uctliftclub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;

/**
 * Created by alexandra on 2016/07/23.
 */
public class SeatsGet extends Activity {
    Firebase ref;
    public Button but1;

    public void setTime(){
        but1 = (Button)findViewById(R.id.button3);
        EditText seats = (EditText)findViewById(R.id.editText10);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent leaving = new Intent(SeatsGet.this, MainActivity.class);
                startActivity(leaving);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.seats_get);
        ref = new Firebase("https://uctliftclub.firebaseio.com");
        setTime();
    }
}
