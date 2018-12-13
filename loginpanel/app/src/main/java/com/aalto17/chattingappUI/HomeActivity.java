package com.aalto17.chattingappUI;


import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toolbar;


import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar= getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_launcher_background);

       actionBar.setTitle("");


        ArrayList<Contact> contacts = new ArrayList<>();

        contacts.add(new Contact("Jhon", "Let's got to school ", "image1"));
        contacts.add(new Contact("Mikko", "Hi how are u doing", "image1"));
        contacts.add(new Contact("Paula", "bye, see u soon ", "image1"));


       ListView listView =findViewById(R.id.list_of_contacts);

       listView.setAdapter(new ContactAdapter(contacts, getApplicationContext()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tab_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.settings){
            Intent intent = new Intent(this, MySettings.class);
            startActivity(intent);


        }
        return true; }
}
