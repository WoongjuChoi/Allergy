package com.example.allergy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
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
    SharedPreferences.Editor prefEditor;
    SharedPreferences prefs;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_list_view);
        prefs = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        prefEditor = prefs.edit();

        TextView title = (TextView) findViewById(R.id.titleText); //타이틀 이름
        ImageView titleImage = (ImageView) findViewById(R.id.titleImage); //타이틀 이미지

        Intent intent = getIntent(); //보내온 Intent를 받는다
        title.setText(intent.getStringExtra("name")); //받아온 Intent에서 타이틀이름을 받아 세팅
        titleImage.setImageResource(intent.getIntExtra("Image", 0)); //받아온 Intent에서 타이틀이미지를 받아 세팅

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.fastList);

        Adapter adapter = new StoreListActivity.Adapter(items);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); //리사이클러뷰에 리니어레이아웃매니저 지정

        String category= prefs.getString("category","");

        if (intent.getStringExtra("name").equals("패스트푸드")) { // 패스트푸드 화면인 경우
            items.add(new MainMenuItem("맥도날드", R.drawable.logo));
            items.add(new MainMenuItem("버거킹", R.drawable.burger_burgerking_logo));
            items.add(new MainMenuItem("롯데리아", R.drawable.lotteria));
            items.add(new MainMenuItem("KFC", R.drawable.kfc));
            items.add(new MainMenuItem("맘스터치", R.drawable.momstouch));
            items.add(new MainMenuItem("서브웨이", R.drawable.subway));
            items.add(new MainMenuItem("쉐이크쉑", R.drawable.shakeshack));
        } else if (intent.getStringExtra("name").equals("피자")) {
            items.add(new MainMenuItem("미스터피자", R.drawable.misterpizza));
            items.add(new MainMenuItem("피자헛", R.drawable.pizzahut));
            items.add(new MainMenuItem("도미노",R.drawable.pizza_domino_logo));
            items.add(new MainMenuItem("반올림피자샵",R.drawable.banolim));
            items.add(new MainMenuItem("파파존스",R.drawable.papajhones));
            items.add(new MainMenuItem("피자알볼로",R.drawable.alvolo));
            items.add(new MainMenuItem("고피자",R.drawable.gopizza));
        } else if (intent.getStringExtra("name").equals("치킨")) {
            items.add(new MainMenuItem("BBQ",R.drawable.chicken_bbq_logo));
            items.add(new MainMenuItem("KFC", R.drawable.kfc));
            items.add(new MainMenuItem("맘스터치", R.drawable.momstouch));
            items.add(new MainMenuItem("네네치킨", R.drawable.nenechicken));
            items.add(new MainMenuItem("BHC", R.drawable.bhc));
            items.add(new MainMenuItem("푸라닭", R.drawable.puradak));
            items.add(new MainMenuItem("멕시카나", R.drawable.mexicana));
        } else if (intent.getStringExtra("name").equals("디저트")) {
            items.add(new MainMenuItem("스타벅스",R.drawable.dessert_starbucks_logo));
            items.add(new MainMenuItem("파리바게트", R.drawable.parisbaguette));
            items.add(new MainMenuItem("투썸플레이스", R.drawable.twosome));
            items.add(new MainMenuItem("이디야커피", R.drawable.ediya));
            items.add(new MainMenuItem("카페베네",R.drawable.cafebene));
            items.add(new MainMenuItem("엔제리너스", R.drawable.angelinus));
            items.add(new MainMenuItem("배스킨라빈스31", R.drawable.baskin));
        } else if (intent.getStringExtra("name").equals("분식")) {
            items.add(new MainMenuItem("신전떡볶이",R.drawable.tteokbokki_shinjeon_logo));
            items.add(new MainMenuItem("동대문 엽기떡볶이", R.drawable.yupdduk));
            items.add(new MainMenuItem("배떡", R.drawable.baedduk));
            items.add(new MainMenuItem("태리로제떡볶이", R.drawable.terry));
            items.add(new MainMenuItem("싸다김밥", R.drawable.ssada));
            items.add(new MainMenuItem("오떡", R.drawable.odduk));
            items.add(new MainMenuItem("청년다방", R.drawable.chungnyun));
        } else if (intent.getStringExtra("name").equals("도시락")) {
            items.add(new MainMenuItem("한솥도시락", R.drawable.lunchbox_hansot_logo));
            items.add(new MainMenuItem("본도시락", R.drawable.bondosirak));
            items.add(new MainMenuItem("원할머니도시락", R.drawable.onehalmuni));
            items.add(new MainMenuItem("토마토도시락", R.drawable.tomatodosirak));
            items.add(new MainMenuItem("39도시락", R.drawable.thirynine));
            items.add(new MainMenuItem("본죽", R.drawable.bonjuk));
            items.add(new MainMenuItem("김밥천국", R.drawable.ginbabheaven));
        } else if (intent.getStringExtra("name").equals("중국집")) {
            items.add(new MainMenuItem("홍콩반점",R.drawable.jajangmyeon_hongkong_logo));
            items.add(new MainMenuItem("마라하오",R.drawable.marahao));
            items.add(new MainMenuItem("리얼안심찹쌀탕수육",R.drawable.realansim));
            items.add(new MainMenuItem("북경짜장",R.drawable.bukkyung));
            items.add(new MainMenuItem("홍짜장",R.drawable.hongjajang));
            items.add(new MainMenuItem("리춘시장",R.drawable.lichun));
            items.add(new MainMenuItem("라화쿵부",R.drawable.lahwa));
        }
        if(category!=""){
            if (category.equals("패스트푸드")) { // 패스트푸드 화면인 경우
                items.add(new MainMenuItem(prefs.getString("storeName",""),R.drawable.ic_launcher_foreground));
            } else if (category.equals("피자")) {
                items.add(new MainMenuItem(prefs.getString("storeName",""),R.drawable.ic_launcher_foreground));
            } else if (category.equals("치킨")) {
                items.add(new MainMenuItem(prefs.getString("storeName",""),R.drawable.ic_launcher_foreground));
            } else if (category.equals("디저트")) {
                items.add(new MainMenuItem(prefs.getString("storeName",""),R.drawable.ic_launcher_foreground));
            } else if (category.equals("분식")) {
                items.add(new MainMenuItem(prefs.getString("storeName",""),R.drawable.ic_launcher_foreground));
            } else if (category.equals("도시락")) {
                items.add(new MainMenuItem(prefs.getString("storeName",""),R.drawable.ic_launcher_foreground));
            } else if (category.equals("중국집")) {
                items.add(new MainMenuItem(prefs.getString("storeName",""),R.drawable.ic_launcher_foreground));
            }
        }




        //클릭이벤트처리
        adapter.setOnItemClickListener(new StoreListActivity.Adapter.OnItemClickListener() {
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
    public void storeAdder(String category, String storeName){
        if (category.equals("패스트푸드")) { // 패스트푸드 화면인 경우
            items.add(new MainMenuItem(storeName, R.drawable.ic_launcher_foreground));
        } else if (category.equals("피자")) {
            items.add(new MainMenuItem(storeName,R.drawable.ic_launcher_foreground));
        } else if (category.equals("치킨")) {
            items.add(new MainMenuItem(storeName,R.drawable.ic_launcher_foreground));
        } else if (category.equals("디저트")) {
            items.add(new MainMenuItem(storeName,R.drawable.ic_launcher_foreground));
        } else if (category.equals("분식")) {
            items.add(new MainMenuItem(storeName,R.drawable.ic_launcher_foreground));
        } else if (category.equals("도시락")) {
            items.add(new MainMenuItem(storeName, R.drawable.ic_launcher_foreground));
        } else if (category.equals("중국집")) {
            items.add(new MainMenuItem(storeName,R.drawable.ic_launcher_foreground));
        }
    }

    public static class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{
        ArrayList<MainMenuItem> items = new ArrayList<MainMenuItem>();

        Adapter(ArrayList<MainMenuItem> list) {
            items = list;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.menu_item_view, parent,false);
            Adapter.ViewHolder vh = new Adapter.ViewHolder(view);

            return vh;
        }
        public void  filterList(ArrayList<MainMenuItem> list) {
            items = list;
            notifyDataSetChanged();
        }

        //커스텀 리스너 인터페이스
        public interface OnItemClickListener
        {
            void onItemClick(View v, int pos);
        }


        //리스너 객체 참조를 저장하는 변수
        private Adapter.OnItemClickListener mListener = null;

        public void setOnItemClickListener(Adapter.OnItemClickListener listener)
        {
            this.mListener = listener;
        }

        @Override
        public void onBindViewHolder(Adapter.ViewHolder holder, int position) {
            MainMenuItem item = items.get(position);

            holder.icon.setImageResource(item.getResId());
            holder.menuname.setText(item.getMenuName());
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        // 뷰홀더 클래스 정의
        public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView icon ;
            TextView menuname ;

            ViewHolder(View itemView) {
                super(itemView) ;

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = getAdapterPosition(); // 어뎁터 내 아이템의 위치를 받는다
                        if (pos != RecyclerView.NO_POSITION) { //위치를 찾지 못한것이 아니라면
                            mListener.onItemClick(v, pos); //커스텀리스너 인터페이스의 onItemClick메소드 호출
                        }
                    }
                });

                // 뷰 객체에 대한 참조. (hold strong reference)
                icon = itemView.findViewById(R.id.image) ;
                menuname = itemView.findViewById(R.id.name) ;
            }
        }
    }
}