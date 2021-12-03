package cn.xiaomizhou.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import cn.xiaomizhou.springframework.beans.BeansException;
import cn.xiaomizhou.springframework.beans.PropertyValue;
import cn.xiaomizhou.springframework.beans.PropertyValues;
import cn.xiaomizhou.springframework.beans.factory.config.BeanDefinition;
import cn.xiaomizhou.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

/**
 * @author Yaxi Zhang
 * @date 2021/12/1
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {


    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

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
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
            //创建完bean后，填充属性
            applyPropertyValues(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        addSingleton(beanName, bean);
        return bean;
    }


    /**
     * 通过实例化进行创建Bean
     *
     * @param beanDefinition
     * @param beanName
     * @param args
     * @return
     */
    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor constructorToUse = null;

        /**
         * <P>
         *      接下来就需要循环比对出构造函数集合与入参信息 args 的匹配情况，这里我们
         *      对比的方式比较简单，只是一个数量对比，而实际 Spring 源码中还需要比对入参
         *      类型，否则相同数量不同入参类型的情况，就会抛异常了
         * </P>
         */
        Class beanClass = beanDefinition.getBeanClass();
        Constructor[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor constructor : declaredConstructors) {
            if (null != args && constructor.getParameterTypes().length == args.length) {
                constructorToUse = constructor;
                break;
            }
        }

        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    /**
     * 对 Bean 的属性填充
     * @param beanName
     * @param bean
     * @param beanDefinition
     */
    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                if (value instanceof BeanReference) {
                    //如果是Bean的引用，获取Bean的实例化
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }

                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values: " + beanName);
        }
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
