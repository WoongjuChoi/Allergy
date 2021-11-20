package com.example.allergy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MenuListActivity extends AppCompatActivity {
    ArrayList<AllergyMenuItem> items = new ArrayList<AllergyMenuItem>();    // 받아온 메뉴 전체를 저장
    public static ArrayList<AllergyMenuItem> allergyItems = new ArrayList<AllergyMenuItem>(); // 알러지에 해당하는 메뉴들
    public static ArrayList<AllergyMenuItem> nonAllergyItems = new ArrayList<AllergyMenuItem>();  // 알러지에 해당하지 않는 메뉴들
    public static ArrayList<AllergyMenuItem> allItems;
    public static String testString= "[{\"ingredient\":\"밀, 소고기, 닭고기\",\"name\":\"몬스터와퍼\"},{\"ingredient\":\"밀, 소고기\",\"name\":\"스태커와퍼\"},{\"ingredient\":\"밀, 소고기\",\"name\":\"와퍼\"},{\"ingredient\":\"밀, 소고기, 새우\",\"name\":\"통새우 와퍼\"}]";

    public static ArrayList<String> head = new ArrayList<String>(); // 서버에서 받은 메뉴 이름들
    public static ArrayList<String> body = new ArrayList<String>(); // 서버에서 받은 알러지유발성분 정보들

    SharedPreferences.Editor prefEditor;
    SharedPreferences prefs;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_list_view);
        prefs = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        prefEditor = prefs.edit();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        SeparateAllergyMenu(items);
        AllergyAdapter adapter = new AllergyAdapter(nonAllergyItems);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); //리사이클러뷰에 리니어레이아웃매니저 지정

        TextView storeName = (TextView) findViewById(R.id.StoreName); //가게 이름
        ImageView storeLogo = (ImageView)findViewById(R.id.StoreLogo); //가게 로고

        Button allergyMenuButton = (Button) findViewById(R.id.allergyMenuButton); // 알러지 유발메뉴 버튼
        Button EntireMenuButton = (Button) findViewById(R.id.entireMenuButton); // 전체 메뉴 버튼

        Intent intent = getIntent(); //인텐트 가져온다
        storeName.setText(intent.getStringExtra("StoreName")); //인텐트로 받은 가게이름 세팅
        storeLogo.setImageResource(intent.getIntExtra("StoreImage", 0)); //인텐트로 받은 가게로고 세팅

        if (intent.getStringExtra("StoreName").equals("맥도날드")) { //가게 이름이 맥도날드이면
            items.clear();
            items.add(new AllergyMenuItem("창녕 갈릭 버거", "난류, 우유, 대두, 밀, 토마토, 쇠고기, 조개류"));
            items.add(new AllergyMenuItem("빅맥", "난류, 우유, 대두, 밀, 쇠고기"));
            items.add(new AllergyMenuItem("필레 오 피쉬", "난류, 우유, 대두, 밀"));
            items.add(new AllergyMenuItem("더블 필레 오 피쉬", "난류, 우유, 대두, 밀"));
            items.add(new AllergyMenuItem("1955 버거", "난류, 우유, 대두, 밀, 돼지고기, 토마토, 쇠고기"));
            items.add(new AllergyMenuItem("맥스파이시 상하이 버거", "난류, 대두, 밀, 토마토, 닭고기"));
            items.add(new AllergyMenuItem("맥치킨", "난류, 대두, 밀, 닭고기"));
            items.add(new AllergyMenuItem("맥치킨 모짜렐라", "난류, 우유, 대두, 밀, 토마토, 닭고기"));
            items.add(new AllergyMenuItem("더블 불고기 버거", "난류, 우유, 대두, 밀, 돼지고기, 조개, 조개류"));
            items.add(new AllergyMenuItem("에그 불고기 버거", "난류, 대두, 밀, 돼지고기, 조개, 조개류"));
            items.add(new AllergyMenuItem("불고기 버거", "난류, 대두, 밀, 돼지고기, 조개, 조개류"));
            items.add(new AllergyMenuItem("슈슈 버거", "난류, 우유, 대두, 밀, 토마토, 새우, 쇠고기, 조개류"));
            items.add(new AllergyMenuItem("슈비 버거", "난류, 우유, 대두, 밀, 토마토, 새우, 쇠고기, 조개류"));
            items.add(new AllergyMenuItem("베이컨 토마도 디럭스", "난류, 우유, 대두, 밀, 돼지고기, 토마토, 쇠고기"));
            items.add(new AllergyMenuItem("더블 쿼터파운더 치즈", "우유, 대두, 밀, 토마토, 쇠고기"));
            items.add(new AllergyMenuItem("쿼터파운더 치즈", "우유, 대두, 밀, 토마토, 쇠고기"));
            items.add(new AllergyMenuItem("치즈버거", "우유, 대두, 밀, 토마토, 쇠고기"));
            items.add(new AllergyMenuItem("더블 치즈버거", "우유, 대두, 밀, 토마토, 쇠고기"));
            items.add(new AllergyMenuItem("햄버거", "대두, 밀, 토마토, 쇠고기"));
        } else if ( intent.getStringExtra("StoreName").equals("버거킹")){
            items.clear();
//              for (int i = 0; i < head.size(); ++i)
//              {
//                items.add(new AllergyMenuItem(head.get(i), body.get(i)));
//              }
//
//            try {
//                String result;
//                Menu task = new Menu();
//                result = task.execute(intent.getStringExtra("StoreName")).get(); //데이터 전송 후 결과 값 받기
//                Log.d("데이터", result);
//                System.out.println(result);
//            } catch (Exception e) {
//
//            }
           JSONParse(testString); // Json to items 함수호출
           System.out.println("실행성공");
           SeparateAllergyMenu(items); // 알러지에 따라 메뉴 분리
        } else if ( intent.getStringExtra("StoreName").equals("도미노")){
            items.clear();
            items.add(new AllergyMenuItem("블록버스터", "계란, 대두, 밀, 돼지고기, 닭고기, 토마토, 우유, 새우, 쇠고기, 오징어, 바닷가재, 게, 조개류"));
            SeparateAllergyMenu(items);
        } else if ( intent.getStringExtra("StoreName").equals("BBQ")){
            items.clear();
            items.add(new AllergyMenuItem("반반치킨", "우유, 대두, 밀, 조개류, 쇠고기, 새우, 땅콩"));
            SeparateAllergyMenu(items);
        } else if ( intent.getStringExtra("StoreName").equals("스타벅스")){
            items.clear();
            items.add(new AllergyMenuItem("딸기 딜라이트 요거트 블렌디드", "우유"));
            SeparateAllergyMenu(items);
        } else if ( intent.getStringExtra("StoreName").equals("한솥도시락")){
            items.clear();
            items.add(new AllergyMenuItem("치킨마요덮밥", "난류, 우유, 대두, 밀, 돼지고기, 닭고기, 조개류"));
            SeparateAllergyMenu(items);
        } else if ( intent.getStringExtra("StoreName").equals("홍콩반점")){
            items.clear();
            items.add(new AllergyMenuItem("짜장면", ""));
            SeparateAllergyMenu(items);
        } else {
            items.clear();
            List<String> allergies = ReadAllergyData(); // 로컬에 저장된 유저가 등록하려던 알러지정보
            String str = String.join(",",allergies); // ArrayList to String
            items.add(new AllergyMenuItem(prefs.getString("menuName",""), str));
            SeparateAllergyMenu(items);
        }

        SeparateAllergyMenu(items); // 알러지 여부에 따라 분리

        allItems = items; // 다른 클래스에 넘겨주기 위한 전체 메뉴 리스트


        //클릭이벤트처리
        allergyMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), AllergyMenuActivity.class);

                intent1.putExtra("StoreName1",intent.getStringExtra("StoreName")); /*송신*/
                intent1.putExtra("StoreImage1",intent.getIntExtra("StoreImage", 0));

                startActivity(intent1);
            }
        });

        EntireMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), EntireMenuActivity.class);

                intent2.putExtra("StoreName2",intent.getStringExtra("StoreName")); /*송신*/
                intent2.putExtra("StoreImage2",intent.getIntExtra("StoreImage", 0));

                startActivity(intent2);
            }
        });

        adapter.setOnItemClickListener(new AllergyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Snackbar.make(v, "메뉴가 눌렸습니다.", Snackbar.LENGTH_LONG).show();
            }
        });

        adapter.notifyDataSetChanged();
    }
    public void JSONParse(String jsonStr){ //Json to items 함수

        try {
            JSONArray jsonArray = new JSONArray(jsonStr);
            for(int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name = jsonObject.getString("name");
                String ingredient = jsonObject.getString("ingredient");
                AllergyMenuItem item = new AllergyMenuItem(name,ingredient);
                items.add(item);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
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
        public void  filterList(ArrayList<AllergyMenuItem> list) {
            items = list;
            notifyDataSetChanged();
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
    public  ArrayList<String> ReadAllergyData() {
        SharedPreferences sharedPrefs = getSharedPreferences("pref",MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPrefs.getString("allergyResister", "EMPTY");
        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();
        ArrayList<String> arrayList = gson.fromJson(json, type);
        return arrayList;
    }


    public void SeparateAllergyMenu(ArrayList<AllergyMenuItem> item) {
        allergyItems.clear();
        nonAllergyItems.clear();
        ArrayList<String> allergies = UserInfoSetting.allergyList; // 사용자의 알러지정보를 저장한 문자열 ArrayList
        int isAllergy = 0;
        for(AllergyMenuItem i : item) {
            for(String j : allergies) {
                if (i.allergy.contains(j)) { // 메뉴가 사용자 알러지정보와 일치하는 알러지정보를 가지고있으면
                    MenuListActivity.allergyItems.add(i); // 알러지 메뉴 리스트에 추가
                    isAllergy = 1;
                }
            }
            if(isAllergy == 0) { // for문을 도는동안 알러지에 걸린것이 없다면
                MenuListActivity.nonAllergyItems.add(i); // 알러지 없는 메뉴에 추가
            }
            else {
                isAllergy = 0;
            }
        }
        System.out.println(nonAllergyItems);
    }
}