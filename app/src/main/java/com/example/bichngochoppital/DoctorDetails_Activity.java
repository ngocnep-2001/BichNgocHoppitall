package com.example.bichngochoppital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetails_Activity extends AppCompatActivity {
    private String[][] doctor_details1 = {
            {"Ten Bac Si : Dao Vu Lam", "Dia Chi Benh Vien: Nhi Trung Uong", "Kinh Nghiem: 5 nam", "So dien thoai:0886975992", "250.000"},
            {"Ten Bac Si : Nguyen Van A", "Dia Chi Benh Vien: Nhi Trung Uong", "Kinh Nghiem: 10 nam", "So dien thoai:0886975992", "300.000"},
            {"Ten Bac Si : Tran Van C", "Dia Chi Benh Vien: Nhi Trung Uong", "Kinh Nghiem: 15 nam", "So dien thoai:0886975992", "350.000"},
            {"Ten Bac Si : Nguyen Huu B", "Dia Chi Benh Vien: Nhi Trung Uong", "Kinh Nghiem: 12 nam", "So dien thoai:0886975992", "300.000"},
            {"Ten Bac Si : Ho Viet Anh", "Dia Chi Benh Vien: Nhi Trung Uong", "Kinh Nghiem: 9 nam", "So dien thoai:0886975992", "300.000"},
    };
    private String[][] doctor_details2 = {
            {"Ten Bac Si : Dao Vu Lam", "Dia Chi Benh Vien: Nhi Trung Uong", "Kinh Nghiem: 5 nam", "So dien thoai:0886975992", "250.000"},
            {"Ten Bac Si : Nguyen Van A", "Dia Chi Benh Vien: Nhi Trung Uong", "Kinh Nghiem: 10 nam", "So dien thoai:0886975992", "300.000"},
            {"Ten Bac Si : Tran Van C", "Dia Chi Benh Vien: Nhi Trung Uong", "Kinh Nghiem: 15 nam", "So dien thoai:0886975992", "350.000"},
            {"Ten Bac Si : Nguyen Huu B", "Dia Chi Benh Vien: Nhi Trung Uong", "Kinh Nghiem: 12 nam", "So dien thoai:0886975992", "300.000"},
            {"Ten Bac Si : Ho Viet Anh", "Dia Chi Benh Vien: Nhi Trung Uong", "Kinh Nghiem: 9 nam", "So dien thoai:0886975992", "300.000"},
    };
    private String[][] doctor_details3 = {
            {"Ten Bac Si : Dao Vu Lam", "Dia Chi Benh Vien: Nhi Trung Uong", "Kinh Nghiem: 5 nam", "So dien thoai:0886975992", "250.000"},
            {"Ten Bac Si : Nguyen Van A", "Dia Chi Benh Vien: Nhi Trung Uong", "Kinh Nghiem: 10 nam", "So dien thoai:0886975992", "300.000"},
            {"Ten Bac Si : Tran Van C", "Dia Chi Benh Vien: Nhi Trung Uong", "Kinh Nghiem: 15 nam", "So dien thoai:0886975992", "350.000"},
            {"Ten Bac Si : Nguyen Huu B", "Dia Chi Benh Vien: Nhi Trung Uong", "Kinh Nghiem: 12 nam", "So dien thoai:0886975992", "300.000"},
            {"Ten Bac Si : Ho Viet Anh", "Dia Chi Benh Vien: Nhi Trung Uong", "Kinh Nghiem: 9 nam", "So dien thoai:0886975992", "300.000"},
    };
    private String[][] doctor_details4 = {
            {"Ten Bac Si : Dao Vu Lam", "Dia Chi Benh Vien: Nhi Trung Uong", "Kinh Nghiem: 5 nam", "So dien thoai:0886975992", "250.000"},
            {"Ten Bac Si : Nguyen Van A", "Dia Chi Benh Vien: Nhi Trung Uong", "Kinh Nghiem: 10 nam", "So dien thoai:0886975992", "300.000"},
            {"Ten Bac Si : Tran Van C", "Dia Chi Benh Vien: Nhi Trung Uong", "Kinh Nghiem: 15 nam", "So dien thoai:0886975992", "350.000"},
            {"Ten Bac Si : Nguyen Huu B", "Dia Chi Benh Vien: Nhi Trung Uong", "Kinh Nghiem: 12 nam", "So dien thoai:0886975992", "300 Vnd"},
            {"Ten Bac Si : Ho Viet Anh", "Dia Chi Benh Vien: Nhi Trung Uong", "Kinh Nghiem: 9 nam", "So dien thoai:0886975992", "300 Vnd"},
    };
    private String[][] doctor_details5 = {
            {"Ten Bac Si : Dao Vu Lam", "Dia Chi Benh Vien: Nhi Trung Uong", "Kinh Nghiem: 5 nam", "So dien thoai:0886975992", "250.000"},
            {"Ten Bac Si : Nguyen Van A", "Dia Chi Benh Vien: Nhi Trung Uong", "Kinh Nghiem: 10 nam", "So dien thoai:0886975992", "300.000"},
            {"Ten Bac Si : Tran Van C", "Dia Chi Benh Vien: Nhi Trung Uong", "Kinh Nghiem: 15 nam", "So dien thoai:0886975992", "350.000"},
            {"Ten Bac Si : Nguyen Huu B", "Dia Chi Benh Vien: Nhi Trung Uong", "Kinh Nghiem: 12 nam", "So dien thoai:0886975992", "300.000"},
            {"Ten Bac Si : Ho Viet Anh", "Dia Chi Benh Vien: Nhi Trung Uong", "Kinh Nghiem: 9 nam", "So dien thoai:0886975992", "300.000"},
    };
    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        tv = findViewById(R.id.txt_DDTitle);
        btn = findViewById(R.id.DDBack);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("Family Physicians") == 0)
            doctor_details = doctor_details1;
        else if (title.compareTo("Dietician") == 0)
            doctor_details = doctor_details2;
        else if (title.compareTo("Dentist") == 0)
            doctor_details = doctor_details3;
        else if (title.compareTo("Surgeon") == 0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetails_Activity.this, FindDoctor_Activity.class));
            }
        });
        list = new ArrayList();
        for (int i = 0; i < doctor_details.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Giá" + doctor_details[i][4] + "vnd");
            list.add(item);

        }
        sa = new SimpleAdapter(this, list,
                R.layout.activity_multi_line,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.txt_line_a, R.id.txt_line_b, R.id.txt_line_c, R.id.txt_line_d, R.id.txt_line_e}
        );
        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent it = new Intent(DoctorDetails_Activity.this, BookAppointment_Activity.class);
                it.putExtra("text1", title);
                it.putExtra("text2", doctor_details[i][0]);
                it.putExtra("text3", doctor_details[i][1]);
                it.putExtra("text4", doctor_details[i][3]);
                it.putExtra("text5", doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}