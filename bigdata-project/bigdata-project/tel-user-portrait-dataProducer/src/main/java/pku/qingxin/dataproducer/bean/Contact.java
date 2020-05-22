package pku.qingxin.dataproducer.bean;

import pku.qingxin.common.bean.Data;

/**
 * 联系人
 * @author qingxin
 * @create 2020-05-01 19:09
 */
public class Contact extends Data{
    private String name;
    private String tel;

    public String getName() {
        return name;
    }

    public String getTel() {
        return tel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setValue(Object value) {
        content = (String) value;
        String[] splits = content.split("\t");
        setTel(splits[0]);
        setName(splits[1]);
    }

    @Override
    public String toString() {
        return "Contact[" + name + ',' + tel + ']';
    }
}
