package pku.qingxin.datadisplay.bean;

/**
 * @author qingxin
 * @create 2020-05-17 14:54
 */
public class CallPath {
    private Integer callerId;

    private String address1;

    private Integer calleeId;

    private String address2;

    public CallPath() {
    }

    public CallPath(Integer callerId, String address1, Integer calleeId, String address2) {
        this.callerId = callerId;
        this.address1 = address1;
        this.calleeId = calleeId;
        this.address2 = address2;
    }

    public Integer getCallerId() {
        return callerId;
    }

    public void setCallerId(Integer callerId) {
        this.callerId = callerId;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public Integer getCalleeId() {
        return calleeId;
    }

    public void setCalleeId(Integer calleeId) {
        this.calleeId = calleeId;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }
}
