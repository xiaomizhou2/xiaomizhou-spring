package cn.xiaomizhou.springframework.context;

import cn.xiaomizhou.springframework.beans.factory.ListableBeanFactory;

/**
 * <p>
 *     继承于 ListableBeanFactory,也就继承了关于 BeanFactory 方法
 * </p>
 * 定义上下文接口 Central接口
 */
public interface ApplicationContext extends ListableBeanFactory {
}
