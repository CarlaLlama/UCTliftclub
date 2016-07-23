package com.example.user.uctliftclub;

        import android.content.Intent;
        import android.os.Bundle;
        import android.app.Activity;
        import android.view.View;
        import android.widget.Button;

/**
 * Created by user on 7/23/2016.
 */
public class GiveOrGet extends Activity {

    public Button but1;
    public Button but2;

    public void give(){
        but1 = (Button)findViewById(R.id.button);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent giving = new Intent(GiveOrGet.this, GivingALift.class);
                startActivity(giving);
            }
        });
    }
    public void get(){
        but2 = (Button)findViewById(R.id.button2);
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent getting = new Intent(GiveOrGet.this, GettingALift.class);
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