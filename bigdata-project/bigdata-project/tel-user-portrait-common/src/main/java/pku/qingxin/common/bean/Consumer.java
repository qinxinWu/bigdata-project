package pku.qingxin.common.bean;

import java.io.Closeable;

/**
 * 消费者接口
 * @author qingxin
 * @create 2020-05-02 10:55
 */
public interface Consumer extends Closeable{

    //消费数据
    public void consume();
}
