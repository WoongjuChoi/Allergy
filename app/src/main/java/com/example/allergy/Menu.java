package com.example.allergy;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.Buffer;

public class Menu extends AsyncTask<String, Void, String> {
    StringBuffer buffer = new StringBuffer();
    String sendMsg;

    @Override
    protected String doInBackground(String... strings) {
        String str;
        String get_json = "";
        try {
            URL url = new URL("http://192.168.100.169:8080/AllergyLogin/menu.jsp");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            if(connection != null) {
                connection.setConnectTimeout(20000);
                connection.setUseCaches(false);
                sendMsg = "name=" + strings[0]; //전송할 데이터

                connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                connection.setRequestMethod("POST"); //POST 로 데이터 전송
                OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream());

                sendMsg = "id=" + strings[0] + "&pw=" + strings[1]; //전송할 데이터

                osw.write(sendMsg); //데이터 전송
                osw.flush(); //버퍼에 남아있는 모든 데이터 전송

                if(connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    //서버에서 읽어오기 위한 InputStream
                    InputStreamReader isr = new InputStreamReader(connection.getInputStream());
                    //줄 단위로 읽어오기
                    BufferedReader bufferedReader = new BufferedReader(isr);
                    //반복
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        buffer.append(line);
                    }
                    bufferedReader.close();
                    connection.disconnect();
                }
            }
            get_json = buffer.toString();
        } catch(Exception e) {
            Log.e("에러", e.getMessage());
        }
        return get_json;
    }
}
