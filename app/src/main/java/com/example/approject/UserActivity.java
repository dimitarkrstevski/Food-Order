package com.example.approject;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.database.Cursor;
import java.util.ArrayList;
import android.widget.Button;

public class UserActivity extends AppCompatActivity {
    DBHelper DB;
    Button location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        DB = new DBHelper(this);



        TextView btn2 = findViewById(R.id.korisnikLogout);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserActivity.this, LogInActivity.class));
            }
        });

        //Glasanje 1 so UserList
        TextView btn3 = findViewById(R.id.buttonGlasanjeUser);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserActivity.this, MenuUserActivity.class ));
            }
        });

        // Glasanje 2 so UserList 2
        TextView btn4 = findViewById(R.id.buttonGlasanjeUser2);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(UserActivity.this, Userlist2.class));

                startActivity(new Intent(UserActivity.this, UserLocTime.class));
            }
        });









    }
}