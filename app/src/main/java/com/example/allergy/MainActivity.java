package com.example.allergy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SharedPreferences.Editor prefEditor;
    SharedPreferences prefs;
    ArrayList<MainMenuItem> items = new ArrayList<MainMenuItem>();
    int login;
    Button login_btn, resister_btn, menu_resister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = getIntent().getIntExtra("login",'0');
        prefs = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        prefEditor = prefs.edit();
        UserInfoSetting.allergyList = ReadAllergyData();
        SearchView searchView;
        searchView = findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent intent = new Intent(getApplicationContext(),SearchListActivity.class);
                intent.putExtra("keyword",query);
                startActivity(intent);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        login_btn = findViewById(R.id.login);
        resister_btn = findViewById(R.id.resister);
        menu_resister = findViewById(R.id.menu_resister);
        if(login==1){
            login_btn.setVisibility(View.GONE);
            resister_btn.setVisibility(View.GONE);
            menu_resister.setVisibility(View.VISIBLE);
        } else if(login==0){
            login_btn.setVisibility(View.VISIBLE);
            resister_btn.setVisibility(View.VISIBLE);
            menu_resister.setVisibility(View.VISIBLE);
        }
        menu_resister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuResister.class);
                startActivity(intent);
            }
        });

        GridView gridView = (GridView) findViewById(R.id.gridView);

        MainAdapter adapter = new MainAdapter(
                getApplicationContext(),
                R.layout.mainmenu_item_view,
                items
        );

        items.add(new MainMenuItem("패스트푸드", R.drawable.burger));
        items.add(new MainMenuItem("피자", R.drawable.pizza));
        items.add(new MainMenuItem("치킨", R.drawable.chicken));
        items.add(new MainMenuItem("디저트", R.drawable.dessert));
        items.add(new MainMenuItem("분식", R.drawable.tteokbokki));
        items.add(new MainMenuItem("도시락", R.drawable.lunchbox));
        items.add(new MainMenuItem("중국집", R.drawable.jajangmyeon));

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(
                            getApplicationContext(), // 현재화면의 제어권자
                            StoreListActivity.class); // 다음넘어갈 화면

                    intent.putExtra("name", items.get(position).menuName);
                    intent.putExtra("Image", items.get(position).resId2);

                    startActivityForResult(intent, 101);
            }
        });
    }
    public void onLoginClicked(View v){
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }

    public void onResisterClicked(View v){
        Intent intent = new Intent(getApplicationContext(), ResisterActivity.class);
        startActivity(intent);
        finish();
    }
    public void onUserSettingClicked(View v){
        Intent intent = new Intent(getApplicationContext(), UserInfoSetting.class);
        startActivity(intent);
    }

    public class MainAdapter extends BaseAdapter {
        Context context;
        int layout;
        ArrayList<MainMenuItem> items;

        public MainAdapter(Context context, int layout, ArrayList<MainMenuItem> items) {
            this.context = context;
            this.layout = layout;
            this.items = items;
        }

        @Override
        public boolean areAllItemsEnabled() {
            return super.areAllItemsEnabled();
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public void addItem(MainMenuItem item) {
            items.add(item);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            MainMenuView view = null;
            if (convertView == null) {
                view = new MainMenuView(getApplicationContext());
            } else {
                view = (MainMenuView) convertView;
            }

            MainMenuItem item = items.get(position);
            view.setmName(item.getMenuName());
            view.setmImage(item.getResId());

            return view;
        }
    }
    public  ArrayList<String> ReadAllergyData() {
        SharedPreferences sharedPrefs = getSharedPreferences("AllergyList",MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPrefs.getString("MyAllergies", "EMPTY");
        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();
        ArrayList<String> arrayList = gson.fromJson(json, type);
        return arrayList;
    }
    // 마지막으로 뒤로가기 버튼을 눌렀던 시간 저장
    private long backKeyPressedTime = 0;
    // 첫 번째 뒤로가기 버튼을 누를때 표시
    private Toast toast;
    @Override
    public void onBackPressed() {
        // 기존 뒤로가기 버튼의 기능을 막기위해 주석처리 또는 삭제
        // super.onBackPressed();

        // 마지막으로 뒤로가기 버튼을 눌렀던 시간에 2초를 더해 현재시간과 비교 후
        // 마지막으로 뒤로가기 버튼을 눌렀던 시간이 2초가 지났으면 Toast Show
        // 2000 milliseconds = 2 seconds
        if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis();
            toast = Toast.makeText(this, "\'뒤로\' 버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        // 마지막으로 뒤로가기 버튼을 눌렀던 시간에 2초를 더해 현재시간과 비교 후
        // 마지막으로 뒤로가기 버튼을 눌렀던 시간이 2초가 지나지 않았으면 종료
        // 현재 표시된 Toast 취소
        if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            finish();
            toast.cancel();
        }
    }
}