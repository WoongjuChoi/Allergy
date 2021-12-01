package com.example.allergy;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {
    SharedPreferences.Editor prefEditor;
    SharedPreferences prefs;
    Button resister;
    private EditText ID, Password;
    @Override
    protected void onCreate( Bundle savedInstanceState){
        prefs = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        prefEditor = prefs.edit();;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_view);
        ID = findViewById(R.id.editTextID);
        Password = findViewById(R.id.editTextTextPassword);
        resister= findViewById(R.id.button2);
        resister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ResisterActivity.class);
                startActivity(intent);
            }
        });
        Button login = findViewById(R.id.button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 try {
                    String result;
                    String id, pwd;

                    id = ID.getText().toString();
                    pwd = Password.getText().toString();

                    Login task = new Login();
                    result = task.execute(id, pwd).get();
                    System.out.println(task.receiveMsg.substring(2,4));

                     if(task.receiveMsg.substring(2,4).equals("성공")) {
                        //여기에 로그인 성공 시 해야할 것 처리
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("login",1);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                         Snackbar.make(view, "로그인 성공", Snackbar.LENGTH_LONG).show();
                    } else if(task.receiveMsg.substring(2,4).equals("실패")) {
                        Snackbar.make(view, "로그인 실패", Snackbar.LENGTH_LONG).show();
                    } else {
                        Snackbar.make(view, "없는 아이디", Snackbar.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    Log.i("DBTest", "....ERROR....!");
                }
            }
        });

    }
}
