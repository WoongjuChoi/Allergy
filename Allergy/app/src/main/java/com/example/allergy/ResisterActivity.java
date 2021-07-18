package com.example.allergy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ResisterActivity extends AppCompatActivity {
    private String UserName, UserEmail, UserPwd;
    private EditText name, email, pwd, pwd_chk;
    private Button confirm, cancel, check;
    @Override
    protected void onCreate( Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resister_view);
        //값 찾기
        name = findViewById(R.id.resister_name);
        email = findViewById(R.id.resister_email);
        pwd = findViewById(R.id.resister_pwd);
        pwd_chk = findViewById(R.id.resister_pwd_chk);
        confirm = findViewById(R.id.confirm_button);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //값 저장
                UserName = name.getText().toString();
                UserEmail = email.getText().toString();
                UserPwd = pwd.getText().toString();
            }
        });
        cancel = findViewById(R.id.cancel_button);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        }

    }



