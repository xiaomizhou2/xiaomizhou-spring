package cn.xiaomizhou.springframework.beans.factory;

import cn.xiaomizhou.springframework.beans.BeansException;

public interface InitializingBean {

    /**
     * Bean 处理了属性填充后调用
     *
     * @throws BeansException
     */
    void afterPropertiesSet() throws BeansException;
}
