package pku.qingxin.common.constant;

import pku.qingxin.common.bean.Value;

/**
 * 枚举类
 * @author qingxin
 * @create 2020-05-01 16:14
 */
public enum Names implements Value{
    NAMESPACE("tel")
    ,TABLE("tel:calllog")
    ,CF_CALLER("caller")
    ,CF_CALLEE("callee")
    ,CF_INFO("info")
    ,TOPIC("tel");

    private String name;

    private Names(String name) {
        this.name = name;
    }


    public void setValue(Object value) {
        this.name = (String) value;
    }

    public String getValue() {
        return name;
    }
}
