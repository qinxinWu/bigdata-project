package pku.qingxin.common.bean;

/**
 * 基本数据对象
 * @author qingxin
 * @create 2020-05-01 16:08
 */
public abstract class Data implements Value{
    public String content;


    public void setValue(Object value) {
        content = (String) value;
    }

    public String getValue() {
        return content;
    }
}
