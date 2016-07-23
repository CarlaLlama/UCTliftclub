package com.example.user.uctliftclub;

import android.provider.BaseColumns;

/**
 * Created by joseph on 7/14/15.
 */
public interface Constants {
    public interface Socket{
        String ADD_USER = "User Name (student number):";
        String NEW_MESSAGE  = "Password: ";
        String URL = "http://chat.peruzal.co.za";
        String NEW_MESSAGE_RECEIVED = "za.co.peruzal.intent.NEW_MESSAGE_RECEIVED";
    }

    public interface Database {
        String DATABASE_NAME =  "chats.db";
        String TABLE_NAME = "chats";
        String COLUMN_ID = BaseColumns._ID;
        String COLUMN_USERNAME = "username";
        String COLUMN_MESSAGE = "message";
        String COLUMN_IS_SELF = "is_self";
        int DATABASE_VERSION = 1;
    }

    String USERNAME = "username";

}
