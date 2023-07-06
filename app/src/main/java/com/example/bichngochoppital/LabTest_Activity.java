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

public class LabTest_Activity extends AppCompatActivity {
    private String[][] packages = {
            {
                    "package 1 : Full Body Checkup", "", "", "", "999"
            },
            {"Pakage 2 : Blood Glucose Fastin", "", "", "", "299"},
            {"Pakage 3 : Covid-19 Antibody - IgG", "", "", "", "899"},
            {"Pakage 4 : Thyroid Check", "", "", "", "499"},
            {"Pakage 5 : Immunity Check", "", "", "", "699"}
    };
    private String[] packages_detail =


            {
                    "Blood Glucose Fasting\n" + "Complete Hemogram\n" + "HbA1c\n" +
                            "Iron Studies\n" + "Kidney Funtion Test\n" + "LDH Lactate Dehydrogenase, Serum\n" +
                            "Lipid Profile\n" +
                            "Liver Funtion Test", "Blood Glucose Fasting",
                    "Covid-19 AntiBody- IgG",
                    "Thyroid Profile-Total( T3,T4 & TSH Ulstra-sensitive)",
                    "Complete Hemogram\n" + "CRP (C Reactive Protein) Quantitative, Serum \n" +
                            "Iron Studies\n" +
                            "Kidney Funtion Test\n" +
                            "Lipid Profile"
            };
    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnGotoCart, btnBack;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);
        btnGotoCart = findViewById(R.id.btn_LTCart);
        btnBack = findViewById(R.id.btn_LTBack);
        listView = findViewById(R.id.listViewLT);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabTest_Activity.this, Home_Activity.class));
            }
        });
        list = new ArrayList();
        for (int i = 0; i < packages.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Gia :" + packages[i][4] + "vnd");
            list.add(item);
        }
        sa = new SimpleAdapter(this, list, R.layout.activity_multi_line,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.txt_line_a, R.id.txt_line_b, R.id.txt_line_c, R.id.txt_line_d, R.id.txt_line_e});
        listView.setAdapter(sa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long i1) {
                Intent it = new Intent(LabTest_Activity.this, LabTestDetail_Activity.class);
                it.putExtra("text1", packages[i][0]);
                it.putExtra("text2", packages_detail[i]);
                it.putExtra("text3", packages[i][4]);
                startActivity(it);
            }
        });
        btnGotoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabTest_Activity.this, CartLab_Activity.class));
            }
        });
    }
}
