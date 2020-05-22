package pku.qingxin.datadisplay.bean;

/**
 * @author qingxin
 * @create 2020-05-16 20:54
 */
public class AddressCaller {
    private String address;

    private Integer sumCall;

    public AddressCaller() {
    }

    public AddressCaller(String address, Integer sumCall) {
        this.address = address;
        this.sumCall = sumCall;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSumCall() {
        return sumCall;
    }

    public void setSumCall(Integer sumCall) {
        this.sumCall = sumCall;
    }
}
