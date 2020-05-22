package pku.qingxin.datadisplay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pku.qingxin.datadisplay.bean.*;
import pku.qingxin.datadisplay.dao.CallLogDao;
import pku.qingxin.datadisplay.service.CallLogService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 通话日志记录的服务对象
 * @author qingxin
 * @create 2020-05-09 16:25
 */
@Service
public class CallLogServiceImpl implements CallLogService {

    @Autowired
    private CallLogDao callLogDao;

    //查询用户指定时间的通话记录统计信息
    @Override
    public List<CallLog> queryMonthDatas(String tel, String calltime) {
        Map<String,Object> map = new HashMap<>();
        map.put("tel",tel);
        if(calltime.length() > 4){
            calltime = calltime.substring(0,4);
        }
        map.put("calltime",calltime);

        return callLogDao.queryMonthDatas(map);
    }

    @Override
    public List<TotalTel> queryTotalTelDatas(String calltime) {
        Map<String,Object> map = new HashMap<>();
        if(calltime.length() > 4){
            calltime = calltime.substring(0,4);
        }
        map.put("calltime",calltime);
        return callLogDao.queryTotalTelDatas(map);
    }

    @Override
    public List<AddressCaller> queryAddressCaller(String calltime) {
        Map<String,Object> map = new HashMap<>();
        if(calltime.length() > 4){
            calltime = calltime.substring(0,4);
        }
        map.put("calltime",calltime);

        return callLogDao.queryAddressCaller(map);
    }

    @Override
    public List<AddressCallee> queryAddressCallee(String calltime) {
        Map<String,Object> map = new HashMap<>();
        if(calltime.length() > 4){
            calltime = calltime.substring(0,4);
        }
        map.put("calltime",calltime);

        return callLogDao.queryAddressCallee(map);
    }

    @Override
    public List<CallPath> queryCallPath(String calltime) {
        Map<String,Object> map = new HashMap<>();
        if(calltime.length() > 4){
            calltime = calltime.substring(0,4);
        }
        map.put("calltime",calltime);

        return callLogDao.queryCallPath(map);
    }

    @Override
    public List<PerTel> queryPerTelDatas(String tel, String calltime) {
        Map<String,Object> map = new HashMap<>();
        map.put("tel",tel);
        if(calltime.length() > 4){
            calltime = calltime.substring(0,4);
        }
        map.put("calltime",calltime);


        return callLogDao.queryPerTelDatas(map);
    }

    @Override
    public List<CallGender> queryCallerMan(String tel, String calltime) {
        Map<String,Object> map = new HashMap<>();
        map.put("tel",tel);
        if(calltime.length() > 4){
            calltime = calltime.substring(0,4);
        }
        map.put("calltime",calltime);

        return callLogDao.queryCallerMan(map);
    }

    @Override
    public List<CallGender> queryCallerWoman(String tel, String calltime) {
        Map<String,Object> map = new HashMap<>();
        map.put("tel",tel);
        if(calltime.length() > 4){
            calltime = calltime.substring(0,4);
        }
        map.put("calltime",calltime);

        return callLogDao.queryCallerWoman(map);
    }

    @Override
    public List<CallGender> queryCalleeMan(String tel, String calltime) {
        Map<String,Object> map = new HashMap<>();
        map.put("tel",tel);
        if(calltime.length() > 4){
            calltime = calltime.substring(0,4);
        }
        map.put("calltime",calltime);

        return callLogDao.queryCalleeMan(map);
    }

    @Override
    public List<CallGender> queryCalleeWoman(String tel, String calltime) {
        Map<String,Object> map = new HashMap<>();
        map.put("tel",tel);
        if(calltime.length() > 4){
            calltime = calltime.substring(0,4);
        }
        map.put("calltime",calltime);

        return callLogDao.queryCalleeWoman(map);
    }

    @Override
    public List<Intimacy> queryIntimacy(String tel, String calltime) {
        Map<String,Object> map = new HashMap<>();
        map.put("tel",tel);
        if(calltime.length() > 4){
            calltime = calltime.substring(0,4);
        }
        map.put("calltime",calltime);

        return callLogDao.queryIntimacy(map);
    }

    @Override
    public List<Contact> queryPerInfo(String tel, String calltime) {
        Map<String,Object> map = new HashMap<>();
        map.put("tel",tel);
        if(calltime.length() > 4){
            calltime = calltime.substring(0,4);
        }
        map.put("calltime",calltime);

        return callLogDao.queryPerInfo(map);
    }

    @Override
    public List<CallPath> queryPerCallPath(String tel, String calltime) {
        Map<String,Object> map = new HashMap<>();
        map.put("tel",tel);
        if(calltime.length() > 4){
            calltime = calltime.substring(0,4);
        }
        map.put("calltime",calltime);

        return callLogDao.queryPerCallPath(map);
    }

    @Override
    public List<Contact> queryContacts() {

        return callLogDao.queryContacts();
    }

    @Override
    public List<Address> queryAddress() {

        return callLogDao.queryAddress();
    }

    @Override
    public List<AddressGender> queryAddressGender() {

        return callLogDao.queryAddressGender();
    }

    @Override
    public Integer queryWomen1() {
        return callLogDao.queryWomen1();
    }

    @Override
    public Integer queryWomen2() {
        return callLogDao.queryWomen2();
    }

    @Override
    public Integer queryWomen3() {
        return callLogDao.queryWomen3();
    }

    @Override
    public Integer queryWomen4() {
        return callLogDao.queryWomen4();
    }

    @Override
    public Integer queryWomen5() {
        return callLogDao.queryWomen5();
    }

    @Override
    public Integer queryWomen6() {
        return callLogDao.queryWomen6();
    }

    @Override
    public Integer queryMen1() {
        return callLogDao.queryMen1();
    }

    @Override
    public Integer queryMen2() {
        return callLogDao.queryMen2();
    }

    @Override
    public Integer queryMen3() {
        return callLogDao.queryMen3();
    }

    @Override
    public Integer queryMen4() {
        return callLogDao.queryMen4();
    }

    @Override
    public Integer queryMen5() {
        return callLogDao.queryMen5();
    }

    @Override
    public Integer queryMen6() {
        return callLogDao.queryMen6();
    }
}
