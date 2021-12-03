package cn.xiaomizhou.springframework.beans;

/**
 * bean 属性信息
 * @author Yaxi Zhang
 * @date 2021/12/3
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
