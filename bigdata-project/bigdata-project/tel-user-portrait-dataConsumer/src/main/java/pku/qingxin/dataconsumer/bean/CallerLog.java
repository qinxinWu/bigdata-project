package pku.qingxin.dataconsumer.bean;

import pku.qingxin.common.api.Column;
import pku.qingxin.common.api.RowKey;
import pku.qingxin.common.api.TableRef;

/**
 * 通话记录日志对象
 * @author qingxin
 * @create 2020-05-03 16:18
 */
@TableRef("tel:calllog")
public class CallerLog {
    @RowKey
    private String rowkey;
    @Column(family = "caller")
    private String call1;
    @Column(family = "caller")
    private String call2;
    @Column(family = "caller")
    private String calltime;
    @Column(family = "caller")
    private String duration;
    @Column(family = "caller")
    private String flag = "1";//1:主叫 0：被叫



    public CallerLog() {
    }

    public CallerLog(String call1, String call2, String calltime, String duration) {
        this.call1 = call1;
        this.call2 = call2;
        this.calltime = calltime;
        this.duration = duration;
    }

    public CallerLog(String data) {
        String[] splits = data.split("\t");
        //CallLog(splits[0],splits[1],splits[2],splits[3]);
        this.call1 = splits[0];
        this.call2 = splits[1];
        this.calltime = splits[2];
        this.duration = splits[3];
    }


    public String getRowkey() {
        return rowkey;
    }

    public void setRowkey(String rowkey) {
        this.rowkey = rowkey;
    }

    public String getCall1() {
        return call1;
    }

    public void setCall1(String call1) {
        this.call1 = call1;
    }

    public String getCall2() {
        return call2;
    }

    public void setCall2(String call2) {
        this.call2 = call2;
    }

    public String getCalltime() {
        return calltime;
    }

    public void setCalltime(String calltime) {
        this.calltime = calltime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
