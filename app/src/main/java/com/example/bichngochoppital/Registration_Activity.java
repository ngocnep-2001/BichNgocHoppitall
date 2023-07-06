package com.example.bichngochoppital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registration_Activity extends AppCompatActivity {
    EditText edUsename, edEmail, edPassword, eduConfirm;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        edUsename = findViewById(R.id.edt_Reusername);
        edPassword = findViewById(R.id.edt_Repassword);
        edEmail = findViewById(R.id.edt_email);
        eduConfirm = findViewById(R.id.edt_Cfpassword2);
        tv = findViewById(R.id.tv_DangKi);
        btn = findViewById(R.id.btn_Dangki);

// xu li su kien khac da co tai khoan
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registration_Activity.this, login_Activity.class));
            }
        });
// xu li su kien btn_dangki
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edUsename.getText().toString();
                String email = edEmail.getText().toString();
                String password = edPassword.getText().toString();
                String confirm = eduConfirm.getText().toString();
                Database db = new Database(getApplicationContext(), "healthcare", null, 1);
                if (username.length() == 0 || password.length() == 0 || email.length() == 0 || confirm.length() == 0) {

                } else {
                    if (password.compareTo(confirm) == 0)
                        if (isValid(password)) {
                            db.register(username, email, password);
                            Toast.makeText(getApplicationContext(), "record Insert", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Registration_Activity.this, login_Activity.class));
                        } else {
                            Toast.makeText(getApplicationContext(), "Password dang sai", Toast.LENGTH_SHORT).show();
                        }
                    else {
                        Toast.makeText(getApplicationContext(), "password dang khong giong nhau", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });
    }

    public static boolean isValid(String passwordhere) {
        int f1 = 0, f2 = 0, f3 = 0;
        if (passwordhere.length() < 9) {
            return false;
        } else {
            for (int p = 0; p < passwordhere.length(); p++) {
                if (Character.isLetter(passwordhere.charAt(p))) {
                    f1 = 1;
                }
            }
            for (int r = 0; r < passwordhere.length(); r++) {
                if (Character.isDigit(passwordhere.charAt(r))) {
                    f2 = 1;
                }
            }
            for (int s = 0; s < passwordhere.length(); s++) {
                char c = passwordhere.charAt(s);
                if (c >= 33 && c <= 46 || c == 64) {
                    f3 = 1;
                }
            }
            if (f1 == 1 && f2 == 1 && f3 == 1)
                return true;
            return false;
        }
    }
}