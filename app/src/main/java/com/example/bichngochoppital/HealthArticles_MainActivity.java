package com.example.bichngochoppital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class HealthArticles_MainActivity extends AppCompatActivity {

    private String[][] health_details = {
            {"Walking Daily", "", "", "", "Click More Deails"},
            {"Home care od COVID-19", "", "", "", "Click More Deails"},
            {"Stop Smoking", "", "", "", "Click More Details"},
            {"Menstrual Cramps", "", "", "", "Click More Details"},
            {"Healthy Gut", "", "", "", "Click More Details"}
    };
    private int[] image = {
            R.drawable.health1,
            R.drawable.health2,
            R.drawable.health3,
            R.drawable.health4,
            R.drawable.health5
    };
    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_articles_main);
        lst = findViewById(R.id.listView_HA);
        btnBack = findViewById(R.id.btn_HAtBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HealthArticles_MainActivity.this, Home_Activity.class));
            }
        });
        list = new ArrayList();
        for (int i = 0; i < health_details.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", health_details[i][0]);
            item.put("line2", health_details[i][1]);
            item.put("line3", health_details[i][2]);
            item.put("line4", health_details[i][3]);
            item.put("line5", health_details[i][4]);
            list.add(item);

        }
        sa = new SimpleAdapter(this, list,
                R.layout.activity_multi_line,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.txt_line_a, R.id.txt_line_b, R.id.txt_line_c, R.id.txt_line_d, R.id.txt_line_e});
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long i1) {
                Intent it = new Intent(HealthArticles_MainActivity.this, HealthArticlesDetail_Activity.class);
                it.putExtra("text1", health_details[i][0]);
                it.putExtra("text2", image[i]);
                startActivity(it);
            }
        });
    }


}