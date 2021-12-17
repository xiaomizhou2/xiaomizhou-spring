package cn.xiaomizhou.springframework.context.event;

import cn.xiaomizhou.springframework.context.ApplicationEvent;
import cn.xiaomizhou.springframework.context.ApplicationListener;

public interface ApplicationEventMulticaster {

    /**
     * 添加监听方法
     * @param listener
     */
    void addApplicationListener(ApplicationListener<?> listener);

    /**
     * 删除监听方法
     * @param listener
     */
    void removeApplicationListener(ApplicationListener<?> listener);

    /**
     * 广播事件
     * @param event
     */
    void multicastEvent(ApplicationEvent event);
}
