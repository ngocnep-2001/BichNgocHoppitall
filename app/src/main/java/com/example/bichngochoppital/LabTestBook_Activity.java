package com.example.bichngochoppital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LabTestBook_Activity extends AppCompatActivity {
    EditText edname, edaddress, edcontact, edpincode;
    Button btnBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_book);
        edname = findViewById(R.id.edt_LBTFullName);
        edaddress = findViewById(R.id.edt_LBTAddress);
        edcontact = findViewById(R.id.edt_LBTContactNumber);
        edpincode = findViewById(R.id.edt_LBTPincode);
        btnBooking = findViewById(R.id.btn_LBTBooking);

        Intent intent = getIntent();
        String[] price = intent.getStringExtra("price").toString().split(java.util.regex.Pattern.quote(":"));
        String date = intent.getStringExtra("date");
        String time = intent.getStringExtra("time");

        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_pref", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username", "").toString();
                Database db = new Database(getApplicationContext(), "heathcare", null, 1);
                db.addOrder(username, edname.getText().toString(), edaddress.getText().toString(), edcontact.getText().toString(), Integer.parseInt(edpincode.getText().toString()), date.toString(), time.toString(), Float.parseFloat(price[1].toString()), "lab");
                db.removeCart(username, "lab");
                Toast.makeText(getApplicationContext(), "your booking is done successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LabTestBook_Activity.this, Home_Activity.class));
            }
        });

    }
}