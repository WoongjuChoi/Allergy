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
    ArrayList<AllergyMenuItem> items = new ArrayList<AllergyMenuItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_list_view);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        AllergyAdapter adapter = new AllergyAdapter(items);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); //리사이클러뷰에 리니어레이아웃매니저 지정

        TextView storeName = (TextView) findViewById(R.id.StoreName); //가게 이름
        ImageView storeLogo = (ImageView)findViewById(R.id.StoreLogo); //가게 로고

        Intent intent = getIntent(); //인텐트 가져온다
        storeName.setText(intent.getStringExtra("StoreName")); //인텐트로 받은 가게이름 세팅
        storeLogo.setImageResource(intent.getIntExtra("StoreImage", 0)); //인텐트로 받은 가게로고 세팅

        if (intent.getStringExtra("StoreName").equals("맥도날드")) { //가게 이름이 맥도날드이면
            items.add(new AllergyMenuItem("창녕 갈릭 버거", "난류, 우유, 대두, 밀, 토마토, 쇠고기, 굴"));
            items.add(new AllergyMenuItem("빅맥", "난류, 우유, 대두, 밀, 쇠고기"));
            items.add(new AllergyMenuItem("필레 오 피쉬", "난류, 우유, 대두, 밀"));
            items.add(new AllergyMenuItem("더블 필레 오 피쉬", "난류, 우유, 대두, 밀"));
            items.add(new AllergyMenuItem("1955 버거", "난류, 우유, 대두, 밀, 돼지고기, 토마토, 쇠고기"));
            items.add(new AllergyMenuItem("맥스파이시 상하이 버거", "난류, 대두, 밀, 토마토, 닭고기"));
            items.add(new AllergyMenuItem("맥치킨", "난류, 대두, 밀, 닭고기"));
            items.add(new AllergyMenuItem("맥치킨 모짜렐라", "난류, 우유, 대두, 밀, 토마토, 닭고기"));
            items.add(new AllergyMenuItem("더블 불고기 버거", "난류, 우유, 대두, 밀, 돼지고기, 조개, 굴"));
            items.add(new AllergyMenuItem("에그 불고기 버거", "난류, 대두, 밀, 돼지고기, 조개, 굴"));
            items.add(new AllergyMenuItem("불고기 버거", "난류, 대두, 밀, 돼지고기, 조개, 굴"));
            items.add(new AllergyMenuItem("슈슈 버거", "난류, 우유, 대두, 밀, 토마토, 새우, 쇠고기, 굴"));
            items.add(new AllergyMenuItem("슈비 버거", "난류, 우유, 대두, 밀, 토마토, 새우, 쇠고기, 굴"));
            items.add(new AllergyMenuItem("베이컨 토마도 디럭스", "난류, 우유, 대두, 밀, 돼지고기, 토마토, 쇠고기"));
            items.add(new AllergyMenuItem("더블 쿼터파운더 치즈", "우유, 대두, 밀, 토마토, 쇠고기"));
            items.add(new AllergyMenuItem("쿼터파운더 치즈", "우유, 대두, 밀, 토마토, 쇠고기"));
            items.add(new AllergyMenuItem("치즈버거", "우유, 대두, 밀, 토마토, 쇠고기"));
            items.add(new AllergyMenuItem("더블 치즈버거", "우유, 대두, 밀, 토마토, 쇠고기"));
            items.add(new AllergyMenuItem("햄버거", "대두, 밀, 토마토, 쇠고기"));
        } else if ( intent.getStringExtra("StoreName").equals("버거킹")){
            items.add(new AllergyMenuItem("와퍼", "밀, 대두, 토마토, 쇠고기, 난류"));
        } else if ( intent.getStringExtra("StoreName").equals("도미노")){
            items.add(new AllergyMenuItem("블록버스터", "계란, 대두, 밀, 돼지고기, 닭고기, 토마토, 우유, 새우, 쇠고기, 오징어, 바닷가재, 게, 굴"));
        } else if ( intent.getStringExtra("StoreName").equals("BBQ")){
            items.add(new AllergyMenuItem("반반치킨", "우유, 대두, 밀, 조개류, 쇠고기, 새우, 땅콩"));
        } else if ( intent.getStringExtra("StoreName").equals("스타벅스")){
            items.add(new AllergyMenuItem("딸기 딜라이트 요거트 블렌디드", "우유"));
        } else if ( intent.getStringExtra("StoreName").equals("한솥도시락")){
            items.add(new AllergyMenuItem("치킨마요덮밥", "난류, 우유, 대두, 밀, 돼지고기, 닭고기, 조개류"));
        } else if ( intent.getStringExtra("StoreName").equals("홍콩반점")){
            items.add(new AllergyMenuItem("짜장면", " "));
        }

        //클릭이벤트처리
        adapter.setOnItemClickListener(new AllergyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Snackbar.make(v, "메뉴가 눌렸습니다.", Snackbar.LENGTH_LONG).show();
            }
        });

        adapter.notifyDataSetChanged();
    }

    public static class AllergyAdapter extends RecyclerView.Adapter<AllergyAdapter.ViewHolder>{
        ArrayList<AllergyMenuItem> items = new ArrayList<AllergyMenuItem>();

        AllergyAdapter(ArrayList<AllergyMenuItem> list) {
            items = list;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.allergy_menu_view, parent,false);
            AllergyAdapter.ViewHolder vh = new AllergyAdapter.ViewHolder(view);

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
        public void onBindViewHolder(MenuListActivity.AllergyAdapter.ViewHolder holder, int position) {
            AllergyMenuItem item = items.get(position);

            holder.menuName.setText(item.getMenuName());
            holder.allergyInfo.setText(item.getAllergyInfo());
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        // 뷰홀더 클래스 정의
        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView menuName ;
            TextView allergyInfo;

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
                menuName = itemView.findViewById(R.id.allergyMenuName);
                allergyInfo = itemView.findViewById(R.id.allergyInformation);
            }
        }
    }
}