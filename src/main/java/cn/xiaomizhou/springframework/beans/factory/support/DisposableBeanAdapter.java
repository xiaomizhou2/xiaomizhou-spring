package cn.xiaomizhou.springframework.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import cn.xiaomizhou.springframework.beans.BeansException;
import cn.xiaomizhou.springframework.beans.factory.DisposableBean;
import cn.xiaomizhou.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;

/**
 * @description: 定义销毁方法适配器
 * @author: zyx
 * @create: 2021-12-12 15:29
 **/
public class DisposableBeanAdapter implements DisposableBean {

    private final Object bean;
    private final String beanName;
    private String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {
        //1.实现接口 DisposableBean
        if (bean instanceof DisposableBean) {
            ((DisposableBean) bean).destroy();
        }

        //2.配置信息 destroy-method
        if (StrUtil.isNotEmpty(destroyMethodName) &&
                !(bean instanceof DisposableBean && "destroy".equals(this.destroyMethodName))) {
            Method method = bean.getClass().getMethod(destroyMethodName);

            if (null == method) {
                throw new BeansException("Cloud not find a destroy method named '" + destroyMethodName +
                        "' on bean with name '" + beanName + "'");
            }

            method.invoke(bean);
        }
    }
}
