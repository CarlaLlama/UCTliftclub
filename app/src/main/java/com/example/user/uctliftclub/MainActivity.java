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

public class MainActivity extends Activity {
    LoginActivity loginManager;
    EditText messageBox;
    Button submitButton;
    protected static TextView messageDisplay;

    public Button login;
    public Button newuser;

    public void gotoLogin(){
        login = (Button)findViewById(R.id.button);
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent loggingin = new Intent(MainActivity.this, LoginActivity.class);
            }
        });
    }

    public void gotoCreateUser(){
        newuser = (Button)findViewById(R.id.button);
        newuser.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent createuser = new Intent(MainActivity.this, NewUserActivity.class);
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);

        //Initialise login page
        loginManager = new LoginActivity("https://uctliftclub.firebaseio.com/");
        gotoLogin();
        gotoCreateUser();

    }



    //Method to send Messages based off what is written the text box
    private void sendMessage(){
        //NB -- "User" is temp holder name - user needs to choose what username he wants
        //Get text from the message box and send to the chat manager to sort out
        loginManager.sendMessage("User", messageBox.getText().toString());
        messageBox.setText(""); // Reset Text box to null
    }

    //Method to allow changes to the message display - Allows Chat Manager to change layout element
    protected static void receiveMessage(String newMessage){
        //Add to message on a new line to what is already being displayed
        messageDisplay.setText(messageDisplay.getText().toString() + newMessage + "\r\n");
    }

}