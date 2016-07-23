package com.example.user.uctliftclub;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

/**
 * Created by user on 7/23/2016.
 */
public class Stop extends Activity {

    public Button but1;

    public void willing(){
        but1 = (Button)findViewById(R.id.button13);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent stops = new Intent(Stop.this, ConfirmGive.class);
                startActivity(stops);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_stops_give);
        willing();
    }

}