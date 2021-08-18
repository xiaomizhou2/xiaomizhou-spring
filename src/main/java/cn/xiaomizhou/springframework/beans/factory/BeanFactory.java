package cn.xiaomizhou.springframework.beans.factory;

import cn.xiaomizhou.springframework.beans.BeansException;

public interface BeanFactory {
    //根据名称获取bean
    Object getBean(String name) throws BeansException;

    Object getBean(String name, Object... args) throws BeansException;

    //<T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
