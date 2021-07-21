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
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MenuListActivity extends AppCompatActivity {
    ArrayList<MainMenuItem> items = new ArrayList<MainMenuItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_list_view);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        Adapter adapter = new Adapter(items);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); //리사이클러뷰에 리니어레이아웃매니저 지정

        TextView storeName = (TextView) findViewById(R.id.StoreName); //가게 이름
        ImageView storeLogo = (ImageView)findViewById(R.id.StoreLogo); //가게 로고

        Intent intent = getIntent(); //인텐트 가져온다
        storeName.setText(intent.getStringExtra("StoreName")); //인텐트로 받은 가게이름 세팅
        storeLogo.setImageResource(intent.getIntExtra("StoreImage", 0)); //인텐트로 받은 가게로고 세팅

        if (intent.getStringExtra("StoreName").equals("맥도날드")) { //가게 이름이 맥도날드이면
            items.add(new MainMenuItem("빅맥 베이컨", R.drawable.bigmacbacon));
            items.add(new MainMenuItem("빅맥", R.drawable.bigmac));
            items.add(new MainMenuItem("필레 오 피쉬", R.drawable.filet));
            items.add(new MainMenuItem("더블 필레 오 피쉬", R.drawable.doublefilet));
            items.add(new MainMenuItem("1955 버거", R.drawable.nineteenfiftyfive));
            items.add(new MainMenuItem("맥스파이시 상하이 버거", R.drawable.shanghai));
            items.add(new MainMenuItem("맥치킨", R.drawable.mcchicken));
            items.add(new MainMenuItem("맥치킨 모짜렐라", R.drawable.mcchickienmozzarella));
            items.add(new MainMenuItem("더블 불고기 버거", R.drawable.doublebulgogi));
            items.add(new MainMenuItem("에그 불고기 버거", R.drawable.eggbulgogi));
            items.add(new MainMenuItem("슈슈 버거", R.drawable.supremeshrimp));
            items.add(new MainMenuItem("슈비 버거", R.drawable.shrimpbeef));
            items.add(new MainMenuItem("베이컨 토마도 디럭스", R.drawable.bacontomato));
            items.add(new MainMenuItem("더블 쿼터파운더 치즈", R.drawable.doublequarterpoundercheese));
            items.add(new MainMenuItem("쿼터파운더 치즈", R.drawable.quarterpoundercheese));
            items.add(new MainMenuItem("치즈버거", R.drawable.cheese));
            items.add(new MainMenuItem("더블 치즈버거", R.drawable.doublecheese));
            items.add(new MainMenuItem("햄버거", R.drawable.hamburger));
        } else if ( intent.getStringExtra("StoreName").equals("버거킹")){
            items.add(new MainMenuItem("와퍼", R.drawable.burgerking_whopper));
        } else if ( intent.getStringExtra("StoreName").equals("도미노")){
            items.add(new MainMenuItem("블록버스터", R.drawable.pizza_domino_blockbuster));
        } else if ( intent.getStringExtra("StoreName").equals("BBQ")){
            items.add(new MainMenuItem("반반치킨", R.drawable.chicken_bbq_banban));
        } else if ( intent.getStringExtra("StoreName").equals("스타벅스")){
            items.add(new MainMenuItem("딸기레몬블렌디드", R.drawable.dessert_starbucks_strawberrylemonblended));
        } else if ( intent.getStringExtra("StoreName").equals("한솥도시락")){
            items.add(new MainMenuItem("치킨마요덮밥", R.drawable.lunchbox_hansot_chickenmayo));
        } else if ( intent.getStringExtra("StoreName").equals("홍콩반점")){
            items.add(new MainMenuItem("짜장면", R.drawable.jajanmyeon_hongkong_jajanmyeon));
        }

        //클릭이벤트처리
        adapter.setOnItemClickListener(new Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Snackbar.make(v, "메뉴가 눌렸습니다.", Snackbar.LENGTH_LONG).show();
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
        public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
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
        private OnItemClickListener mListener = null;

        public void setOnItemClickListener(OnItemClickListener listener)
        {
            this.mListener = listener;
        }

        @Override
        public void onBindViewHolder(MenuListActivity.Adapter.ViewHolder holder, int position) {
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