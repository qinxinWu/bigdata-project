package pku.qingxin.common.bean;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;

/**
 * 数据来源
 * @author qingxin
 * @create 2020-05-01 16:05
 */
public interface DataIn extends Closeable{
    public void setPath(String path);

    public Object read() throws IOException;

    public <T extends Data> List<T> read(Class<T> clazz) throws IOException;
}
