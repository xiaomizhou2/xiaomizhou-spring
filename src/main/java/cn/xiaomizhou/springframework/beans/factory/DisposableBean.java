package cn.xiaomizhou.springframework.beans.factory;

import cn.xiaomizhou.springframework.beans.BeansException;

public interface DisposableBean {

    void destroy() throws Exception;
}
