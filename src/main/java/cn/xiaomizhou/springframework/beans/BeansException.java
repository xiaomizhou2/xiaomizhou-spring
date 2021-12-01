package cn.xiaomizhou.springframework.beans;

/**
 * 定义 Bean 异常
 *
 * @author Yaxi Zhang
 * @date 2021/12/1
 */
public class BeansException extends RuntimeException {

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
