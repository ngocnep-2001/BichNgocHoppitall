package com.example.bichngochoppital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Home_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("user name", "").toString();
        Toast.makeText(getApplicationContext(), "WellCome" + username, Toast.LENGTH_SHORT).show();
        CardView exit = findViewById(R.id.cardExit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(Home_Activity.this, FindDoctor_Activity.class));
            }
        });
        CardView findDoctor = findViewById(R.id.cardFindDoctor);
        findDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Activity.this, FindDoctor_Activity.class));
            }
        });
        CardView labTest = findViewById(R.id.cardLabTest);
        labTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Activity.this, LabTest_Activity.class));
            }
        });
        CardView orderDeitails = findViewById(R.id.cardOderDetail);
        orderDeitails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Activity.this,OrderDetail_Activity.class));
            }
        });
        CardView buyMedicine =findViewById(R.id.cardBuyMeCine);
        buyMedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Home_Activity.this,BuyMedicin_Activity.class));
            }
        });
       CardView health=findViewById(R.id.cardHealthDoctor);
       health.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(Home_Activity.this,HealthArticles_MainActivity.class));
           }
       });
    }
}
