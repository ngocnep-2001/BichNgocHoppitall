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

public class login_Activity extends AppCompatActivity {
    EditText edUsername, edPassword;
    Button btnlogin;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edPassword = findViewById(R.id.edt_password);
        edUsername = findViewById(R.id.edt_username);
        Database db = new Database(getApplicationContext(), "healthcare", null, 1);
        btnlogin = findViewById(R.id.btn_Login);
        tv = findViewById(R.id.tv_DangKi);

// xu li su kien btn_Login
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edUsername.getText().toString();
                String password = edPassword.getText().toString();
                if (username.length() == 0 || password.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Kiem tra thong tin", Toast.LENGTH_SHORT).show();
                } else {
                    if (db.login(username, password) == 1) {
                        Toast.makeText(getApplicationContext(), "Login Succes", Toast.LENGTH_SHORT).show();
                        // tao doi tuong luu nhe duoi dang key-value
                        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        // chinh sua doi tuong SharedPreferrenxes
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("username", username);
                        //luu data duoi dang key va value
                        editor.apply();
                        startActivity(new Intent(login_Activity.this, Home_Activity.class));
                    } else {
                        Toast.makeText(getApplicationContext(), "Invailid Username and Password", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login_Activity.this, Registration_Activity.class));
            }
        });
    }
}