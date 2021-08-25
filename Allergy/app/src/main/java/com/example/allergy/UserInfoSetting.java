package com.example.allergy;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class UserInfoSetting extends AppCompatActivity implements View.OnClickListener {
    Button button;
    public static ArrayList<String> allergyList;
    SharedPreferences.Editor prefEditor;
    SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_info_setting);
        prefs = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        prefEditor = prefs.edit();
        button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(this);
        allergyList = new ArrayList<>();
        
        Switch Egg = findViewById(R.id.switchEgg);
        Egg.setChecked(prefs.getBoolean("Egg",false));
        Switch Milk = findViewById(R.id.switchMilk);
        Milk.setChecked(prefs.getBoolean("Milk",false));
        Switch Buckwheat = findViewById(R.id.switchBuckwheat);
        Buckwheat.setChecked(prefs.getBoolean("Buckwheat",false));
        Switch Peanut = (Switch) findViewById(R.id.switchPeanut);
        Peanut.setChecked(prefs.getBoolean("Peanut",false));
        Switch Soybean = (Switch) findViewById(R.id.switchSoybean);
        Soybean.setChecked(prefs.getBoolean("Soybean",false));
        Switch Wheat = (Switch) findViewById(R.id.switchWheat);
        Soybean.setChecked(prefs.getBoolean("Soybean",false));
        Switch Crab = (Switch) findViewById(R.id.switchCrab);
        Crab.setChecked(prefs.getBoolean("Crab",false));
        Switch Shrimp = (Switch) findViewById(R.id.switchShrimp);
        Shrimp.setChecked(prefs.getBoolean("Shrimp",false));
        Switch Pork = (Switch) findViewById(R.id.switchPork);
        Pork.setChecked(prefs.getBoolean("Pork",false));
        Switch Tomato = (Switch) findViewById(R.id.switchTomato);
        Tomato.setChecked(prefs.getBoolean("Tomato",false));
        Switch SulfuricAcid = (Switch) findViewById(R.id.switchSulfuricAcid);
        SulfuricAcid.setChecked(prefs.getBoolean("SulfuricAcid",false));
        Switch Walnut = (Switch) findViewById(R.id.switchWalnut);
        Walnut.setChecked(prefs.getBoolean("Walnut",false));
        Switch Chicken = (Switch) findViewById(R.id.switchChicken);
        Chicken.setChecked(prefs.getBoolean("Chicken",false));
        Switch Beef = (Switch) findViewById(R.id.switchBeef);
        Beef.setChecked(prefs.getBoolean("Beef",false));
        Switch Squid = (Switch) findViewById(R.id.switchSquid);
        Squid.setChecked(prefs.getBoolean("Squid",false));
        Switch Shellfish = (Switch) findViewById(R.id.switchShellfish);
        Shellfish.setChecked(prefs.getBoolean("Shellfish",false));
        Switch Pinenut = (Switch) findViewById(R.id.switchPinenut);
        Pinenut.setChecked(prefs.getBoolean("Pinenut",false));
        Switch Peach = (Switch) findViewById(R.id.switchPeach);
        Peach.setChecked(prefs.getBoolean("Peach",false));
        
        Egg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    prefEditor.putBoolean("Egg",true);
                    allergyList.add("달걀");
                }else{
                    prefEditor.putBoolean("Egg",false);
                    allergyList.remove("달걀");
                }
                prefEditor.apply();
            }
        });
        Milk.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    prefEditor.putBoolean("Milk",true);
                    allergyList.add("우유");

                }else{
                    prefEditor.putBoolean("Milk",false);
                    allergyList.remove("우유");
                }
                prefEditor.apply();
            }
        });
        Buckwheat.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    prefEditor.putBoolean("Buckwheat",true);
                    allergyList.add("메밀");

                }else{
                    prefEditor.putBoolean("Buckwheat",false);
                    allergyList.remove("메밀");
                }
                prefEditor.apply();
            }
        });
        Peanut.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    prefEditor.putBoolean("Peanut",true);
                    allergyList.add("땅콩");

                }else{
                    prefEditor.putBoolean("Peanut",false);
                    allergyList.remove("땅콩");
                }
                prefEditor.apply();
            }
        });
        Soybean.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    prefEditor.putBoolean("Soybean",true);
                    allergyList.add("대두");

                }else{
                    prefEditor.putBoolean("Soybean",false);
                    allergyList.remove("대두");
                }
                prefEditor.apply();
            }
        });
        Wheat.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    prefEditor.putBoolean("Wheat",true);
                    allergyList.add("밀");

                }else{
                    prefEditor.putBoolean("Wheat",false);
                    allergyList.remove("밀");
                }
                prefEditor.apply();
            }
        });
        Crab.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    prefEditor.putBoolean("Crab",true);
                    allergyList.add("게");

                }else{
                    prefEditor.putBoolean("Crab",false);
                    allergyList.remove("게");
                }
                prefEditor.apply();
            }
        });
        Shrimp.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    prefEditor.putBoolean("Shrimp",true);
                    allergyList.add("새우");

                }else{
                    prefEditor.putBoolean("Shrimp",false);
                    allergyList.remove("새우");
                }
                prefEditor.apply();
            }
        });
        Pork.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    prefEditor.putBoolean("Pork",true);
                    allergyList.add("돼지고기");

                }else{
                    prefEditor.putBoolean("Pork",false);
                    allergyList.remove("돼지고기");
                }
                prefEditor.apply();
            }
        });
        Tomato.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    prefEditor.putBoolean("Tomato",true);
                    allergyList.add("토마토");

                }else{
                    prefEditor.putBoolean("Tomata",false);
                    allergyList.remove("토마토");
                }
                prefEditor.apply();
            }
        });
        SulfuricAcid.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    prefEditor.putBoolean("SulfuricAcid",true);
                    allergyList.add("아황산");

                }else{
                    prefEditor.putBoolean("SulfuricAcid",false);
                    allergyList.remove("아황산");
                }
                prefEditor.apply();
            }
        });
        Walnut.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    prefEditor.putBoolean("Walnut",true);
                    allergyList.add("호두");

                }else{
                    prefEditor.putBoolean("Walnut",false);
                    allergyList.remove("호두");
                }
                prefEditor.apply();
            }
        });
        Chicken.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    prefEditor.putBoolean("Chicken",true);
                    allergyList.add("닭고기");

                }else{
                    prefEditor.putBoolean("Chicken",false);
                    allergyList.remove("닭고기");
                }
                prefEditor.apply();
            }
        });
        Beef.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    prefEditor.putBoolean("Beef",true);
                    allergyList.add("쇠고기");

                }else{
                    prefEditor.putBoolean("Beef",false);
                    allergyList.remove("쇠고기");
                }
                prefEditor.apply();
            }
        });
        Squid.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    prefEditor.putBoolean("Squid",true);
                    allergyList.add("오징어");

                }else{
                    prefEditor.putBoolean("Squid",false);
                    allergyList.remove("오징어");
                }
                prefEditor.apply();
            }
        });
        Shellfish.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    prefEditor.putBoolean("Shellfish",true);
                    allergyList.add("조개류");

                }else{
                    prefEditor.putBoolean("Shellfish",false);
                    allergyList.remove("조개류");
                }
                prefEditor.apply();
            }
        });
        Pinenut.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    prefEditor.putBoolean("Pinenut",true);
                    allergyList.add("잣");

                }else{
                    prefEditor.putBoolean("Pinenut",false);
                    allergyList.remove("잣");
                }
                prefEditor.apply();
            }
        });
        Peach.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    prefEditor.putBoolean("Peach",true);
                    allergyList.add("복숭아");

                }else{
                    prefEditor.putBoolean("Peach",false);
                    allergyList.remove("복숭아");
                }
                prefEditor.apply();
            }
        });
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(UserInfoSetting.this, "저장되었습니다.", Toast.LENGTH_LONG).show();
        SaveAllergyData(allergyList);
    }
    private void SaveAllergyData(ArrayList<String> allergyList){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Editor editor = preferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(allergyList);
        editor.putString("MyAllergies", json);
        editor.apply();

    }
    private ArrayList<String> ReadAllergyData(){
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Gson gson = new Gson();
        String json = sharedPrefs.getString("MyAllergies","EMPTY");
        Type type = new TypeToken<ArrayList<String>>(){}.getType();
        ArrayList<String> arrayList = gson.fromJson(json, type);
        return arrayList;
    }
    @Override
    protected void onStop(){
        SharedPreferences sharedPreferences = getSharedPreferences("sFile", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        super.onStop();
        editor.commit();
    }
}