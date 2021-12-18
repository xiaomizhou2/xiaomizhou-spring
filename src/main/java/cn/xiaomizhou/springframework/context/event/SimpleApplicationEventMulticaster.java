package cn.xiaomizhou.springframework.context.event;

import cn.xiaomizhou.springframework.beans.factory.BeanFactory;
import cn.xiaomizhou.springframework.context.ApplicationEvent;
import cn.xiaomizhou.springframework.context.ApplicationListener;

/**
 * @description:
 * @author: zyx
 * @create: 2021-12-18 19:36
 **/
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @Override
    public void multicastEvent(final ApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}
