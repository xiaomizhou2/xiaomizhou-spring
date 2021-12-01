package cn.xiaomizhou.springframework;

/**
 * <p>
 *     用于定义Bean实例化信息，现在的实现是一个Obj存放对象
 * </p>
 * @author Yaxi Zhang
 * @date 2021/12/1
 */
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
