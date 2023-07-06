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

public class BuyMedicinDetail_Activity extends AppCompatActivity {

    TextView tvPackageName, tvTotalCost;
    EditText edDetails;
    Button btnBack, btnAddToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicin_detail);

        tvPackageName = findViewById(R.id.txt_BMDPackages);
        edDetails = findViewById(R.id.edt_BMDTextMultiline);
        edDetails.setKeyListener(null);
        tvTotalCost = findViewById(R.id.txt_BMDTotalCost);
        btnBack = findViewById(R.id.btn_BMDBack);
        btnAddToCart = findViewById(R.id.btn_BMDAddCart);

        Intent intent = getIntent();
        tvPackageName.setText(intent.getStringExtra("name"));
        edDetails.setText(intent.getStringExtra("text2"));
        tvTotalCost.setText("Gia :" + intent.getStringExtra("text3") + "vnd");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicinDetail_Activity.this, BuyMedicin_Activity.class));
            }
        });
        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("share_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username", "").toString();
                String product = tvPackageName.getText().toString();
                float price = Float.parseFloat(intent.getStringExtra("text3").toString());

                Database db = new Database(getApplicationContext(), "healthcare", null, 1);

                if (db.checkCart(username, product) == 1) {
                    Toast.makeText(getApplicationContext(), "Product Alredy added", Toast.LENGTH_SHORT).show();
                } else {
                    db = new Database(getApplicationContext(), "healthcare", null, 1);
                    db.addCart(username, product, price, "medicine");
                    Toast.makeText(getApplicationContext(), "Record Inserted to cart", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(BuyMedicinDetail_Activity.this, BuyMedicin_Activity.class));
                }
            }
        });
    }
}