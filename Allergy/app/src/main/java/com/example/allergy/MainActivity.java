package com.example.allergy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<MainMenuItem> items = new ArrayList<MainMenuItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    }
    public void onUserSettingClicked(View v){
        Intent intent = new Intent(getApplicationContext(), UserSetting.class);
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

}