package pku.qingxin.datadisplay.dao;

import pku.qingxin.datadisplay.bean.*;

import java.util.List;
import java.util.Map; /**
 * 通话日志记录的数据库访问对象
 * @author qingxin
 * @create 2020-05-09 15:59
 */
public interface CallLogDao {
    List<CallLog> queryMonthDatas(Map<String, Object> map);

    List<TotalTel> queryTotalTelDatas(Map<String, Object> map);

    List<PerTel> queryPerTelDatas(Map<String, Object> map);

    List<CallPath> queryPerCallPath(Map<String, Object> map);



    List<AddressCaller> queryAddressCaller(Map<String, Object> map);

    List<AddressCallee> queryAddressCallee(Map<String, Object> map);

    List<CallPath> queryCallPath(Map<String, Object> map);

    List<CallGender> queryCallerMan(Map<String, Object> map);

    List<CallGender> queryCallerWoman(Map<String, Object> map);

    List<CallGender> queryCalleeMan(Map<String, Object> map);

    List<CallGender> queryCalleeWoman(Map<String, Object> map);

    List<Intimacy> queryIntimacy(Map<String, Object> map);

    List<Contact> queryPerInfo(Map<String, Object> map);



    List<Contact> queryContacts();

    List<Address> queryAddress();

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
