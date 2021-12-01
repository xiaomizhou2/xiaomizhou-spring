package cn.xiaomizhou.springframework.test;

import cn.xiaomizhou.springframework.BeanDefinition;
import cn.xiaomizhou.springframework.BeanFactory;
import cn.xiaomizhou.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * @author Yaxi Zhang
 * @date 2021/12/1
 */
public class ApiTest {

    @Test
    public void test_BeanFactory() {
        //1.初始化 BeanFactory
        BeanFactory factory = new BeanFactory();

        //2.注册bean
        BeanDefinition userBeanDefinition = new BeanDefinition(new UserService());
        factory.registerBeanDefinition("userService", userBeanDefinition);

        //3.获取bean
        UserService userService = (UserService) factory.getBean("userService");
        userService.queryUserInfo();
    }
}
