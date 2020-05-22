package pku.qingxin.datadisplay.bean;

/**
 * @author qingxin
 * @create 2020-05-18 10:44
 */
public class Intimacy {
    private String month;

    private String name;

    private Integer sumCall;

    private Integer sumDuration;

    public Intimacy() {
    }

    public Intimacy(String month, String name, Integer sumCall, Integer sumDuration) {
        this.month = month;
        this.name = name;
        this.sumCall = sumCall;
        this.sumDuration = sumDuration;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
