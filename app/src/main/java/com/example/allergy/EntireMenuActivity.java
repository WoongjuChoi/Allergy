package com.example.allergy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class EntireMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entire_menu);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView2);

        MenuListActivity.AllergyAdapter adapter = new MenuListActivity.AllergyAdapter(MenuListActivity.allItems);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); //리사이클러뷰에 리니어레이아웃매니저 지정

        TextView storeName2 = (TextView) findViewById(R.id.StoreName2); //가게 이름
        ImageView storeLogo2 = (ImageView)findViewById(R.id.StoreLogo2); //가게 로고

        Intent intent = getIntent(); //인텐트 가져온다
        storeName2.setText(intent.getStringExtra("StoreName2")); //인텐트로 받은 가게이름 세팅
        storeLogo2.setImageResource(intent.getIntExtra("StoreImage2", 0)); //인텐트로 받은 가게로고 세팅



        //클릭이벤트처리
        adapter.setOnItemClickListener(new MenuListActivity.AllergyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Snackbar.make(v, "메뉴가 눌렸습니다.", Snackbar.LENGTH_LONG).show();
            }
        });

        adapter.notifyDataSetChanged();
    }
}