package cn.xiaomizhou.springframework.beans.factory.support;

import cn.xiaomizhou.springframework.beans.BeansException;
import cn.xiaomizhou.springframework.beans.factory.BeanFactory;
import cn.xiaomizhou.springframework.beans.factory.config.BeanDefinition;
import cn.xiaomizhou.springframework.beans.factory.config.DefaultSingletonBeanRegistry;

/**
 *
 * @author Yaxi Zhang
 * @date 2021/12/1
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    /**
     * 根据Bean名称获取Bean对象
     * <p>
     *     1.根据 name 通过 DefaultSingletonBeanRegistry 父类的 getSingleton 方法去获取Bean 对象
     *     2.判断 Bean 对象是否存在
     *     3.不存在，先去获取 Bean 的定义类
     *     4.根据 Bean名称和定义去创建Bean对象
     * </p>
     * @param name
     * @return
     * @throws BeansException
     */
    @Override
    public Object getBean(String name) throws BeansException {
        Object bean = getSingleton(name);

        if (bean != null) {
            return bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);

        return createBean(name, beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;
}
