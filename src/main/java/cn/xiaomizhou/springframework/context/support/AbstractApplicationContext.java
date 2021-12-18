package cn.xiaomizhou.springframework.context.support;

import cn.xiaomizhou.springframework.beans.BeansException;
import cn.xiaomizhou.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.xiaomizhou.springframework.beans.factory.config.BeanFactoryPostProcessor;
import cn.xiaomizhou.springframework.beans.factory.config.BeanPostProcessor;
import cn.xiaomizhou.springframework.context.ApplicationEvent;
import cn.xiaomizhou.springframework.context.ApplicationListener;
import cn.xiaomizhou.springframework.context.ConfigurableApplicationContext;
import cn.xiaomizhou.springframework.context.event.ApplicationEventMulticaster;
import cn.xiaomizhou.springframework.context.event.ContextClosedEvent;
import cn.xiaomizhou.springframework.context.event.ContextRefreshedEvent;
import cn.xiaomizhou.springframework.context.event.SimpleApplicationEventMulticaster;
import cn.xiaomizhou.springframework.core.io.DefaultResourceLoader;

import java.util.Collection;
import java.util.Map;

/**
 * @author Yaxi Zhang
 * @date 2021/12/6
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    public static final String APPLICATION_EVENT_MULTICASTER_BEAN_NAME = "applicationEventMulticaster";

    private ApplicationEventMulticaster applicationEventMulticaster;

    /**
     * 刷新容器
     *
     * @throws BeansException
     */
    @Override
    public void refresh() throws BeansException {
        //1.创建BeanFactory,并加载BeanDefinition
        refreshBeanFactory();

        //2.获取BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();

        /**
         * 3. 添加 ApplicationContextAwareProcessor，让继承
         *  自 ApplicationContextAware 的 Bean 对象都能感知所属的 ApplicationContext
         */
        beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));

        //4.在 bean 实例化之前，执行 BeanFactoryPostProcessor
        invokeBeanFactoryPostProcessors(beanFactory);

        //5.BeanPostProcessor 需要提前其他Bean对象实例化之前执行注册操作
        registerBeanPostProcessors(beanFactory);

        //6.初始化事件发布者
        initApplicationEventMulticaster();

        //7.注册事件监听器
        registerListeners();

        //8.提前实例化单例 Bean 对象
        beanFactory.preInstantiateSingletons();

        //9.发布容器刷新完成事件
        finishRefresh();
    }


    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);

        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);

        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }

    }


    protected abstract void refreshBeanFactory() throws BeansException;

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    @Override
    public Object getBean(String name) throws BeansException {
        return getBeanFactory().getBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return getBeanFactory().getBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name, requiredType);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    @Override
    public void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
    }

    @Override
    public void close() {
        //发布容器关闭事件
        publishEvent(new ContextClosedEvent(this));

        //执行销毁单例 bean 的销毁方法
        getBeanFactory().destroySingletons();
    }

    /**
     * 将事件发布者注册成容器
     */
    private void initApplicationEventMulticaster() {
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory);
        beanFactory.registerSingleton(APPLICATION_EVENT_MULTICASTER_BEAN_NAME, applicationEventMulticaster);
    }

    @Override
    public void publishEvent(ApplicationEvent event) {
        applicationEventMulticaster.multicastEvent(event);
    }

    private void registerListeners() {
        //获取所有的事件监听器实例
        Collection<ApplicationListener> applicationListeners = getBeansOfType(ApplicationListener.class).values();

        //将所有的事件监听器添加到事件发布中
        for (ApplicationListener listener : applicationListeners) {
            applicationEventMulticaster.addApplicationListener(listener);
        }
    }

    private void finishRefresh() {
        publishEvent(new ContextRefreshedEvent(this));
    }
}
