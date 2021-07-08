package com.example.allergy;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class McMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mc_menu);

        ListView listView = (ListView) findViewById(R.id.listView);

        McMenuActivity.MenuAdapter adapter2 = new McMenuActivity.MenuAdapter();

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