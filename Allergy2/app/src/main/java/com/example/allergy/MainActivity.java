package com.example.allergy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView) findViewById(R.id.gridView);

        MainAdapter adapter = new MainAdapter();

        adapter.addItem(new MainMenuItem("패스트푸드", R.drawable.burger));
        adapter.addItem(new MainMenuItem("피자", R.drawable.pizza));
        adapter.addItem(new MainMenuItem("치킨", R.drawable.chicken));
        adapter.addItem(new MainMenuItem("디저트", R.drawable.dessert));
        adapter.addItem(new MainMenuItem("분식", R.drawable.tteokbokki));
        adapter.addItem(new MainMenuItem("도시락", R.drawable.lunchbox));
        adapter.addItem(new MainMenuItem("중국집", R.drawable.jajangmyeon));

        gridView.setAdapter(adapter);

        Button mcbutton = (Button) findViewById(R.id.mcdonald);
        mcbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), McMenuActivity.class);
                startActivityForResult(intent, 101);
            }
        });
    }

    class MainAdapter extends BaseAdapter {
        ArrayList<MainMenuItem> items = new ArrayList<MainMenuItem>();

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

        public void addItem(MainMenuItem item) {
            items.add(item);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            MainMenuView view = null;
            if (convertView == null) {
                view = new MainMenuView(getApplicationContext());
            } else {
                view = (MainMenuView) convertView;
            }

            MainMenuItem item = items.get(position);
            view.setmName(item.getMenuName());
            view.setmImage(item.getResId2());

            LinearLayout cmdArea = (LinearLayout) convertView.findViewById(R.id.cmdArea);
            cmdArea.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), McMenuActivity.class);
                    startActivityForResult(intent, 101);
                }
            });

            return view;
        }
    }
}