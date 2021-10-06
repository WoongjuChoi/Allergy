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

public class AllergyMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allergy_menu2);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView1);

        MenuListActivity.AllergyAdapter adapter = new MenuListActivity.AllergyAdapter(MenuListActivity.allergyItems);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); //리사이클러뷰에 리니어레이아웃매니저 지정

        TextView storeName1 = (TextView) findViewById(R.id.StoreName1); //가게 이름
        ImageView storeLogo1 = (ImageView)findViewById(R.id.StoreLogo1); //가게 로고

        Intent intent = getIntent(); //인텐트 가져온다
        storeName1.setText(intent.getStringExtra("StoreName1")); //인텐트로 받은 가게이름 세팅
        storeLogo1.setImageResource(intent.getIntExtra("StoreImage1", 0)); //인텐트로 받은 가게로고 세팅



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