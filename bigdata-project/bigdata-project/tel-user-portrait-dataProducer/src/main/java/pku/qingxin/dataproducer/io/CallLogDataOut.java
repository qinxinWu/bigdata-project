package pku.qingxin.dataproducer.io;

import pku.qingxin.common.bean.DataOut;

import java.io.*;

/**
 * 通话记录日志数据输出
 * @author qingxin
 * @create 2020-05-01 16:44
 */
public class CallLogDataOut implements DataOut {
    private PrintWriter writer = null;


    public CallLogDataOut() {
    }

    public CallLogDataOut(String path) {
        setPath(path);
    }


    public void setPath(String path) {
        try {
            writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(path,true),"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void write(Object data) throws Exception {
        write(data.toString());
    }

    public void write(String data) throws Exception {
        writer.println(data);
        writer.flush();
    }

    public void close() throws IOException {
        if(writer != null ){
            writer.close();
        }
    }
}
