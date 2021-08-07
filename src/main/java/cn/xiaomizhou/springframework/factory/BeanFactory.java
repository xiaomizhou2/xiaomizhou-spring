package cn.xiaomizhou.springframework.factory;

import cn.xiaomizhou.springframework.BeansException;
import cn.xiaomizhou.springframework.factory.config.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface BeanFactory {
    //根据名称获取bean
    Object getBean(String name) throws BeansException;

    Object getBean(String name, Object... args) throws BeansException;
}
