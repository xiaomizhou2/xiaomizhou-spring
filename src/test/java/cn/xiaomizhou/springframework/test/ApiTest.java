package cn.xiaomizhou.springframework.test;

import cn.xiaomizhou.springframework.context.support.ClassPathXmlApplicationContext;
import cn.xiaomizhou.springframework.test.bean.UserService;
import org.junit.Test;


/**
 * @author Yaxi Zhang
 * @date 2021/12/1
 */
public class ApiTest {

    @Test
    public void test_prototype() {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        UserService userService01 = applicationContext.getBean("userService", UserService.class);
        UserService userService02 = applicationContext.getBean("userService", UserService.class);
        System.out.println(userService01);
        System.out.println(userService02);
    }

    @Test
    public void test_factory_bean() {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }
}
