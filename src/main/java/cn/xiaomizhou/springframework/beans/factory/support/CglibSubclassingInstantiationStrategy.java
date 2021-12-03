package cn.xiaomizhou.springframework.beans.factory.support;

import cn.xiaomizhou.springframework.beans.BeansException;
import cn.xiaomizhou.springframework.beans.factory.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * @author Yaxi Zhang
 * @date 2021/12/3
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {

    /**
     * cglib实例化
     *
     * @param beanDefinition bean的定义
     * @param beanName bean的名称
     * @param ctor 里面包含了一些必要类信息，为了拿到符合入参信息相对应的构造函数
     * @param args 入参列表
     * @return
     * @throws BeansException
     */
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());

        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });

        if (null == ctor) return enhancer.create();

        return enhancer.create(ctor.getParameterTypes(), args);
    }
}
