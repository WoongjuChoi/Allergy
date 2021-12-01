package com.example.allergy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SearchListActivity extends AppCompatActivity {
    ArrayList<AllergyMenuItem> allergyItemArrayList, filteredList;
    ArrayList<MainMenuItem> storeItemArrayList, filteredList2;
    MenuListActivity.AllergyAdapter allergyAdapter;
    StoreListActivity.Adapter storeAdapter;
    RecyclerView recyclerView,recyclerView2;
    LinearLayoutManager linearLayoutManager, linearLayoutManager2;
    StoreListActivity storeListActivity;
    MenuListActivity menuListActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String query = getIntent().getStringExtra("keyword");
        setContentView(R.layout.searchlist_view);
        storeListActivity = new StoreListActivity();
        //menuListActivity = new MenuListActivity();

        //recyclerView = findViewById(R.id.recyclerView);
        recyclerView2 = findViewById(R.id.recyclerView2);


        //filteredList = new ArrayList<>();
        filteredList2 = new ArrayList<>();
        //allergyItemArrayList = new ArrayList<>();
        storeItemArrayList = new ArrayList<>();

        /*allergyAdapter = new MenuListActivity.AllergyAdapter(allergyItemArrayList);
        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(allergyAdapter);*/

        storeAdapter = new StoreListActivity.Adapter(storeItemArrayList);
        linearLayoutManager2 = new LinearLayoutManager(getApplicationContext());
        recyclerView2.setLayoutManager(linearLayoutManager2);
        recyclerView2.setAdapter(storeAdapter);

        storeItemArrayList.add(new MainMenuItem("맥도날드", R.drawable.logo));
        storeItemArrayList.add(new MainMenuItem("버거킹", R.drawable.burger_burgerking_logo));
        storeItemArrayList.add(new MainMenuItem("도미노",R.drawable.pizza_domino_logo));
        storeItemArrayList.add(new MainMenuItem("BBQ",R.drawable.chicken_bbq_logo));
        storeItemArrayList.add(new MainMenuItem("스타벅스",R.drawable.dessert_starbucks_logo));
        storeItemArrayList.add(new MainMenuItem("신전떡볶이",R.drawable.tteokbokki_shinjeon_logo));
        storeItemArrayList.add(new MainMenuItem("한솥도시락", R.drawable.lunchbox_hansot_logo));
        storeItemArrayList.add(new MainMenuItem("홍콩반점",R.drawable.jajangmyeon_hongkong_logo));
        storeItemArrayList.add(new MainMenuItem("롯데리아", R.drawable.lotteria));
        storeItemArrayList.add(new MainMenuItem("KFC", R.drawable.kfc));
        storeItemArrayList.add(new MainMenuItem("맘스터치", R.drawable.momstouch));
        storeItemArrayList.add(new MainMenuItem("서브웨이", R.drawable.subway));
        storeItemArrayList.add(new MainMenuItem("쉐이크쉑", R.drawable.shakeshack));
        storeItemArrayList.add(new MainMenuItem("미스터피자", R.drawable.misterpizza));
        storeItemArrayList.add(new MainMenuItem("피자헛", R.drawable.pizzahut));
        storeItemArrayList.add(new MainMenuItem("반올림피자샵",R.drawable.banolim));
        storeItemArrayList.add(new MainMenuItem("파파존스",R.drawable.papajhones));
        storeItemArrayList.add(new MainMenuItem("피자알볼로",R.drawable.alvolo));
        storeItemArrayList.add(new MainMenuItem("고피자",R.drawable.gopizza));
        storeItemArrayList.add(new MainMenuItem("KFC", R.drawable.kfc));
        storeItemArrayList.add(new MainMenuItem("맘스터치", R.drawable.momstouch));
        storeItemArrayList.add(new MainMenuItem("네네치킨", R.drawable.nenechicken));
        storeItemArrayList.add(new MainMenuItem("BHC", R.drawable.bhc));
        storeItemArrayList.add(new MainMenuItem("푸라닭", R.drawable.puradak));
        storeItemArrayList.add(new MainMenuItem("멕시카나", R.drawable.mexicana));
        storeItemArrayList.add(new MainMenuItem("파리바게트", R.drawable.parisbaguette));
        storeItemArrayList.add(new MainMenuItem("투썸플레이스", R.drawable.twosome));
        storeItemArrayList.add(new MainMenuItem("이디야커피", R.drawable.ediya));
        storeItemArrayList.add(new MainMenuItem("카페베네",R.drawable.cafebene));
        storeItemArrayList.add(new MainMenuItem("엔제리너스", R.drawable.angelinus));
        storeItemArrayList.add(new MainMenuItem("배스킨라빈스31", R.drawable.baskin));
        storeItemArrayList.add(new MainMenuItem("동대문 엽기떡볶이", R.drawable.yupdduk));
        storeItemArrayList.add(new MainMenuItem("배떡", R.drawable.baedduk));
        storeItemArrayList.add(new MainMenuItem("태리로제떡볶이", R.drawable.terry));
        storeItemArrayList.add(new MainMenuItem("싸다김밥", R.drawable.ssada));
        storeItemArrayList.add(new MainMenuItem("오떡", R.drawable.odduk));
        storeItemArrayList.add(new MainMenuItem("청년다방", R.drawable.chungnyun));
        storeItemArrayList.add(new MainMenuItem("본도시락", R.drawable.bondosirak));
        storeItemArrayList.add(new MainMenuItem("원할머니도시락", R.drawable.onehalmuni));
        storeItemArrayList.add(new MainMenuItem("토마토도시락", R.drawable.tomatodosirak));
        storeItemArrayList.add(new MainMenuItem("39도시락", R.drawable.thirynine));
        storeItemArrayList.add(new MainMenuItem("본죽", R.drawable.bonjuk));
        storeItemArrayList.add(new MainMenuItem("김밥천국", R.drawable.ginbabheaven));
        storeItemArrayList.add(new MainMenuItem("마라하오",R.drawable.marahao));
        storeItemArrayList.add(new MainMenuItem("리얼안심찹쌀탕수육",R.drawable.realansim));
        storeItemArrayList.add(new MainMenuItem("북경짜장",R.drawable.bukkyung));
        storeItemArrayList.add(new MainMenuItem("홍짜장",R.drawable.hongjajang));
        storeItemArrayList.add(new MainMenuItem("리춘시장",R.drawable.lichun));
        storeItemArrayList.add(new MainMenuItem("라화쿵부",R.drawable.lahwa));
        storeAdapter.notifyDataSetChanged();
        /*allergyItemArrayList.add(new AllergyMenuItem("창녕 갈릭 버거", "난류, 우유, 대두, 밀, 토마토, 쇠고기, 조개류"));
        allergyItemArrayList.add(new AllergyMenuItem("빅맥", "난류, 우유, 대두, 밀, 쇠고기"));
        allergyItemArrayList.add(new AllergyMenuItem("필레 오 피쉬", "난류, 우유, 대두, 밀"));
        allergyItemArrayList.add(new AllergyMenuItem("더블 필레 오 피쉬", "난류, 우유, 대두, 밀"));
        allergyItemArrayList.add(new AllergyMenuItem("1955 버거", "난류, 우유, 대두, 밀, 돼지고기, 토마토, 쇠고기"));
        allergyItemArrayList.add(new AllergyMenuItem("맥스파이시 상하이 버거", "난류, 대두, 밀, 토마토, 닭고기"));
        allergyItemArrayList.add(new AllergyMenuItem("맥치킨", "난류, 대두, 밀, 닭고기"));
        allergyItemArrayList.add(new AllergyMenuItem("맥치킨 모짜렐라", "난류, 우유, 대두, 밀, 토마토, 닭고기"));
        allergyItemArrayList.add(new AllergyMenuItem("더블 불고기 버거", "난류, 우유, 대두, 밀, 돼지고기, 조개, 조개류"));
        allergyItemArrayList.add(new AllergyMenuItem("에그 불고기 버거", "난류, 대두, 밀, 돼지고기, 조개, 조개류"));
        allergyItemArrayList.add(new AllergyMenuItem("불고기 버거", "난류, 대두, 밀, 돼지고기, 조개, 조개류"));
        allergyItemArrayList.add(new AllergyMenuItem("슈슈 버거", "난류, 우유, 대두, 밀, 토마토, 새우, 쇠고기, 조개류"));
        allergyItemArrayList.add(new AllergyMenuItem("슈비 버거", "난류, 우유, 대두, 밀, 토마토, 새우, 쇠고기, 조개류"));
        allergyItemArrayList.add(new AllergyMenuItem("베이컨 토마도 디럭스", "난류, 우유, 대두, 밀, 돼지고기, 토마토, 쇠고기"));
        allergyItemArrayList.add(new AllergyMenuItem("더블 쿼터파운더 치즈", "우유, 대두, 밀, 토마토, 쇠고기"));
        allergyItemArrayList.add(new AllergyMenuItem("쿼터파운더 치즈", "우유, 대두, 밀, 토마토, 쇠고기"));
        allergyItemArrayList.add(new AllergyMenuItem("치즈버거", "우유, 대두, 밀, 토마토, 쇠고기"));
        allergyItemArrayList.add(new AllergyMenuItem("더블 치즈버거", "우유, 대두, 밀, 토마토, 쇠고기"));
        allergyItemArrayList.add(new AllergyMenuItem("햄버거", "대두, 밀, 토마토, 쇠고기"));
        allergyItemArrayList.add(new AllergyMenuItem("와퍼", "밀, 대두, 토마토, 쇠고기, 난류"));
        allergyItemArrayList.add(new AllergyMenuItem("블록버스터", "계란, 대두, 밀, 돼지고기, 닭고기, 토마토, 우유, 새우, 쇠고기, 오징어, 바닷가재, 게, 조개류"));
        allergyItemArrayList.add(new AllergyMenuItem("반반치킨", "우유, 대두, 밀, 조개류, 쇠고기, 새우, 땅콩"));
        allergyItemArrayList.add(new AllergyMenuItem("딸기 딜라이트 요거트 블렌디드", "우유"));
        allergyItemArrayList.add(new AllergyMenuItem("치킨마요덮밥", "난류, 우유, 대두, 밀, 돼지고기, 닭고기, 조개류"));
        allergyItemArrayList.add(new AllergyMenuItem("짜장면", " "));
        allergyAdapter.notifyDataSetChanged();*/
        searchFilter(query);
        storeAdapter.setOnItemClickListener(new StoreListActivity.Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Intent intent = new Intent(
                        getApplicationContext(), // 현재화면의 제어권자
                        MenuListActivity.class); // 다음넘어갈 화면

                intent.putExtra("StoreName", filteredList2.get(pos).menuName);
                intent.putExtra("StoreImage", filteredList2.get(pos).resId2);

                startActivityForResult(intent, 101);
            }
        });

        storeAdapter.notifyDataSetChanged();
    }
    public void searchFilter(String query){
        //filteredList.clear();
        filteredList2.clear();
        /*for (int i = 0; i < allergyItemArrayList.size(); i++) {
            if (allergyItemArrayList.get(i).getMenuName().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(allergyItemArrayList.get(i));
            }
        }*/
        for (int j = 0; j < storeItemArrayList.size(); j++) {
            if (storeItemArrayList.get(j).getMenuName().toLowerCase().contains(query.toLowerCase())) {
                filteredList2.add(storeItemArrayList.get(j));
            }
        }
        //allergyAdapter.filterList(filteredList);
        storeAdapter.filterList(filteredList2);
    }
}
