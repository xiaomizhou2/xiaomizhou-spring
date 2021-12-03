package cn.xiaomizhou.springframework.beans.factory.support;

import cn.xiaomizhou.springframework.beans.BeansException;
import cn.xiaomizhou.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Yaxi Zhang
 * @date 2021/12/3
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {

    /**
     * JDK实例化
     *
     * @param beanDefinition bean的定义
     * @param beanName       bean的名称
     * @param ctor           里面包含了一些必要类信息，为了拿到符合入参信息相对应的构造函数
     * @param args           入参列表
     * @return
     * @throws BeansException
     */
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Class clazz = beanDefinition.getBeanClass();

        try {
            if (null != ctor) {
                //Constructor不为空，代表是有构造参数实例化
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            }else {
                //Constructor为空,无构造参数实例化
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (InstantiationException | IllegalAccessException
                | InvocationTargetException | NoSuchMethodException e) {
            throw new BeansException("Failed to instantiate [" + clazz.getName() + "]", e);
        }
    }
}
