package cn.xiaomizhou.springframework.test;

import cn.xiaomizhou.springframework.beans.factory.config.BeanDefinition;
import cn.xiaomizhou.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.xiaomizhou.springframework.test.bean.UserService;
import org.junit.Test;


/**
 * @author Yaxi Zhang
 * @date 2021/12/1
 */
public class ApiTest {

    @Test
    public void test_factory() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        factory.registryBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) factory.getBean("userService");
        userService.queryUserInfo();
    }
}
