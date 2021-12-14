package cn.xiaomizhou.springframework.context;

import cn.xiaomizhou.springframework.beans.BeansException;
import cn.xiaomizhou.springframework.beans.factory.Aware;
import cn.xiaomizhou.springframework.context.ApplicationContext;

/**
 * 实现此接口，就能感知所属的 ApplicationContext
 */
public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
