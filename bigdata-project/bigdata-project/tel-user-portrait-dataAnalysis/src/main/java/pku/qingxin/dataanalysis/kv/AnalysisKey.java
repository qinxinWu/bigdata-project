package pku.qingxin.dataanalysis.kv;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * 自定义key
 * @author qingxin
 * @create 2020-05-09 9:00
 */
public class AnalysisKey implements WritableComparable<AnalysisKey> {
    private String tel;
    private String date;

    public AnalysisKey() {
    }

    public AnalysisKey(String tel, String date) {
        this.tel = tel;
        this.date = date;
    }


    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int compareTo(AnalysisKey key) {
        int result = tel.compareTo(key.getTel());

        if( 0 == result){
            result = date.compareTo(key.getDate());
        }

        return result;
    }

    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(tel);
        dataOutput.writeUTF(date);
    }

    public void readFields(DataInput dataInput) throws IOException {
        tel = dataInput.readUTF();
        date = dataInput.readUTF();
    }
}
