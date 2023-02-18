package com.example.approject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;
public class UserLocTime extends AppCompatActivity {

    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_loc_time);

        save = (Button)findViewById(R.id.btnZacuvajVremeNaracka);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserLocTime.this, UserActivity.class));
                Toast.makeText(UserLocTime.this, "Времето на подигање на нарачката е зачувано!", Toast.LENGTH_SHORT).show();
            }
        });
        TextView nazad = findViewById(R.id.textViewNazadLokacijaVreme);
        nazad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserLocTime.this, UserActivity.class));
            }
        });


    }
}