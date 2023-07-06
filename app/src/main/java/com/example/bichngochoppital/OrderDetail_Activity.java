package com.example.bichngochoppital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.SimpleTimeZone;

public class OrderDetail_Activity extends AppCompatActivity {
    private String[][] order_details = {};
    ArrayList list;
    HashMap<String, String> item;
    ListView lst;
    Button btn;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        btn = findViewById(R.id.btn_ODtBack);
        lst = findViewById(R.id.listView_OD);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrderDetail_Activity.this, Home_Activity.class));
            }
        });
        Database db = new Database(getApplicationContext(), "healthcare", null, 1);
        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "").toString();
        ArrayList dbdata = db.getOrderData(username);

        order_details = new String[dbdata.size()][];
        for (int i = 0; i < order_details.length; i++) {
            order_details[i] = new String[5];
            String arrData = dbdata.get(i).toString();
            String[] strData = arrData.split(java.util.regex.Pattern.quote("$"));
            order_details[i][0] = strData[0];
            order_details[i][1] = strData[1];
            if (strData[7].compareTo("medicine") == 0) {
                order_details[i][3] = "Del" + strData[4];
            } else {
                order_details[i][3] = "Del" + strData[4] + " " + strData[5];
            }
            order_details[i][2] = "Rs." + strData[6];
            order_details[i][4] = strData[7];
        }
        list = new ArrayList();
        for (int i = 0; i < order_details.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", order_details[i][0]);
            item.put("line2", order_details[i][1]);
            item.put("line3", order_details[i][2]);
            item.put("line4", order_details[i][3]);
            item.put("line5", order_details[i][4]);
            list.add(item);
        }
        sa = new SimpleAdapter(this, list,
                R.layout.activity_multi_line,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.txt_line_a, R.id.txt_line_b, R.id.txt_line_c, R.id.txt_line_d, R.id.txt_line_e});
        lst.setAdapter(sa);
    }


}

