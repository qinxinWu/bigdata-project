package pku.qingxin.dataproducer.io;

import pku.qingxin.common.bean.Data;
import pku.qingxin.common.bean.DataIn;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 通话记录日志数据输入
 * @author qingxin
 * @create 2020-05-01 16:43
 */
public class CallLogDataIn implements DataIn{

    private BufferedReader reader = null;

    public CallLogDataIn() {
    }

    public CallLogDataIn(String path) {
        setPath(path);
    }

    public void setPath(String path) {
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path)),"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public <T extends Data> List<T> read(Class<T> clazz) throws IOException {
        //从联系人文件中读取所有的数据
        List<T> ts = new ArrayList<T>();
        try {
            String line = null;
            while ((line = reader.readLine()) != null){
                //将数据封装为为联系人对象，并添加到集合中
                T t = clazz.newInstance();
                t.setValue(line);
                ts.add(t);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return ts;
    }

    public Object read() throws IOException {
        return null;
    }

    public void close() throws IOException {
        if(reader != null){
            reader.close();
        }

    }
}
