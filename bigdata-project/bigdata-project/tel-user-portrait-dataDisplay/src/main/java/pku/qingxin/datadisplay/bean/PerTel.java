package pku.qingxin.datadisplay.bean;

/**
 * @author qingxin
 * @create 2020-05-16 20:16
 */
public class PerTel {
    private String month;

    private Integer sumCall;

    private Integer sumDuration;

    public PerTel() {
    }

    public PerTel(String month, Integer sumCall, Integer sumDuration) {
        this.month = month;
        this.sumCall = sumCall;
        this.sumDuration = sumDuration;
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

    public Integer getSumDuration() {
        return sumDuration;
    }

    public void setSumDuration(Integer sumDuration) {
        this.sumDuration = sumDuration;
    }
}
