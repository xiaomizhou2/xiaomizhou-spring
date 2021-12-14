package cn.xiaomizhou.springframework.beans.factory;

/**
 * 实现此接口，就能感知所属的 ClassLoader
 */
public interface BeanClassLoaderAware extends Aware {

    void setBeanClassLoader(ClassLoader classLoader);
}
