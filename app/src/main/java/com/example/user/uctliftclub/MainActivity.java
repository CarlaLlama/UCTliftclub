package com.example.user.uctliftclub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Map;

public class MainActivity extends Activity implements View.OnClickListener {
    LoginActivity loginManager;

    public Button login;
    public Button newuser;

    public void gotoLogin(View v){
        Button login = (Button)v;
        Intent loggingin = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(loggingin);
    }

    public void gotoCreateUser(View v){
        Button newuser = (Button)v;
        Intent createuser = new Intent(MainActivity.this, NewUserActivity.class);
        startActivity(createuser);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Initialise login page
    }

    @Override
    public void onClick(View v) {

    }
}