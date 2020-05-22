package pku.qingxin.datadisplay.bean;

/**
 * @author qingxin
 * @create 2020-05-16 21:18
 */
public class AddressCallee {
    private String address;

    private Integer sumCall;

    public AddressCallee() {
    }

    public AddressCallee(String address, Integer sumCall) {
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
