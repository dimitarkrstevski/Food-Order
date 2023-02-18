package com.example.approject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

public class VnesiPizzaActivity extends AppCompatActivity {

    EditText Prasanje2;
    EditText answer1, answer2, answer3, answer4;
    Button btnPrasanjaVneseni2;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vnesi_pizza);

        Prasanje2 = (EditText)findViewById(R.id.Prasanje2);
        answer1 = (EditText)findViewById(R.id.odgovor12);
        answer2 = (EditText)findViewById(R.id.odgovor22);
        answer3 = (EditText)findViewById(R.id.odgovor32);
        answer4 = (EditText)findViewById(R.id.odgovor42);
        btnPrasanjaVneseni2 = (Button) findViewById(R.id.btnPrasanjaVneseni2);
        DB = new DBHelper(this);


        btnPrasanjaVneseni2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Questions = Prasanje2.getText().toString();
                String ans1 = answer1.getText().toString();
                String ans2 = answer2.getText().toString();
                String ans3 = answer3.getText().toString();
                String ans4 = answer4.getText().toString();

                Boolean checkinsertdata = DB.insertData3(Questions, ans1, ans2, ans3, ans4);
                if (Questions.equals("") || ans1.equals("") || ans2.equals("") || ans3.equals("") || ans4.equals("")){
                    Toast.makeText(VnesiPizzaActivity.this, "Внесете Нова Понуди!", Toast.LENGTH_SHORT).show();
                }else{
                    if(checkinsertdata==true){
                        Toast.makeText(VnesiPizzaActivity.this, "Успешно Внесување!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MenuAdminActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(VnesiPizzaActivity.this, "Неуспешно Внесување!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}