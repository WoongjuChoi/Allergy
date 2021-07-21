package com.example.allergy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class StoreListActivity extends AppCompatActivity {
    ArrayList<MainMenuItem> items = new ArrayList<MainMenuItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_list_view);

        TextView title = (TextView) findViewById(R.id.titleText); //타이틀 이름
        ImageView titleImage = (ImageView) findViewById(R.id.titleImage); //타이틀 이미지

        Intent intent = getIntent(); //보내온 Intent를 받는다
        title.setText(intent.getStringExtra("name")); //받아온 Intent에서 타이틀이름을 받아 세팅
        titleImage.setImageResource(intent.getIntExtra("Image", 0)); //받아온 Intent에서 타이틀이미지를 받아 세팅

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.fastList);

        MenuListActivity.Adapter adapter = new MenuListActivity.Adapter(items);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); //리사이클러뷰에 리니어레이아웃매니저 지정

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


        //클릭이벤트처리
        adapter.setOnItemClickListener(new MenuListActivity.Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Intent intent = new Intent(
                        getApplicationContext(), // 현재화면의 제어권자
                        MenuListActivity.class); // 다음넘어갈 화면

                intent.putExtra("StoreName", items.get(pos).menuName);
                intent.putExtra("StoreImage", items.get(pos).resId2);

                startActivityForResult(intent, 101);
            }
        });

        adapter.notifyDataSetChanged();
    }
}