package com.berekettut.recyclerviewtut;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> nameList = new ArrayList<>();
        nameList.add("image one ");
        nameList.add("image two ");
        nameList.add("image three ");




        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(new RecyclerViewAddapter(nameList));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
