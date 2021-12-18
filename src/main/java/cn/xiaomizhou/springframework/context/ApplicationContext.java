package cn.xiaomizhou.springframework.context;

import cn.xiaomizhou.springframework.beans.factory.HierarchicalBeanFactory;
import cn.xiaomizhou.springframework.beans.factory.ListableBeanFactory;
import cn.xiaomizhou.springframework.core.io.ResourceLoader;

/**
 * <p>
 *     应用上下文
 * </p>
 * 定义上下文接口 Central接口
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {
}
