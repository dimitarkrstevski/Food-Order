package com.example.approject;


import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class Userlist extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList <String> question, answer1, answer2, answer3, answer4;
    DBHelper DB;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlist);

        DB = new DBHelper(this);
        question = new ArrayList<>();
        answer1 = new ArrayList<>();
        answer2 = new ArrayList<>();
        answer3 = new ArrayList<>();
        answer4 = new ArrayList<>();
        recyclerView = findViewById(R.id.recycleviewer);
        adapter = new MyAdapter(this, question, answer1, answer2, answer3, answer4);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();
    }
    private void displaydata()
    {
        Cursor cursor = DB.getdata();
        if(cursor.getCount()==0){
            Toast.makeText(this, "Нема записи!", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            while (cursor.moveToNext()){
                question.add(cursor.getString(1));
                answer1.add(cursor.getString(2));
                answer2.add(cursor.getString(3));
                answer3.add(cursor.getString(4));
                answer4.add(cursor.getString(5));
            }
        }
    }

}