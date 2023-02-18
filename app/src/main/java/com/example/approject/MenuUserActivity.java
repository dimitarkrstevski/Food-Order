package com.example.approject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.database.Cursor;
import android.widget.Button;

public class MenuUserActivity extends AppCompatActivity {

    DBHelper DB;
    Button btnNapraviNaracka;
    Button burgers;
    Button pizza;
    Button drinks;
    Button notify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_user);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel chanel = new NotificationChannel("My Notification", "My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(chanel);
        }

        DB = new DBHelper(this);

        TextView textViewNazadUser = findViewById(R.id.textViewNazadUser);
        textViewNazadUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuUserActivity.this, UserActivity.class));
            }
        });

        btnNapraviNaracka = (Button)findViewById(R.id.btnNapraviNaracka);
        btnNapraviNaracka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuUserActivity.this, "Нарачката е успешно направена!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MenuUserActivity.this, UserActivity.class));
            }
        });

        burgers = (Button)findViewById(R.id.btnBurgers);
        burgers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuUserActivity.this, Userlist.class));
            }
        });

        pizza = (Button)findViewById(R.id.btnPizza);
        pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuUserActivity.this, Userlist2.class));
            }
        });

        drinks = (Button)findViewById(R.id.btnDrinks);
        drinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuUserActivity.this, Userlist3.class));
            }
        });

        notify = findViewById(R.id.btnNapraviNaracka);
        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MenuUserActivity.this, "My Notification");
                builder.setContentTitle("Нова Нарачка!");
                builder.setContentText("Во моментов е направена нова нарачка!");
                builder.setSmallIcon(R.drawable.ic_launcher_foreground);
                builder.setAutoCancel(true);
                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MenuUserActivity.this);
                managerCompat.notify(1,builder.build());
                startActivity(new Intent(MenuUserActivity.this, UserActivity.class));
            }
        });
    }
}