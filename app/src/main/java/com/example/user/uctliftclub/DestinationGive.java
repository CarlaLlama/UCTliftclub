package com.example.user.uctliftclub;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

/**
 * Created by user on 7/23/2016.
 */
public class DestinationGive extends Activity {

    public Button but1;

    public void where(){
        but1 = (Button)findViewById(R.id.button10);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent whereto = new Intent(DestinationGive.this, LeavingTimeGive.class);
                startActivity(whereto);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.destination_give);
        where();
    }

}
