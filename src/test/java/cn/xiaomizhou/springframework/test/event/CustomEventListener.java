package cn.xiaomizhou.springframework.test.event;

import cn.xiaomizhou.springframework.context.ApplicationListener;

import java.util.Date;

/**
 * @description:
 * @author: zyx
 * @create: 2021-12-18 20:02
 **/
public class CustomEventListener implements ApplicationListener<CustomEvent> {

    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("收到：" + event.getSource() + "消息;时间：" + new Date());
        System.out.println("消息：" + event.getId() + ":" + event.getMessage());
    }
}
