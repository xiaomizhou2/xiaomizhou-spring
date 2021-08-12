package cn.xiaomizhou.springframework.beans.test.bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "小米粥");
        hashMap.put("10002", "卓琳");
        hashMap.put("10003", "阿超");
    }

    public String queryUserName(String uid) {
        return hashMap.get(uid);
    }
}
