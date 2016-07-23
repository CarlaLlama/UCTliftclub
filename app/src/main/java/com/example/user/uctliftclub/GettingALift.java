package com.example.user.uctliftclub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by alexandra on 2016/07/23.
 */
public class GettingALift extends Activity{

    public Button but1;

    public void setTime(){
        but1 = (Button)findViewById(R.id.button3);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent leaving = new Intent(GettingALift.this, MainActivity.class);
                startActivity(leaving);
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lift_leaving_time);
        setTime();
    }
}
