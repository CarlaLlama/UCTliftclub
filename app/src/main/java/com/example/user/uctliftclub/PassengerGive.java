package com.example.user.uctliftclub;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

/**
 * Created by user on 7/23/2016.
 */
public class PassengerGive extends Activity {

    public Button but1;

    public void howmany(){
        but1 = (Button)findViewById(R.id.button12);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent howmuch = new Intent(PassengerGive.this, Stop.class);
                startActivity(howmuch);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.passenger_give);
        howmany();
    }

}