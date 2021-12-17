package cn.xiaomizhou.springframework.context;

import java.util.EventObject;

/**
 * @author Yaxi Zhang
 * @date 2021/12/17
 */
public abstract class ApplicationEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
