package cn.xiaomizhou.springframework.test.event;

import cn.xiaomizhou.springframework.context.ApplicationListener;
import cn.xiaomizhou.springframework.context.event.ContextRefreshedEvent;

/**
 * @description:
 * @author: zyx
 * @create: 2021-12-18 20:06
 **/
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("刷新事件：" + this.getClass().getName());
    }
}
