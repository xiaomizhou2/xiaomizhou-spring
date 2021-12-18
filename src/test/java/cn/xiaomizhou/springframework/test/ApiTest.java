package cn.xiaomizhou.springframework.test;

import cn.xiaomizhou.springframework.context.support.ClassPathXmlApplicationContext;
import cn.xiaomizhou.springframework.test.event.CustomEvent;
import org.junit.Test;


/**
 * @author Yaxi Zhang
 * @date 2021/12/1
 */
public class ApiTest {

    @Test
    public void test_event() {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("classpath:spring.xml");

        applicationContext.publishEvent(new CustomEvent(applicationContext, 1000L, "成功!"));

        applicationContext.registerShutdownHook();
    }
}
