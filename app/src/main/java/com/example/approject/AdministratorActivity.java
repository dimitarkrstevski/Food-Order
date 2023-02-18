package com.example.approject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class AdministratorActivity extends AppCompatActivity {

    Button notifyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel chanel = new NotificationChannel("My Notification", "My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(chanel);
        }

        notifyBtn = findViewById(R.id.btnRezultatiGlasanje);
        notifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // notification code
                NotificationCompat.Builder builder = new NotificationCompat.Builder(AdministratorActivity.this, "My Notification");
                builder.setContentTitle("S A L E !");
                builder.setContentText("10% попуст на сите артикли!");
                builder.setSmallIcon(R.drawable.ic_launcher_foreground);
                builder.setAutoCancel(true);
                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(AdministratorActivity.this);
                managerCompat.notify(1,builder.build());
            }
        });


        TextView btn = findViewById(R.id.btnNovoGlasanje);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(AdministratorActivity.this, MenuAdminActivity.class));
            }
        });






        TextView btn2 = findViewById(R.id.administratorLogOut);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdministratorActivity.this, LogInActivity.class));
            }
        });

    }
}