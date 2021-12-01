package cn.xiaomizhou.springframework.beans.factory.config;

/**
 * <p>
 *
 * </p>
 * @author Yaxi Zhang
 * @date 2021/12/1
 */
public class BeanDefinition {

    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
