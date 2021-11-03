package com.example.allergy;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Login extends AsyncTask<String, Void, String> {
    String sendMsg, receiveMsg;
    @Override
    protected String doInBackground(String... strings) {
        try {
            String str;

            URL url = new URL("http://192.168.68.113:8080/AllergyLogin/androidDB.jsp"); //접속할 서버 주소

            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestMethod("POST"); //POST 로 데이터 전송
            OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());

            sendMsg = "id=" + strings[0] + "&pw=" + strings[1]; //전송할 데이터

            osw.write(sendMsg); //데이터 전송
            osw.flush(); //버퍼에 남아있는 모든 데이터 전송

            if(conn.getResponseCode() == conn.HTTP_OK) { //통신 성공 시 서버에서 데이터를 받음
                InputStreamReader tmp = new InputStreamReader(conn.getInputStream(), "UTF-8");
                BufferedReader reader = new BufferedReader(tmp);
                StringBuffer buffer = new StringBuffer();

                while ((str = reader.readLine()) != null) { //데이터 수신
                    buffer.append(str);
                }
                receiveMsg = buffer.toString(); //수신한 데이터를 문자열로 변환

            } else { //통신 실패 시
                Log.i("통신 결과", conn.getResponseMessage() + "에러");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return receiveMsg;
    }
}
