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
    public void test_BeanFactoryPostProcessorAndBeanPostProcessor() {
        //1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //2.读取配置文件，注册bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        //3.BeanDefinition 加载完成 & Bean 实例化之前，修改 BeanDefinition 的属性
        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        //4.Bean 实例化后修改 Bean 的属性
        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);

        UserService userService = beanFactory.getBean("userService", UserService.class);
        userService.queryUserInfo();

        System.out.println(userService);
    }

    @Test
    public void test_xml() {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("classpath:spring-post-processor.xml");

        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.queryUserInfo();
        System.out.println(userService);
    }
}
