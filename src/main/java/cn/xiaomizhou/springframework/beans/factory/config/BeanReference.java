package cn.xiaomizhou.springframework.beans.factory.config;

/**
 * Bean 的引用类
 *
 * @author Yaxi Zhang
 * @date 2021/12/3
 */
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
