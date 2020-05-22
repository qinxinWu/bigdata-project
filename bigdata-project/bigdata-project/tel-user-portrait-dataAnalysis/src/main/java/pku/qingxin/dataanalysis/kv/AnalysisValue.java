package pku.qingxin.dataanalysis.kv;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * 自定义value
 * @author qingxin
 * @create 2020-05-09 9:01
 */
public class AnalysisValue implements Writable {
    private String sumCall;
    private String sumDuration;

    public AnalysisValue() {
    }

    public AnalysisValue(String sumCall, String sumDuration) {
        this.sumCall = sumCall;
        this.sumDuration = sumDuration;
    }

    public String getSumCall() {
        return sumCall;
    }

    public void setSumCall(String sumCall) {
        this.sumCall = sumCall;
    }

    public String getSumDuration() {
        return sumDuration;
    }

    public void setSumDuration(String sumDuration) {
        this.sumDuration = sumDuration;
    }

    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(sumCall);
        dataOutput.writeUTF(sumDuration);

    }

    public void readFields(DataInput dataInput) throws IOException {
        sumCall = dataInput.readUTF();
        sumDuration = dataInput.readUTF();

    }
}
