package com.example.user.uctliftclub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Map;

/**
 * Created by user on 7/23/2016.
 */
public class NewUserActivity extends Activity {
    Firebase ref; //Link to Firebase online database - used as place to store user data


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.new_user);
        ref = new Firebase("https://uctliftclub.firebaseio.com/Messages");
        attemptNewUser();
    }

    public Button login;

    public void attemptNewUser(){
        login = (Button)findViewById(R.id.button4);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText n = (EditText) findViewById(R.id.editText4);
                String name = (String) n.getText().toString();
                EditText s = (EditText) findViewById(R.id.editText5);
                String surname = (String) s.getText().toString();
                EditText st = (EditText) findViewById(R.id.editText6);
                final String studentno = (String) st.getText().toString();
                EditText pd = (EditText) findViewById(R.id.editText7);
                String pw = (String) st.getText().toString();
                EditText pc = (EditText) findViewById(R.id.editText8);
                String pwdc = (String) st.getText().toString();

                if (pw.equals(pwdc)) {
                    ref.createUser(studentno, pw, new Firebase.ValueResultHandler<Map<String, Object>>() {
                        @Override
                        public void onSuccess(Map<String, Object> result) {
                            System.out.println("Successfully created user account with uid: " + result.get("uid"));
                            Intent loggingin = new Intent(getBaseContext(), GiveOrGet.class);
                            loggingin.putExtra("USER_NAME", studentno);
                            startActivity(loggingin);
                        }

                        @Override
                        public void onError(FirebaseError firebaseError) {
                            Intent loggingin = new Intent(getBaseContext(), GiveOrGet.class);
                            loggingin.putExtra("USER_NAME", studentno);
                            startActivity(loggingin);
                        }
                    });
                }
            }
        });
    }
}


