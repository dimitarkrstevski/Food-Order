package com.example.approject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MenuAdminActivity extends AppCompatActivity {

    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_admin);


        TextView btn2 = findViewById(R.id.btnVnesiPrasanja);
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MenuAdminActivity.this, VnesiBurgeriActivity.class));
            }
        });

        TextView btn3 = findViewById(R.id.btnVnesiPrasanja2);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuAdminActivity.this, VnesiPizzaActivity.class));
            }
        });

        TextView btn4 = findViewById(R.id.btnSendNotifikacija);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuAdminActivity.this, VnesiDrinksActivity.class));
            }
        });

        TextView btn5 = findViewById(R.id.btnStartGlasanje);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuAdminActivity.this, "Успешно Ажурирано Мени", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), AdministratorActivity.class);
                startActivity(intent);
            }
        });


    }
}