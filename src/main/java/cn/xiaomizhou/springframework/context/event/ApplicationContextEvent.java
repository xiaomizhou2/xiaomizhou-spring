package cn.xiaomizhou.springframework.context.event;

import cn.xiaomizhou.springframework.context.ApplicationContext;
import cn.xiaomizhou.springframework.context.ApplicationEvent;

/**
 * @author Yaxi Zhang
 * @date 2021/12/17
 */
public class ApplicationContextEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }
}
