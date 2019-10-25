package com.example.vaccinate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Adapter;

import java.sql.Array;
import java.sql.SQLData;
import java.util.ArrayList;
import java.util.Arrays;

public class parents_homepage extends AppCompatActivity{

    String arr[] = {"Child1","child2","child3","child4","child5","child6","child7"};
    RecyclerView recyclerView;
    ArrayList<String> list = new ArrayList<String>(Arrays.asList(arr));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parents_homepage);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new parentHomepageAdapter(arr));
    }

    /*public void readData()
    {
        login_db mydb = new login_db(this);
        SQLiteDatabase db = mydb.getReadableDatabase();
        String projection[] = {"FirstName","LastName"};
        Cursor cursor = mydb.readParent(db,"login",projection);
        while(cursor.moveToNext())
        {
            String fname = cursor.getString(cursor.getColumnIndex(projection[0]));
            String lname = cursor.getString(cursor.getColumnIndex(projection[1]));
            list.add(fname+" "+lname);
        }
        //recyclerView.setAdapter(new parentHomepageAdapter((String[]) list.toArray()));
    }*/
}
