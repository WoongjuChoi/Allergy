package com.example.allergy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class FastFoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fast_food);

        ListView listView3 = (ListView) findViewById(R.id.fastList);

        FastFoodActivity.FastMenuAdapter fastMenuAdapter = new FastFoodActivity.FastMenuAdapter();

        fastMenuAdapter.addItem(new McMenuItem("맥도날드", R.drawable.logo));

        listView3.setAdapter(fastMenuAdapter);
    }


    class FastMenuAdapter extends BaseAdapter {
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