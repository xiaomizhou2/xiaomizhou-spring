package cn.xiaomizhou.springframework.aop;

import java.lang.reflect.Method;

/**
 * <p>
 *     方法匹配，找到表达式范围内匹配下的目标类和方法
 * </p>
 */
public interface MethodMatcher {

    boolean matches(Method method, Class<?> targetClass);

}
