package com.example.user.uctliftclub;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

/**
 * Created by user on 7/23/2016.
 */
public class COnfirmGive extends Activity {

    public Button but1;

    public void done(){
        but1 = (Button)findViewById(R.id.button14);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent doneall = new Intent(COnfirmGive.this, MainActivity.class);
                startActivity(doneall);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_give);
        done();
    }

}
