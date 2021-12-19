package cn.xiaomizhou.springframework.test;

import cn.xiaomizhou.springframework.aop.AdvisedSupport;
import cn.xiaomizhou.springframework.aop.TargetSource;
import cn.xiaomizhou.springframework.aop.aspectj.AspectJExpressionPointcut;
import cn.xiaomizhou.springframework.aop.framework.Cglib2AopProxy;
import cn.xiaomizhou.springframework.aop.framework.JdkDynamicAopProxy;
import cn.xiaomizhou.springframework.context.support.ClassPathXmlApplicationContext;
import cn.xiaomizhou.springframework.test.bean.IUserService;
import cn.xiaomizhou.springframework.test.bean.UserService;
import cn.xiaomizhou.springframework.test.bean.UserServiceInterceptor;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * @author Yaxi Zhang
 * @date 2021/12/1
 */
public class ApiTest {

    @Test
    public void test_dynamic() {
        IUserService userService = new UserService();

        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(userService));
        advisedSupport.setMethodInterceptor(new UserServiceInterceptor());
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* cn.xiaomizhou.springframework.test.bean" +
                ".IUserService.*(..))"));

        IUserService proxy_jdk = (IUserService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        System.out.println("测试结果：" + proxy_jdk.queryUserInfo());

        IUserService proxy_cglib = (IUserService) new Cglib2AopProxy(advisedSupport).getProxy();
        System.out.println("测试结果：" + proxy_cglib.register("zyx"));
    }
}
