package cn.xiaomizhou.springframework.core.io;

/**
 * 资源加载器包装
 */
public interface ResourceLoader {

    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);

}
