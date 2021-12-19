package cn.xiaomizhou.springframework.test.bean;

import java.util.Random;

/**
 * @description:
 * @author: zyx
 * @create: 2021-12-19 13:39
 **/
public class UserService implements IUserService {
    @Override
    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "小米粥";
    }

    @Override
    public String register(String userName) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "注册用户：" + userName + "success!";
    }
}
