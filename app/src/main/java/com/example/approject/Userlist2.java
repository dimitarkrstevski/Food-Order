package com.example.approject;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class Userlist2 extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList <String> question2, answer21, answer22, answer23, answer24;
    DBHelper DB;
    MyAdapter2 adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlist2);

        DB = new DBHelper(this);
        question2 = new ArrayList<>();
        answer21 = new ArrayList<>();
        answer22 = new ArrayList<>();
        answer23 = new ArrayList<>();
        answer24 = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerViewer2);
        adapter2 = new MyAdapter2(this, question2, answer21, answer22, answer23, answer24);
        recyclerView.setAdapter(adapter2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();
    }

    private void displaydata() {
        Cursor cursor = DB.getdata3();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "Нема записи!", Toast.LENGTH_SHORT).show();
            return;
        } else {
            while (cursor.moveToNext()) {
                question2.add(cursor.getString(1));
                answer21.add(cursor.getString(2));
                answer22.add(cursor.getString(3));
                answer23.add(cursor.getString(4));
                answer24.add(cursor.getString(5));

            }
        }
    }


}