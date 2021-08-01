package cn.xiaomizhou.springframework.factory.support;

import cn.xiaomizhou.springframework.BeansException;
import cn.xiaomizhou.springframework.factory.config.BeanDefinition;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    /**
     * 根据bean的名称和实体类创建单例的bean实例
     * @param beanName
     * @param beanDefinition
     * @return
     * @throws BeansException
     */
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        //将bean的示例添加到容器
        addSingleton(beanName, bean);

        return bean;
    }
}
