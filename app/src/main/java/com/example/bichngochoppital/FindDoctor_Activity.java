package com.example.bichngochoppital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FindDoctor_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);
        CardView exit = findViewById(R.id.cardFDBack);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FindDoctor_Activity.this, Home_Activity.class));
            }
        });
        CardView familyphysician = findViewById(R.id.cardFDFamilyPhysician);
        familyphysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindDoctor_Activity.this, DoctorDetails_Activity.class);
                it.putExtra("title", "Family Physicians");
                startActivity(it);
            }
        });
        CardView cardiologists = findViewById(R.id.cardFDDietician);
        familyphysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindDoctor_Activity.this, DoctorDetails_Activity.class);
                it.putExtra("title", "Dietician");
                startActivity(it);
            }
        });
        CardView dietician = findViewById(R.id.cardFDDentist);
        familyphysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindDoctor_Activity.this, DoctorDetails_Activity.class);
                it.putExtra("title", "Dentist");
                startActivity(it);
            }
        });
        CardView dentist = findViewById(R.id.cardFDSurgeon);
        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindDoctor_Activity.this, DoctorDetails_Activity.class);
                it.putExtra("title", "Surgeon");
                startActivity(it);
            }
        });
        CardView surgeon = findViewById(R.id.cardFDCadiologists);
        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindDoctor_Activity.this, DoctorDetails_Activity.class);
                it.putExtra("title", "Cadiologists");
                startActivity(it);
            }
        });
    }
}