package cn.xiaomizhou.springframework.beans.factory.support;

import cn.xiaomizhou.springframework.beans.BeansException;
import cn.xiaomizhou.springframework.beans.factory.FactoryBean;
import cn.xiaomizhou.springframework.beans.factory.config.BeanDefinition;
import cn.xiaomizhou.springframework.beans.factory.config.BeanPostProcessor;
import cn.xiaomizhou.springframework.beans.factory.config.ConfigurableBeanFactory;
import cn.xiaomizhou.springframework.util.ClassUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yaxi Zhang
 * @date 2021/12/1
 */
public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableBeanFactory {

    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();

    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

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
       return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    protected <T> T doGetBean(final String name, final Object[] args) {
        Object sharedInstance = getSingleton(name);

        if (sharedInstance != null) {
            return (T) getObjectForBeanInstance(sharedInstance, name);
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        Object bean = createBean(name, beanDefinition, args);
        return (T) getObjectForBeanInstance(bean, name);
    }

    private Object getObjectForBeanInstance(Object sharedInstance, String name) {
        if (!(sharedInstance instanceof FactoryBean)) {
            return sharedInstance;
        }

        Object object = getCachedObjectForFactoryBean(name);

        if (object == null) {
            FactoryBean<?> factoryBean = (FactoryBean<?>) sharedInstance;
            object = getObjectFromFactoryBean(factoryBean, name);
        }

        return object;
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }

    public ClassLoader getBeanClassLoader() {
        return this.beanClassLoader;
    }
}
