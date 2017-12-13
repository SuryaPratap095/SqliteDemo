package com.example.suryasolanki.sqlitedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by surya.solanki on 12/13/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="Contacts_Manager";
    private static final String TABLE_CONTACTS="Contacts";

    private static final String Key_Id="id";
    private static final String Key_Name="name";
    private static final String Key_PHONE_NO="phone_number";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String Create_Contacts_table="CREATE TABLE" + TABLE_CONTACTS + "( " +
                Key_Id + " INTEGER, " + Key_Name + " TEXT, " +
                Key_PHONE_NO + " TEXT )";

        sqLiteDatabase.execSQL(Create_Contacts_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        onCreate(sqLiteDatabase);
    }
}
