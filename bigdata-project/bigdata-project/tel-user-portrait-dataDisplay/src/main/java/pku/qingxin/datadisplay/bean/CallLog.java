package pku.qingxin.datadisplay.bean;

/**
 * @author qingxin
 * @create 2020-05-09 19:31
 */
public class CallLog {
    private Integer id;
    private Integer tel_id;
    private Integer date_id;
    private Integer sum_call;
    private Integer sum_duration;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTel_id() {
        return tel_id;
    }

    public void setTel_id(Integer tel_id) {
        this.tel_id = tel_id;
    }

    public Integer getDate_id() {
        return date_id;
    }

    public void setDate_id(Integer date_id) {
        this.date_id = date_id;
    }

    public Integer getSum_call() {
        return sum_call;
    }

    public void setSum_call(Integer sum_call) {
        this.sum_call = sum_call;
    }

    public Integer getSum_duration() {
        return sum_duration;
    }

    public void setSum_duration(Integer sum_duration) {
        this.sum_duration = sum_duration;
    }
}
