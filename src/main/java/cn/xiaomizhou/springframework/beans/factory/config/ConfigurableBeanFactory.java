package cn.xiaomizhou.springframework.beans.factory.config;

import cn.xiaomizhou.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * <p>
 *     获取 BeanPostProcessor BeanClassLoader的配置化接口
 * </p>
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    /**
     * 销毁单例对象
     */
    void destroySingletons();
}
