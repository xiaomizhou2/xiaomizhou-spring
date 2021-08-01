package cn.xiaomizhou.springframework.factory.support;

import cn.xiaomizhou.springframework.BeansException;
import cn.xiaomizhou.springframework.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry{
    //存放bean定义的容器
    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    /**
     * 根据名称获取bean的定义
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);

        if (beanDefinition == null) throw new BeansException("No bean named '" + beanName + "' is defined");

        return beanDefinition;
    }

    /**
     * 注册bean的定义
     * @param beanName
     * @param beanDefinition
     */
    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }
}
