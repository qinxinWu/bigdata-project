package pku.qingxin.common.bean;

import java.io.Closeable;

/**
 * 数据生产者接口
 * @author qingxin
 * @create 2020-05-01 16:02
 */
public interface Producer extends Closeable{
    /**
     * 设置数据来源
     */
    public void setIn(DataIn in);

    /**
     * 设置数据输出
     */
    public void setOut(DataOut out);
    /**
     * 生产数据
     */
    public void produce();
}
