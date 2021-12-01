package cn.xiaomizhou.springframework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 *     代表Bean对象工厂，可以存放Bean定义到Map中以及获取
 * </p>
 * @author Yaxi Zhang
 * @date 2021/12/1
 */
public class BeanFactory {

    //存放bean 定义对象的容器
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    /**
     * 根据bean名称获取bean对象
     *
     * @param name
     * @return
     */
    public Object getBean(String name) {
        return this.beanDefinitionMap.get(name).getBean();
    }

    /**
     * 将bean 的定义注册到容器中
     *
     * @param name
     * @param beanDefinition
     */
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        this.beanDefinitionMap.put(name, beanDefinition);
    }
}
