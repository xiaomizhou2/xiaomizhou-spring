package cn.xiaomizhou.springframework.test.bean;

public class UserService {

    private String name;

    public UserService(String name) {
        this.name = name;
    }

    public void query() {
        System.out.println("查询用户信息：" + name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append("").append(name);
        return sb.toString();
    }
}
