package com.example.bichngochoppital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HealthArticlesDetail_Activity extends AppCompatActivity {
    TextView tv1;
    ImageView img;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_articles_detail);
        btnBack = findViewById(R.id.btn_HADBack);
        tv1 = findViewById(R.id.txt_HADtitle);
        img = findViewById(R.id.HADimageView);

        Intent intent = getIntent();
        tv1.setText(intent.getStringExtra("text1"));

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int resId = bundle.getInt("text2");
            img.setImageResource(resId);
        }
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HealthArticlesDetail_Activity.this, HealthArticles_MainActivity.class));
            }
        });

    }
}