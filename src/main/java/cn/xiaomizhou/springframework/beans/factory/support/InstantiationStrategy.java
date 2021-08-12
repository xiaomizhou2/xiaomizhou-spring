package cn.xiaomizhou.springframework.beans.factory.support;

import cn.xiaomizhou.springframework.beans.BeansException;
import cn.xiaomizhou.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 实例化策略接口
 */
public interface InstantiationStrategy {

    /**
     * bean实例化
     *
     * @param beanDefinition bean的定义
     * @param BeanName bean的名称
     * @param constructor 包含一些必要的类信息
     * @param args 入参参数列表
     * @return
     * @throws BeansException
     */
    Object instantiate(BeanDefinition beanDefinition, String BeanName, Constructor constructor, Object[] args);
}
