package com.example.allergy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

        Adapter adapter = new StoreListActivity.Adapter(items);
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