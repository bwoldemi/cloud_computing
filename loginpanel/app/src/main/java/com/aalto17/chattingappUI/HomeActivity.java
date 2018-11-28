package com.aalto17.chattingappUI;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;


import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayList<Contact> contacts = new ArrayList<>();

        contacts.add(new Contact("Jhon", "Let's got to school ", "image1"));
        contacts.add(new Contact("Mikko", "Hi how are u doing", "image1"));
        contacts.add(new Contact("Paula", "bye, see u soon ", "image1"));


        ListView listView =findViewById(R.id.list_of_contacts);

        listView.setAdapter(new ContactAdapter(contacts, getApplicationContext()));
    }
}
