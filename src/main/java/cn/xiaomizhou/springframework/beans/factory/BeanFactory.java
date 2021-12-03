package cn.xiaomizhou.springframework.beans.factory;

import cn.xiaomizhou.springframework.beans.BeansException;
import cn.xiaomizhou.springframework.beans.factory.config.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Yaxi Zhang
 * @date 2021/12/1
 */
public interface BeanFactory {

    /**
     * 根据name获取bean对象的接口
     * @param name
     * @return
     * @throws BeansException
     */
    Object getBean(String name) throws BeansException;


    Object getBean(String name, Object... args) throws BeansException;

}
