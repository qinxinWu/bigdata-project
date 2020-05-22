package pku.qingxin.datadisplay.bean;

/**
 * @author qingxin
 * @create 2020-05-17 15:37
 */
public class CallGender {
    private String month;

    private Integer sumCall;

    public CallGender() {
    }

    public CallGender(String month, Integer sumCall) {
        this.month = month;
        this.sumCall = sumCall;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getSumCall() {
        return sumCall;
    }

    public void setSumCall(Integer sumCall) {
        this.sumCall = sumCall;
    }
}
