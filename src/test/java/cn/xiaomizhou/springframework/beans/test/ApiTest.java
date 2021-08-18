package cn.xiaomizhou.springframework.beans.test;

import cn.xiaomizhou.springframework.beans.BeansException;
import cn.xiaomizhou.springframework.beans.PropertyValue;
import cn.xiaomizhou.springframework.beans.PropertyValues;
import cn.xiaomizhou.springframework.beans.factory.config.BeanDefinition;
import cn.xiaomizhou.springframework.beans.factory.config.BeanReference;
import cn.xiaomizhou.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.xiaomizhou.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import cn.xiaomizhou.springframework.beans.test.bean.UserDao;
import cn.xiaomizhou.springframework.beans.test.bean.UserService;
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

    @Test
    public void test_beanFactory2() throws BeansException {
        //初始化beanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //注册bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService", "小米粥");
        userService.query();
    }

    @Test
    public void test_beanFactory3() {
        //初始化beanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uid", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.query();
    }

    @Test
    public void test_xml() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //读取配置文件&注册bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        UserService userService = (UserService) beanFactory.getBean("userService", UserService.class);
        userService.query();
    }
}
