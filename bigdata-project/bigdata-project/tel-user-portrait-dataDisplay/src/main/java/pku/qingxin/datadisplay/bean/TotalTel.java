package pku.qingxin.datadisplay.bean;

/**
 * @author qingxin
 * @create 2020-05-16 16:37
 */
public class TotalTel {
    private Integer id;

    private String month;

    private Integer sumCall;

    private Integer sumDuration;

    public TotalTel() {
    }

    public TotalTel(Integer id, String month, Integer sumCall, Integer sumDuration) {
        this.id = id;
        this.month = month;
        this.sumCall = sumCall;
        this.sumDuration = sumDuration;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
