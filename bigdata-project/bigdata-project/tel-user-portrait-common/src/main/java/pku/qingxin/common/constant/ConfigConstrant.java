package pku.qingxin.common.constant;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * @author qingxin
 * @create 2020-05-03 14:31
 */
public class ConfigConstrant {
    private static Map<String,String> valueMap = new HashMap<String, String>();

    static {
        ResourceBundle tel = ResourceBundle.getBundle("tel");
        Enumeration<String> keys = tel.getKeys();
        while (keys.hasMoreElements()){
            String key = keys.nextElement();
            String value = tel.getString(key);
            valueMap.put(key,value);
        }
    }

    public  static String getValue(String key){
        return valueMap.get(key);
    }

   /* public static void main(String[] args) {
        System.out.println(ConfigConstrant.getValue("tel.cf.caller"));
    }*/

}
