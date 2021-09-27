package com.example.allergy;

import java.util.HashMap;
import java.util.Map;

public class UserInfoManager {
    private Map<String, String> map = null; //Map<email,pwd>
    public UserInfoManager(){
        this.map = new HashMap<>();
    }
    public void putUserInfo(String email, String pwd){
        map.put(email,pwd);
    }
}
