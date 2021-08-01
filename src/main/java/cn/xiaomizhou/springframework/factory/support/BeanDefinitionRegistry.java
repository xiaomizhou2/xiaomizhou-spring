package cn.xiaomizhou.springframework.factory.support;

import cn.xiaomizhou.springframework.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
