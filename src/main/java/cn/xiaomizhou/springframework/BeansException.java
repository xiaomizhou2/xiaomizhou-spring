package cn.xiaomizhou.springframework;

public class BeansException extends Exception{
    public BeansException(String instantiation_of_bean_failed, ReflectiveOperationException e) {

    }

    public BeansException(String instantiation_of_bean_failed) {

    }
}
