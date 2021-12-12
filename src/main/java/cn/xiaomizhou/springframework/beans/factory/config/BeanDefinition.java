package cn.xiaomizhou.springframework.beans.factory.config;

import cn.xiaomizhou.springframework.beans.PropertyValue;
import cn.xiaomizhou.springframework.beans.PropertyValues;

/**
 * <p>
 *
 * </p>
 * @author Yaxi Zhang
 * @date 2021/12/1
 */
public class BeanDefinition {

    private Class beanClass;

    private PropertyValues propertyValues;

    /**
     * <p>
     *     新增两个属性 initMethodName destroyMethodName
     *     这两个属性是为了在spring.xml配置的Bean对象中，可以配置init-method destroy-method
     * </p>
     */
    private String initMethodName;

    private String destroyMethodName;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public String getInitMethodName() {
        return initMethodName;
    }

    public void setInitMethodName(String initMethodName) {
        this.initMethodName = initMethodName;
    }

    public String getDestroyMethodName() {
        return destroyMethodName;
    }

    public void setDestroyMethodName(String destroyMethodName) {
        this.destroyMethodName = destroyMethodName;
    }
}
