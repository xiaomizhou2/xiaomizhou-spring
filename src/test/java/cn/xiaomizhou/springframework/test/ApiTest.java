package cn.xiaomizhou.springframework.test;

import cn.hutool.core.io.IoUtil;
import cn.xiaomizhou.springframework.beans.PropertyValue;
import cn.xiaomizhou.springframework.beans.PropertyValues;
import cn.xiaomizhou.springframework.beans.factory.config.BeanDefinition;
import cn.xiaomizhou.springframework.beans.factory.config.BeanReference;
import cn.xiaomizhou.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.xiaomizhou.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import cn.xiaomizhou.springframework.context.support.ClassPathXmlApplicationContext;
import cn.xiaomizhou.springframework.core.io.DefaultResourceLoader;
import cn.xiaomizhou.springframework.core.io.Resource;
import cn.xiaomizhou.springframework.test.bean.UserDao;
import cn.xiaomizhou.springframework.test.bean.UserService;
import cn.xiaomizhou.springframework.test.common.MyBeanFactoryPostProcessor;
import cn.xiaomizhou.springframework.test.common.MyBeanPostProcessor;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;


/**
 * @author Yaxi Zhang
 * @date 2021/12/1
 */
public class ApiTest {

    @Test
    public void test_xml() {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.queryUserInfo();
        System.out.println(userService);
    }
}
