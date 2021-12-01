package cn.xiaomizhou.springframework.beans.factory.support;

import cn.xiaomizhou.springframework.beans.BeansException;
import cn.xiaomizhou.springframework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * <P>
 *     注册 BeanDefinition 和 获取 BeanDefinition 的实现类
 * </P>
 * @author Yaxi Zhang
 * @date 2021/12/1
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);

        if (beanDefinition == null) throw new BeansException("No bean name is '" + beanName + "' is defined");

        return beanDefinition;
    }

    @Override
    public void registryBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }
}
