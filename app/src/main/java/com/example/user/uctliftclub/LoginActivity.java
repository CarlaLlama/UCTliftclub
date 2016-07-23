package com.example.user.uctliftclub;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity {
    Firebase myFirebaseRef; //Link to Firebase online database - used as place to send and receive messages from

    //Constructor to connect to database
    LoginActivity(String firebaseURL){
        myFirebaseRef = new Firebase(firebaseURL);
        startReceivingMessages();
    }

    //Method to update database with a new message entry
    protected void sendMessage(String userName,String message){
        //Map used so the message entry contains two bits of information
        // - the user the sent the message and - the message itself
        Map<String, String> post = new HashMap<String, String>();
        post.put("User", userName); //The key is "User" and the value is the actual username
        post.put("Message", message); //Key is "Message" and value is actual message

        //Make new entry in database - set the value of the new entry to the hashmap object
        myFirebaseRef.push().setValue(post);

    }

    //Method to add the neccessary event listeners to catch any new message entries on the database
    protected void startReceivingMessages(){

        //Add event listener on database
        myFirebaseRef.addChildEventListener(new ChildEventListener() {

            // Retrieve new posts as they are added to the database - NB!!!
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {
                Map<String, String> post = snapshot.getValue(Map.class); //Get the Map object that was written
                System.out.println("Message is :" + post.get("Message"));
                MainActivity.receiveMessage(post.get("User") + ">> " + post.get("Message"));

            }

            //METHODS NEEDED TO BE IMPLEMENTED FOR EVENT LISTENER - MUST BE ADDED TO

            // Get the data on a post that has changed
            @Override
            public void onChildChanged(DataSnapshot snapshot, String previousChildKey) {
            }

            // Get the data on a post that has been removed
            @Override
            public void onChildRemoved(DataSnapshot snapshot) {
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }

        });

    }
}