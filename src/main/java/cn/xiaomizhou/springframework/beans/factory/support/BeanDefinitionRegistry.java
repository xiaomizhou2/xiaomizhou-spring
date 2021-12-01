package cn.xiaomizhou.springframework.beans.factory.support;

import cn.xiaomizhou.springframework.beans.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注册 BeanDefinition
     *
     * @param beanName
     * @param beanDefinition
     */
    void registryBeanDefinition(String beanName, BeanDefinition beanDefinition);

}
