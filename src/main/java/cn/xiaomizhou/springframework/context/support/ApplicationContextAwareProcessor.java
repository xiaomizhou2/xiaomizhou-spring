package cn.xiaomizhou.springframework.context.support;

import cn.xiaomizhou.springframework.beans.BeansException;
import cn.xiaomizhou.springframework.beans.factory.config.BeanPostProcessor;
import cn.xiaomizhou.springframework.context.ApplicationContext;
import cn.xiaomizhou.springframework.context.ApplicationContextAware;

/**
 * <p>
 *     由于 ApplicationContext 的获取并不能直接在创建 Bean 时候就可以拿到，
 *     所以需要在 refresh 操作时把 ApplicationContext 写入到一个包装的 BeanPostProcessor中去，
 *     再由 AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsBeforeInitialization 方法调用
 * </p>
 * @description: 包装处理器
 * @author: zyx
 * @create: 2021-12-14 20:30
 **/
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
