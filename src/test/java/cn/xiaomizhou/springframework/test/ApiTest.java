package cn.xiaomizhou.springframework.test;

import cn.xiaomizhou.springframework.BeansException;
import cn.xiaomizhou.springframework.factory.config.BeanDefinition;
import cn.xiaomizhou.springframework.factory.support.DefaultListableBeanFactory;
import cn.xiaomizhou.springframework.test.bean.UserService;
import org.junit.Test;

public class ApiTest {

    @Test
    public void test_beanFactory() throws BeansException {
        //初始化beanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //注册bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        //获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.query();
    }
}
