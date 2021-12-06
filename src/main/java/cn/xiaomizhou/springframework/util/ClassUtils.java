package cn.xiaomizhou.springframework.util;

/**
 * @description:
 * @author: zyx
 * @create: 2021-12-05 20:30
 **/
public class ClassUtils {

    public static ClassLoader getDefaultClassLoader() {
        ClassLoader classLoader = null;

        try {
            classLoader = Thread.currentThread().getContextClassLoader();
        } catch (Exception e) {
            //e.printStackTrace();
        }
        if (classLoader == null) {
            classLoader = ClassUtils.class.getClassLoader();
        }

        return classLoader;
    }
}