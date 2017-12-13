package com.example.suryasolanki.sqlitedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db=new DatabaseHandler(this);

        db.deleteContact(0);

        Log.d("Insert: ", "Inserting....");

        db.addContact(new Contact("Surya Pratap","9929856749"));
        db.addContact(new Contact("Ravi Saraswat","8952979627"));
        db.addContact(new Contact("Rishabh Rana","9166626970"));
        db.addContact(new Contact("Shashank Gupta","99501994492"));



        Log.d("Reading", "Reading Data...");

        List<Contact> contacts=db.getAllContact();

        for(Contact cn:contacts){
            String log="ID: "+ cn.getId() + " Name: " + cn.getName() + " Phone: " + cn.getPhoneNumber();

            Log.d("Name: ", log);
        }

    }
}
