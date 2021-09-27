package com.example.allergy;

public class MainMenuItem {
    String menuName;
    int resId2;

    public MainMenuItem(String menuName, int resId2) {
        this.menuName = menuName;
        this.resId2 = resId2;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getResId() {
        return resId2;
    }

    public void setResId2(int resId2) {
        this.resId2 = resId2;
    }

    @Override
    public String toString() {
        return "MainMenuItem{" +
                "menuName='" + menuName + '\'' +
                ", resId2=" + resId2 +
                '}';
    }
}
