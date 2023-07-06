package com.example.bichngochoppital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LabTestDetail_Activity extends AppCompatActivity {
    TextView tvPackageName, tvToTalCost;
    EditText edDetails;
    Button btnAddCart, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_detail);

        tvPackageName = findViewById(R.id.txt_LDPackages);
        tvToTalCost = findViewById(R.id.txt_LDTotalCost);
        edDetails = findViewById(R.id.edt_LDTextMultiline);
        btnAddCart = findViewById(R.id.btn_LDAddCart);
        btnBack = findViewById(R.id.btn_LDBack);

        edDetails.setKeyListener(null);
        Intent intent = getIntent();
        tvPackageName.setText(intent.getStringExtra("text1"));
        edDetails.setText(intent.getStringExtra("text2"));
        tvToTalCost.setText("Total Cost :" + intent.getStringExtra("text3") + "vnd");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabTestDetail_Activity.this, LabTest_Activity.class));
            }
        });
        btnAddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username", "").toString();
                String product = tvPackageName.getText().toString();
                float price = Float.parseFloat(intent.getStringExtra("text3").toString());

                Database db = new Database(getApplicationContext(), "healthcare", null, 1);
                if (db.checkCart(username, product) == 1) {
                    Toast.makeText(getApplicationContext(), "Sản phẩm đã được thêm", Toast.LENGTH_SHORT).show();
                } else {
                    db.addCart(username, product, price, "lab");
                    Toast.makeText(getApplicationContext(), "Record Insert tocart", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LabTestDetail_Activity.this, LabTest_Activity.class));
                }
            }
        });

    }
}