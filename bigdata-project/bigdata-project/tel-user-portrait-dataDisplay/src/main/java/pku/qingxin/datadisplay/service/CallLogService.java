package pku.qingxin.datadisplay.service;

import pku.qingxin.datadisplay.bean.*;

import java.util.List;

/**
 * @author qingxin
 * @create 2020-05-09 16:24
 */
public interface CallLogService {
    List<CallLog> queryMonthDatas(String tel, String calltime);

    List<TotalTel> queryTotalTelDatas(String calltime);

    List<AddressCaller> queryAddressCaller(String calltime);

    List<AddressCallee> queryAddressCallee(String calltime);

    List<CallPath> queryCallPath(String calltime);

    List<PerTel> queryPerTelDatas(String tel, String calltime);

    List<CallGender> queryCallerMan(String tel, String calltime);

    List<CallGender> queryCallerWoman(String tel, String calltime);

    List<CallGender> queryCalleeMan(String tel, String calltime);

    List<CallGender> queryCalleeWoman(String tel, String calltime);

    List<Intimacy> queryIntimacy(String tel, String calltime);

    List<Contact> queryPerInfo(String tel, String calltime);

    List<CallPath> queryPerCallPath(String tel,String calltime);






    //查询所有联系人信息
    List<Contact> queryContacts();

    //查询地域分布
    List<Address> queryAddress();

    //查询地域分布（包含男女）
    List<AddressGender> queryAddressGender();

    //查询年龄低于20岁的女性
    Integer queryWomen1();

    //查询年龄20-30岁的女性
    Integer queryWomen2();

    //查询年龄30-40岁的女性
    Integer queryWomen3();

    //查询年龄40-50岁的女性
    Integer queryWomen4();

    //查询年龄50-60岁的女性
    Integer queryWomen5();

    //查询年龄高于60岁的女性
    Integer queryWomen6();


    //查询年龄低于20岁的男性
    Integer queryMen1();

    //查询年龄20-30岁的男性
    Integer queryMen2();

    //查询年龄30-40岁的男性
    Integer queryMen3();

    //查询年龄40-50岁的男性
    Integer queryMen4();

    //查询年龄50-60岁的男性
    Integer queryMen5();

    //查询年龄高于60岁的男性
    Integer queryMen6();

}
