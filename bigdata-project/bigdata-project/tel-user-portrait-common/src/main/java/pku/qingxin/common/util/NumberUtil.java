package pku.qingxin.common.util;

import java.text.DecimalFormat;

/**
 * 数字格式工具类
 * @author qingxin
 * @create 2020-05-01 20:06
 */
public class NumberUtil {
    public static String format(int num,int length){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0;i<length;i++){
            stringBuilder.append("0");
        }
        DecimalFormat df = new DecimalFormat(stringBuilder.toString());
        return df.format(num);
    }

}
