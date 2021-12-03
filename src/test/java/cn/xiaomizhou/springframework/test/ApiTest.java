package cn.xiaomizhou.springframework.test;

import cn.xiaomizhou.springframework.beans.PropertyValue;
import cn.xiaomizhou.springframework.beans.PropertyValues;
import cn.xiaomizhou.springframework.beans.factory.config.BeanDefinition;
import cn.xiaomizhou.springframework.beans.factory.config.BeanReference;
import cn.xiaomizhou.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.xiaomizhou.springframework.test.bean.UserDao;
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

        //UserDao注册
        factory.registryBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        //UserService 设置属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uid", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        factory.registryBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) factory.getBean("userService");
        userService.queryUserInfo();
    }
}
