package com.example.allergy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class FastFoodActivity extends AppCompatActivity {
    ArrayList<MainMenuItem> items = new ArrayList<MainMenuItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fast_food);

        TextView title = (TextView) findViewById(R.id.titleText); //타이틀 이름
        ImageView titleImage = (ImageView) findViewById(R.id.titleImage); //타이틀 이미지

        Intent intent = getIntent(); //보내온 Intent를 받는다
        title.setText(intent.getStringExtra("name")); //받아온 Intent에서 타이틀이름을 받아 세팅
        titleImage.setImageResource(intent.getIntExtra("Image", 0)); //받아온 Intent에서 타이틀이미지를 받아 세팅

        ListView listView = (ListView) findViewById(R.id.fastList);

        FastMenuAdapter fastMenuAdapter = new FastMenuAdapter(
                getApplicationContext(),
                R.layout.mainmenu_view,
                items
        );

        if (intent.getStringExtra("name").equals("패스트푸드")) { // 패스트푸드 화면인 경우
            items.add(new MainMenuItem("맥도날드", R.drawable.logo));
            items.add(new MainMenuItem("버거킹", R.drawable.burger_burgerking_logo));
        } else if (intent.getStringExtra("name").equals("피자")) {
            items.add(new MainMenuItem("도미노",R.drawable.pizza_domino_logo));
        } else if (intent.getStringExtra("name").equals("치킨")) {
            items.add(new MainMenuItem("BBQ",R.drawable.chicken_bbq_logo));
        } else if (intent.getStringExtra("name").equals("디저트")) {
            items.add(new MainMenuItem("스타벅스",R.drawable.dessert_starbucks_logo));
        } else if (intent.getStringExtra("name").equals("분식")) {
            items.add(new MainMenuItem("신전떡볶이",R.drawable.tteokbokki_shinjeon_logo));
        } else if (intent.getStringExtra("name").equals("도시락")) {
            items.add(new MainMenuItem("한솥도시락", R.drawable.lunchbox_hansot_logo));
        } else if (intent.getStringExtra("name").equals("중국집")) {
            items.add(new MainMenuItem("홍콩반점",R.drawable.jajangmyeon_hongkong_logo));
        }

        listView.setAdapter(fastMenuAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(
                        getApplicationContext(), // 현재화면의 제어권자
                        McMenuActivity.class); // 다음넘어갈 화면

                intent.putExtra("StoreName", items.get(position).menuName);
                intent.putExtra("StoreImage", items.get(position).resId2);

                startActivityForResult(intent, 101);
            }
        });
    }


    class FastMenuAdapter extends BaseAdapter {
        Context context;
        int layout;
        ArrayList<MainMenuItem> items;

        public FastMenuAdapter(Context context, int layout, ArrayList<MainMenuItem> items) {
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
            McMenuItemView view = null;
            if (convertView == null) {
                view = new McMenuItemView(getApplicationContext());
            } else {
                view = (McMenuItemView) convertView;
            }

            MainMenuItem item = items.get(position);
            view.setName(item.getMenuName());
            view.setIcon(item.getResId2());

            return view;
        }
    }
}