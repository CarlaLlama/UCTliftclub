package com.example.user.uctliftclub;

        import android.content.Intent;
        import android.os.Bundle;
        import android.app.Activity;
        import android.view.View;
        import android.widget.Button;

        import com.firebase.client.Firebase;

/**
 * Created by user on 7/23/2016.
 */
public class GiveOrGet extends Activity {
    Firebase ref;

    public Button but1;
    public Button but2;

    public void give(){
        final Bundle extras = getIntent().getExtras();
        but1 = (Button)findViewById(R.id.button);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent giving = new Intent(getBaseContext(), GivingALift.class);
                giving.putExtra("EXTRA_SESSION_ID", extras.getString("USER_NAME"));
                startActivity(giving);
            }
        });
    }
    public void get(){
        final Bundle extras = getIntent().getExtras();
        but2 = (Button)findViewById(R.id.button2);
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent getting = new Intent(getBaseContext(), GettingALift.class);
                getting.putExtra("EXTRA_SESSION_ID", extras.getString("USER_NAME"));
                startActivity(getting);
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.give_or_get);
        give();
        get();
    }

}