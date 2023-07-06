package com.example.bichngochoppital;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class CartLab_Activity extends AppCompatActivity {
    HashMap<String, String> item;
    ArrayList list;
    ListView lst;
    SimpleAdapter sa;
    TextView tvTotal;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
    private Button dateButton, timeButton, btnCheckout, btnBack;
    private String[][] pakages = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_lab);

        dateButton = findViewById(R.id.btn_CartDatePicker);
        timeButton = findViewById(R.id.btn_CartTimePicker);
        Button btnCheckout = findViewById(R.id.btn_cartCheckout);
        btnBack = findViewById(R.id.btn_cartBack);
        tvTotal = findViewById(R.id.txt_CartTotalCost);
        lst = findViewById(R.id.listView_Cart);

        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "").toString();

        Database db = new Database(getApplicationContext(), "healthcare", null, 1);
        float totalAmout = 0;
        ArrayList dbData = db.getCartData(username, "lab");
        //Toast.makeText(getApplicationContext(),""+dbData,Toast.LENGTH_SHORT).show();

        pakages = new String[dbData.size()][];
        for (int i = 0; i < pakages.length; i++) {
            pakages[i] = new String[5];
        }
        for (int i = 0; i < dbData.size(); i++) {
            String arrData = dbData.get(i).toString();
            String[] strData = arrData.split(java.util.regex.Pattern.quote("$"));
            pakages[i][0] = strData[0];
            pakages[i][4] = "gia :" + strData[1] + "vnd";
            totalAmout = totalAmout + Float.parseFloat(strData[1]);
        }

        tvTotal.setText("total Cost : " + totalAmout);
        list = new ArrayList();
        for (int i = 0; i < pakages.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", pakages[i][0]);
            item.put("line2", pakages[i][1]);
            item.put("line3", pakages[i][2]);
            item.put("line4", pakages[i][3]);
            item.put("line5", pakages[i][4]);
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.activity_multi_line,
                new String[]{
                        "line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.txt_line_a, R.id.txt_line_b, R.id.txt_line_c, R.id.txt_line_d, R.id.txt_line_e});

        lst.setAdapter(sa);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartLab_Activity.this, LabTest_Activity.class));
            }
        });

        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(CartLab_Activity.this, LabTestBook_Activity.class);
                it.putExtra("price", tvTotal.getText());
                it.putExtra("date", dateButton.getText());
                it.putExtra("time", timeButton.getText());
                startActivity(it);
            }
        });
        initDatepicker();
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });
        //timepicker
        initTimePicker();
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog.show();
            }
        });
    }

    private void initDatepicker() {
    }

    private void initTimePicker() {
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int i, int i1) {
                timeButton.setText(i + ":" + i1);
            }
        };

    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int i, int i1, int i2) {
                i1 = i1 += 1;
                dateButton.setText(i2 + "/" + i1 + "/" + i);

            }
        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
    }
}