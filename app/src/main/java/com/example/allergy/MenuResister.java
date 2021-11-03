package com.example.allergy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.gson.Gson;

import java.util.ArrayList;


public class MenuResister extends AppCompatActivity {
    String[] categories = {"패스트푸드","피자","치킨","디저트","분식","도시락","중국집"};
    public static String category;
    public static String storeName;
    public static String menuName;
    public static ArrayList<String> list;
    SharedPreferences.Editor prefEditor;
    SharedPreferences prefs;
    CheckBox Egg, Tomato, Milk, SulfuricAcid,BuckWheat,Peanut,Soybean,Wheat,Crab,Shrimp,Pork,Lobster,Walnut,Chicken,Beef,Squid,Shellfish,Pinenut,Peach;
    ArrayList<CheckBox> checkBoxes = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_resister_view);
        list = new ArrayList<>();
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, categories
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                category = categories[position];
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Egg = findViewById(R.id.Egg);
        checkBoxes.add(Egg);
        Tomato = findViewById(R.id.Tomato);
        checkBoxes.add(Tomato);
        Milk = findViewById(R.id.Milk);
        checkBoxes.add(Milk);
        SulfuricAcid = findViewById(R.id.SulfuricAcid);
        checkBoxes.add(SulfuricAcid);
        BuckWheat = findViewById(R.id.Buckwheat);
        checkBoxes.add(BuckWheat);
        Peanut = findViewById(R.id.Peanut);
        checkBoxes.add(Peanut);
        Soybean = findViewById(R.id.Soybean);
        checkBoxes.add(Soybean);
        Wheat = findViewById(R.id.Wheat);
        checkBoxes.add(Wheat);
        Crab = findViewById(R.id.Crab);
        checkBoxes.add(Crab);
        Shrimp = findViewById(R.id.Shrimp);
        checkBoxes.add(Shrimp);
        Pork = findViewById(R.id.Pork);
        checkBoxes.add(Pork);
        Lobster = findViewById(R.id.Lobster);
        checkBoxes.add(Lobster);
        Walnut = findViewById(R.id.Walnut);
        checkBoxes.add(Walnut);
        Chicken = findViewById(R.id.Chicken);
        checkBoxes.add(Chicken);
        Beef = findViewById(R.id.Beef);
        checkBoxes.add(Beef);
        Squid = findViewById(R.id.Squid);
        checkBoxes.add(Squid);
        Shellfish = findViewById(R.id.Shellfish);
        checkBoxes.add(Shellfish);
        Pinenut = findViewById(R.id.Pinenut);
        checkBoxes.add(Pinenut);
        Peach = findViewById(R.id.Peach);
        checkBoxes.add(Peach);
        prefs = getSharedPreferences("pref",MODE_PRIVATE);
        prefEditor = prefs.edit();

        EditText storeNameET = findViewById(R.id.storenameET);
        EditText menuNameET = findViewById(R.id.menunameET);

        Button button = findViewById(R.id.menu_resister_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.clear();
                for(CheckBox a : checkBoxes){
                    if(a.isChecked()==true){
                        list.add(a.getText().toString());
                    }
                }
                storeName = storeNameET.getText().toString();
                menuName = menuNameET.getText().toString();
                prefEditor.putString("storeName",storeName);
                prefEditor.putString("menuName",menuName);
                prefEditor.putString("category",category);
                SaveAllergyData(list);
                prefEditor.commit();
            }
        });
    }
    public void SaveAllergyData(ArrayList<String> allergies) {
        SharedPreferences preferences = getSharedPreferences("pref",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(allergies);
        editor.putString("allergyResister", json);
        editor.commit();
    }

}