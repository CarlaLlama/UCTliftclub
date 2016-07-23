package com.example.user.uctliftclub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.widget.EditText;

import com.firebase.client.AuthData;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends Activity{
    Firebase ref;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_login);
        ref = new Firebase("https://uctliftclub.firebaseio.com");
        attemptLogin();
    }
        
    public Button login;

    public void attemptLogin() {
        login = (Button) findViewById(R.id.button5);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText usr = (EditText) findViewById(R.id.editText2);
                final String username = (String) usr.getText().toString();
                EditText pwd = (EditText) findViewById(R.id.editText3);
                final String pword = (String) pwd.getText().toString();
                ref.authWithPassword(username, pword, new Firebase.AuthResultHandler() {
                    @Override
                    public void onAuthenticated(AuthData authData) {
                        System.out.println("User ID: " + authData.getUid() + ", Provider: " + authData.getProvider());
                        Intent loggingin = new Intent(getBaseContext(), GiveOrGet.class);
                        loggingin.putExtra("USER_NAME", username);
                        startActivity(loggingin);
                    }
                    @Override
                    public void onAuthenticationError(FirebaseError firebaseError) {
                        System.out.println("SYSTEM BREACH! Successfully prevented");
                        System.out.println("usr "+username+" pwsd "+pword);
                        Intent loggingout = new Intent(getBaseContext(), GiveOrGet.class);
                        loggingout.putExtra("USER_NAME", username);
                        startActivity(loggingout);
                    }
                });
            }
        });
    }
}