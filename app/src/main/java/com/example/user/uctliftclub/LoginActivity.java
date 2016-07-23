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
        ref = new Firebase("https://uctliftclub.firebaseio.com/Messages");
        attemptLogin();
    }
        
    public Button login;

    public void attemptLogin() {
        login = (Button) findViewById(R.id.button5);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText usr = (EditText) findViewById(R.id.editText2);
                String username = (String) usr.getText().toString();
                EditText pwd = (EditText) findViewById(R.id.editText3);
                String pword = (String) usr.getText().toString();
                ref.authWithPassword(username, pword, new Firebase.AuthResultHandler() {
                    public void onAuthenticated(AuthData authData) {
                        System.out.println("User ID: " + authData.getUid() + ", Provider: " + authData.getProvider());
                        Intent loggingin = new Intent(LoginActivity.this, GiveOrGet.class);
                        startActivity(loggingin);
                    }

                    public void onAuthenticationError(FirebaseError firebaseError) {
                        System.out.println("SYSTEM BREACH! Successfully prevented");
                        Intent loggingout = new Intent(LoginActivity.this, GiveOrGet.class);
                        startActivity(loggingout);
                }
            });
            }
        });
    }
}