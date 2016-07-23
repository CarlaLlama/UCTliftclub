package com.example.user.uctliftclub;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

/**
 * Created by user on 7/23/2016.
 */
public class LeavingTimeGive extends Activity {

    public Button but1;

    public void when(){
        but1 = (Button)findViewById(R.id.button11);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent whengo = new Intent(LeavingTimeGive.this, PassengerGive.class);
                startActivity(whengo);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leaving_time_give);
        when();
    }

}