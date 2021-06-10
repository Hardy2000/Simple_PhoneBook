package com.example.recyclesql;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;

public class FetchData extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<modelClass> dataholder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_data);
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Cursor cursor=new DBmanager(this).readdata();
        dataholder=new ArrayList<>();
        while(cursor.moveToNext())
        {
            modelClass obj= new modelClass(cursor.getString(1),cursor.getString(2),cursor.getString(3));
            dataholder.add(obj);

        }
         myAdapter adapter=new myAdapter(dataholder);
         recyclerView.setAdapter(adapter);


    }
}