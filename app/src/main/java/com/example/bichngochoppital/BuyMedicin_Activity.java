package com.example.bichngochoppital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicin_Activity extends AppCompatActivity {
    private String[][] pakage =

            {


            {"Uprise-D3 1000IU Capsule", "", "", "", "250.000"},
            {"HealthVit Chromium Picolinate 200mcg capsule", "", "", "", "30.000"},
            {"Vitamin B Complex Capsules", "", "", "", "350.000"},
            {"Inlife Vitamin E wheat Germ oil Capsule", "", "", "", "300.000"},
            {"Dolo 650 Advance Tablet", "", "", "", "300.000"},
                    {"Crocin 650 Advance Tablet","","","","230.000"},
                    {"Strepsils Medicated Lozenges for sore Throad","","","","340"},
                    {"Tata 1mg Calcium+ vitaminD3","","","","340"},
                    {"Feronia -XT Tablet","","","","560"}

            };
    private String[] pakage_details = {
            "Building and Keeping the bones & teeth strong\n" +
                    "Reducing Fatigue/stress and muscular pains \n" +
                    "Boosting immunity and increasing resistance against infection",
            "Chomium is an essential trace mineral that plays an important role in helping insulin regulat",
            "Provides relief from vitamin B deficiencies\n" +
                    "Helps in formation of red blood cells\n" +
                    "Maintain heathyl  nervous system",
            "It promotes heath as well as skin benefit.\n" +
                    "It help reduce skin blemish and pigmentation.\n" +
                    "it act as safeguard  the skin from the harsh UVA and UVB sun rays.",
            "Dolo 650 Tablet helps relieve pain and fever by blockung the release ad certain chemical mess" +
                    "Healps relieve fever and bring down a high temperature\n",
            "Suitable for people with a heart condition or high blood presure",
            "Relive the risk of a bacterial throat infection and soothes the recovery process\n" +
                    "Provides a warm and comforting feeling during sore throat",
            "Reduces the risk of calcium defciency,Rickkets,and Osteoporosis\n" +
                    "Promotes mobility and flexibility of joints",
            "Helps to reduce the iron deficiency due to chronic blood loss or low intake od rion"

    };
    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack, btnGotoCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicin);

        lst =findViewById(R.id.listViewBM);
        btnBack=findViewById(R.id.btn_BMBack);
        btnGotoCart=findViewById(R.id.btn_BMCart);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicin_Activity.this, Home_Activity.class));
            }
        });
        btnGotoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicin_Activity.this,CartBuyMedicine_Activity.class));
            }
        });
        list = new ArrayList();
        for (int i = 0; i < pakage.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", pakage[i][0]);
            item.put("line2", pakage[i][1]);
            item.put("line3", pakage[i][2]);
            item.put("line4", pakage[i][3]);
            item.put("line5", "Gia :" + pakage[i][4] + "vnd");
            list.add(item);
        }
        sa = new SimpleAdapter(this, list, R.layout.activity_multi_line,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.txt_line_a, R.id.txt_line_b, R.id.txt_line_c, R.id.txt_line_d, R.id.txt_line_e});
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent it= new Intent(BuyMedicin_Activity.this,BuyMedicinDetail_Activity.class);
                it.putExtra("text1",pakage[i][0]);
                it.putExtra("text2",pakage_details[i]);
                it.putExtra("text3",pakage[i][4]);
                startActivity(it);
            }
        });
    }

    }