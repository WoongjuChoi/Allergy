package com.example.allergy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class ResisterActivity extends AppCompatActivity {
    UserInfoManager infoManager = new UserInfoManager();
    private String UserName, UserEmail, UserPwd;
    private EditText name, email, pwd, pwd_chk,brm;
    private Button confirm, cancel, check;
    private boolean pwd_checked = false;
    private boolean email_checked = false;
    private int business_registration_num;
    @Override
    protected void onCreate( Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resister_view);
        //값 찾기
        SharedPreferences sf = getSharedPreferences("sFile",MODE_PRIVATE);
        name = findViewById(R.id.resister_name);
        email = findViewById(R.id.resister_email);
        pwd = findViewById(R.id.resister_pwd);
        pwd_chk = findViewById(R.id.resister_pwd_chk);
        confirm = findViewById(R.id.confirm_button);
        brm = findViewById(R.id.business_registration_number);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //값 저장
                if(pwd.getText().toString().equals(pwd_chk.getText().toString())) {
                    UserName = name.getText().toString();
                    UserEmail = email.getText().toString();
                    UserPwd = pwd.getText().toString();
                    infoManager.putUserInfo(UserEmail,UserPwd);
                    business_registration_num = Integer.parseInt(brm.getText().toString());
                    Snackbar.make(v, "회원가입 완료.", Snackbar.LENGTH_LONG).show();
                } else {
                    Snackbar.make(v, "비밀번호가 다릅니다.", Snackbar.LENGTH_LONG).show();
                }
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



