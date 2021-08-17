package com.example.allergy;

import java.util.ArrayList;

public class AllergyMenuItem {
    String menuName; // 메뉴이름
    String allergyInfo; // 전체 알러지 정보를 저장
    String[] allergyArray; // split으로 잘라서 임시로 저장할 배열
    ArrayList<String> allergy = new ArrayList<String>(); // 알러지 정보를 저장할 컬렉션 프레임워크

    AllergyMenuItem(String name, String entireString) { //크롤링 된 문자열 한 줄을 받아서 생성자의 매개변수로 넣음
        menuName = name;
        allergyInfo = entireString;
        allergyArray = entireString.split(", "); // 문자열을 , 를 기준으로 잘라서 배열에 넣는다
        for(int i = 0; i < allergyArray.length; i++) {
            allergy.add(allergyArray[i]); //반복문을 돌며 배열의 알러지정보를 allergy에 저장
        }
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getAllergyInfo() {
        return allergyInfo;
    }

    public void setAllergyInfo(String allergyInfo) {
        this.allergyInfo = allergyInfo;
    }
}
