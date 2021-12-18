package cn.xiaomizhou.springframework.test.event;

import cn.xiaomizhou.springframework.context.ApplicationListener;
import cn.xiaomizhou.springframework.context.event.ApplicationContextEvent;
import cn.xiaomizhou.springframework.context.event.ContextClosedEvent;

/**
 * @description:
 * @author: zyx
 * @create: 2021-12-18 20:08
 **/
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("关闭事件：" + this.getClass().getName());
    }
}
