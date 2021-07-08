package com.example.allergy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class McMenuActivity extends AppCompatActivity {
    ArrayList<MainMenuItem> items = new ArrayList<MainMenuItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mc_menu);

        ListView listView = (ListView) findViewById(R.id.listView);

        MenuAdapter adapter = new MenuAdapter();
        McMenuActivity.MenuAdapter adapter2 = new McMenuActivity.MenuAdapter();

        TextView storeName = (TextView) findViewById(R.id.StoreName); //가게 이름
        ImageView storeLogo = (ImageView)findViewById(R.id.StoreLogo); //가게 로고

        Intent intent = getIntent(); //인텐트 가져온다
        storeName.setText(intent.getStringExtra("StoreName")); //인텐트로 받은 가게이름 세팅
        storeLogo.setImageResource(intent.getIntExtra("StoreImage", 0)); //인텐트로 받은 가게로고 세팅

        if (intent.getStringExtra("StoreName").equals("맥도날드")) { //가게 이름이 맥도날드이면
            adapter2.addItem(new McMenuItem("빅맥 베이컨", R.drawable.bigmacbacon));
            adapter2.addItem(new McMenuItem("빅맥", R.drawable.bigmac));
            adapter2.addItem(new McMenuItem("필레 오 피쉬", R.drawable.filet));
            adapter2.addItem(new McMenuItem("더블 필레 오 피쉬", R.drawable.doublefilet));
            adapter2.addItem(new McMenuItem("1955 버거", R.drawable.nineteenfiftyfive));
            adapter2.addItem(new McMenuItem("맥스파이시 상하이 버거", R.drawable.shanghai));
            adapter2.addItem(new McMenuItem("맥치킨", R.drawable.mcchicken));
            adapter2.addItem(new McMenuItem("맥치킨 모짜렐라", R.drawable.mcchickienmozzarella));
            adapter2.addItem(new McMenuItem("더블 불고기 버거", R.drawable.doublebulgogi));
            adapter2.addItem(new McMenuItem("에그 불고기 버거", R.drawable.eggbulgogi));
            adapter2.addItem(new McMenuItem("불고기 버거", R.drawable.bulgogi));
            adapter2.addItem(new McMenuItem("슈슈 버거", R.drawable.supremeshrimp));
            adapter2.addItem(new McMenuItem("슈비 버거", R.drawable.shrimpbeef));
            adapter2.addItem(new McMenuItem("베이컨 토마도 디럭스", R.drawable.bacontomato));
            adapter2.addItem(new McMenuItem("더블 쿼터파운더 치즈", R.drawable.doublequarterpoundercheese));
            adapter2.addItem(new McMenuItem("쿼터파운더 치즈", R.drawable.quarterpoundercheese));
            adapter2.addItem(new McMenuItem("치즈버거", R.drawable.cheese));
            adapter2.addItem(new McMenuItem("더블 치즈버거", R.drawable.doublecheese));
            adapter2.addItem(new McMenuItem("햄버거", R.drawable.hamburger));
        } else if ( intent.getStringExtra("StoreName").equals("버거킹")){
            adapter2.addItem(new McMenuItem("와퍼", R.drawable.burgerking_whopper));
        } else if ( intent.getStringExtra("StoreName").equals("도미노")){
            adapter2.addItem(new McMenuItem("블록버스터", R.drawable.pizza_domino_blockbuster));
        } else if ( intent.getStringExtra("StoreName").equals("BBQ")){
            adapter2.addItem(new McMenuItem("반반치킨", R.drawable.chicken_bbq_banban));
        } else if ( intent.getStringExtra("StoreName").equals("스타벅스")){
            adapter2.addItem(new McMenuItem("딸기레몬블렌디드", R.drawable.dessert_starbucks_strawberrylemonblended));
        } else if ( intent.getStringExtra("StoreName").equals("한솥도시락")){
            adapter2.addItem(new McMenuItem("치킨마요덮밥", R.drawable.lunchbox_hansot_chickenmayo));
        } else if ( intent.getStringExtra("StoreName").equals("홍콩반점")){
            adapter2.addItem(new McMenuItem("짜장면", R.drawable.jajanmyeon_hongkong_jajanmyeon));
        }

        listView.setAdapter(adapter2);
    }

    class MenuAdapter extends BaseAdapter {
        ArrayList<McMenuItem> items = new ArrayList<McMenuItem>();

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
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        public void addItem(McMenuItem item) {
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

            McMenuItem item = items.get(position);
            view.setName(item.getName());
            view.setIcon(item.getResId());

            return view;
        }
    }
}