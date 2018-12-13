package com.cumucore.servicetutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MAINACTIVITY ****** ", "Thread id: "+ Thread.currentThread().getId() );

        Intent intent = new Intent(getApplicationContext(), MyService.class);
        startService(intent);
    }

}
