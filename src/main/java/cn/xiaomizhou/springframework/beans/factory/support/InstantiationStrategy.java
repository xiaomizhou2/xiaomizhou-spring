package cn.xiaomizhou.springframework.beans.factory.support;

import cn.xiaomizhou.springframework.beans.BeansException;
import cn.xiaomizhou.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;


public interface InstantiationStrategy {

    /**
     * 实例化策略接口
     *
     * @param beanDefinition bean的定义
     * @param beanName bean的名称
     * @param ctor 里面包含了一些必要类信息，为了拿到符合入参信息相对应的构造函数
     * @param args 入参列表
     * @return
     * @throws BeansException
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;

}
