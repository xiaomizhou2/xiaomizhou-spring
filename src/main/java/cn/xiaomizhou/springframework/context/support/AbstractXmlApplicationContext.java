package cn.xiaomizhou.springframework.context.support;

import cn.xiaomizhou.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.xiaomizhou.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @description:
 * @author: zyx
 * @create: 2021-12-08 21:58
 **/
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    /**
     * <p>
     *     对资源配置的加载操作的实现
     *     加载完成后即可完成对spring.xml 配置文件中的Bean对象的定义和注册
     * </p>
     *
     * @param beanFactory
     */
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();

        if (configLocations != null) {
            reader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}
