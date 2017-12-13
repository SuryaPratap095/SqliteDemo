package com.example.suryasolanki.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


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

        String Create_Contacts_table="CREATE TABLE " + TABLE_CONTACTS + " ( " +
                Key_Id + " INTEGER, " + Key_Name + " TEXT, " +
                Key_PHONE_NO + " TEXT )";

        sqLiteDatabase.execSQL(Create_Contacts_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        onCreate(sqLiteDatabase);
    }


    public void addContact(Contact contact){
       SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(Key_Name,contact.getName());
        values.put(Key_PHONE_NO,contact.getPhoneNumber());

        db.insert(TABLE_CONTACTS,null,values);
        db.close();
    }

    public Contact getContact(int id){

        return new Contact( );
    }

    public void deleteContact(int id){
        SQLiteDatabase db=this.getWritableDatabase();
        String new_id[]=new String[] {String.valueOf(id)};
        Log.d("DELETE","DELETING....");
//        String DELETE_QUERY="DELETE FROM  "+ TABLE_CONTACTS + " WHERE " + Key_Id + " = "+ id;
//        db.execSQL(DELETE_QUERY);

        db.delete(TABLE_CONTACTS,Key_Id + " = ? ",new_id);
        Log.d("DELETE","DELETED....");
        db.close();

    }

    public List<Contact> getAllContact(){
        List<Contact> contactList= new ArrayList<>();

        String SELECT_QUERY="SELECT * FROM "+ TABLE_CONTACTS;

        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(SELECT_QUERY,null);

        if(cursor.moveToFirst()){
            do{
                Contact contact=new Contact();
               // contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setPhoneNumber(cursor.getString(2));

                contactList.add(contact);
            }while(cursor.moveToNext());
        }
        return contactList;
    }

    public void deleteContact(){

    }
}
