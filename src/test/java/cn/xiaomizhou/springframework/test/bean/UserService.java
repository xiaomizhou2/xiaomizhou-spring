package cn.xiaomizhou.springframework.test.bean;

/**
 * @author Yaxi Zhang
 * @date 2021/12/1
 */
public class UserService {

    private String uid;
    private IUserDao userDao;
    private String company;
    private String location;

    public String queryUserInfo() {
        return userDao.queryUserName(uid) + "," + company + "," + location;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
