package pku.qingxin.common.bean;

import java.io.Closeable;

/**
 * 数据输出
 * @author qingxin
 * @create 2020-05-01 16:06
 */
public interface DataOut extends Closeable {
    public void setPath(String path);

    public void write(Object data) throws Exception;

    public void write(String data) throws Exception;



}
