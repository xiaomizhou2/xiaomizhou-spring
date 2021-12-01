package cn.xiaomizhou.springframework.beans.factory.config;

public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);
}
