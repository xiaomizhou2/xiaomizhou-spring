package cn.xiaomizhou.springframework.test.bean;

/**
 * @author Yaxi Zhang
 * @date 2021/12/1
 */
public class UserService {

    private String uid;

    private UserDao userDao;

   public void queryUserInfo() {
       System.out.println("查询用户信息：" + userDao.queryUserName(uid));
   }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
