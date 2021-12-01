package cn.xiaomizhou.springframework.beans.factory.support;

import cn.xiaomizhou.springframework.beans.BeansException;
import cn.xiaomizhou.springframework.beans.factory.config.BeanDefinition;

/**
 * @author Yaxi Zhang
 * @date 2021/12/1
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    /**
     * 根据Bean Name 和 Bean 定义类创建Bean对象
     * <p>
     *     1.通过 BeanDefinition 获取 BeanClass 对象去创建 Bean 对象
     *     2.加入到 Bean 对象单例容器中
     *     3.返回 Bean 对象
     * </p>
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

        addSingleton(beanName, bean);
        return bean;
    }
}
