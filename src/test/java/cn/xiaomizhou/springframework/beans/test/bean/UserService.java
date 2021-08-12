package cn.xiaomizhou.springframework.beans.test.bean;

public class UserService {

    private String uid;

    private UserDao userDao;

    public void query() {
        System.out.println("查询用户信息：" + userDao.queryUserName(uid));
    }
}
