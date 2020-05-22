package pku.qingxin.datadisplay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pku.qingxin.datadisplay.bean.*;
import pku.qingxin.datadisplay.service.CallLogService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 通话日志记录的控制器对象
 * @author qingxin
 * @create 2020-05-09 16:26
 */
@Controller
public class CallLogController {

    @Autowired
    private CallLogService callLogService;

    @RequestMapping("/query")
    public String query(){
        return "query";
    }

    //@ResponseBody
    @RequestMapping("/view")
    public String view(String tel, String calltime, Model model){
      /*  Map<String,String> dataMap = new HashMap<>();
        dataMap.put("name","zhangsan");
        dataMap.put("age","20");*/
        //return dataMap;

        List<CallLog> logs= callLogService.queryMonthDatas(tel,calltime);

        model.addAttribute("callLogs",logs);
        return "view";
    }

    //个人查询页面
    @RequestMapping("/personalForm")
    public String personalForm(){
        return "personal_form";
    }


    //个人数据展示页面
    @RequestMapping("/personalYearEcharts")
    public String personalYearEcharts(String tel, String calltime, Model model){
        List<PerTel> perTels = callLogService.queryPerTelDatas(tel,calltime);
        List<CallGender> callerMans = callLogService.queryCallerMan(tel,calltime);
        List<CallGender> callerWomans = callLogService.queryCallerWoman(tel,calltime);

        List<CallGender> calleeMans = callLogService.queryCalleeMan(tel,calltime);
        List<CallGender> calleeWomans = callLogService.queryCalleeWoman(tel,calltime);

        List<Intimacy> intimacies = callLogService.queryIntimacy(tel,calltime);


        List<Contact> contacts = callLogService.queryPerInfo(tel,calltime);

        List<CallPath> perCallPaths = callLogService.queryPerCallPath(tel,calltime);

        for(int i =1;i<13;i++){
            boolean flag = true;
            for (PerTel perTel : perTels) {
                if(Integer.parseInt(perTel.getMonth()) == i ){
                    flag = false;
                    break;
                }

            }
            if(flag){
                perTels.add(new PerTel(String.valueOf(i),0,0));
            }

        }

        for(int i =1;i<13;i++){
            boolean flag = true;
            for (CallGender callerMan : callerMans) {
                if(Integer.parseInt(callerMan.getMonth()) == i ){
                    flag = false;
                    break;
                }

            }
            if(flag){
                callerMans.add(new CallGender(String.valueOf(i),0));
            }

        }

        for(int i =1;i<13;i++){
            boolean flag = true;
            for (CallGender callerWoman : callerWomans) {
                if(Integer.parseInt(callerWoman.getMonth()) == i ){
                    flag = false;
                    break;
                }

            }
            if(flag){
                callerWomans.add(new CallGender(String.valueOf(i),0));
            }

        }


        for(int i =1;i<13;i++){
            boolean flag = true;
            for (CallGender calleeMan : calleeMans) {
                if(Integer.parseInt(calleeMan.getMonth()) == i ){
                    flag = false;
                    break;
                }

            }
            if(flag){
                calleeMans.add(new CallGender(String.valueOf(i),0));
            }

        }

        for(int i =1;i<13;i++){
            boolean flag = true;
            for (CallGender calleeWoman : calleeWomans) {
                if(Integer.parseInt(calleeWoman.getMonth()) == i ){
                    flag = false;
                    break;
                }

            }
            if(flag){
                calleeWomans.add(new CallGender(String.valueOf(i),0));
            }

        }

        for(int i =1;i<13;i++){
            boolean flag = true;
            for (Intimacy callee : intimacies) {
                if(Integer.parseInt(callee.getMonth()) == i ){
                    flag = false;
                    break;
                }

            }
            if(flag){
                intimacies.add(new Intimacy(String.valueOf(i),"无",0,0));
            }

        }



        Collections.sort(perTels, new Comparator<PerTel>() {

            public int compare(PerTel o1, PerTel o2) {

                // 按照月份进行升序排列
                if (Integer.parseInt(o1.getMonth()) < Integer.parseInt(o2.getMonth())) {
                    return -1;
                }
                if (Integer.parseInt(o1.getMonth()) == Integer.parseInt(o2.getMonth())) {
                    return 0;
                }
                return 1;
            }
        });

        Collections.sort(callerMans, new Comparator<CallGender>() {

            public int compare(CallGender o1, CallGender o2) {

                // 按照月份进行升序排列
                if (Integer.parseInt(o1.getMonth()) < Integer.parseInt(o2.getMonth())) {
                    return -1;
                }
                if (Integer.parseInt(o1.getMonth()) == Integer.parseInt(o2.getMonth())) {
                    return 0;
                }
                return 1;
            }
        });

        Collections.sort(callerWomans, new Comparator<CallGender>() {

            public int compare(CallGender o1, CallGender o2) {

                // 按照月份进行升序排列
                if (Integer.parseInt(o1.getMonth()) < Integer.parseInt(o2.getMonth())) {
                    return -1;
                }
                if (Integer.parseInt(o1.getMonth()) == Integer.parseInt(o2.getMonth())) {
                    return 0;
                }
                return 1;
            }
        });

        Collections.sort(calleeMans, new Comparator<CallGender>() {

            public int compare(CallGender o1, CallGender o2) {

                // 按照月份进行升序排列
                if (Integer.parseInt(o1.getMonth()) < Integer.parseInt(o2.getMonth())) {
                    return -1;
                }
                if (Integer.parseInt(o1.getMonth()) == Integer.parseInt(o2.getMonth())) {
                    return 0;
                }
                return 1;
            }
        });

        Collections.sort(calleeWomans, new Comparator<CallGender>() {

            public int compare(CallGender o1, CallGender o2) {

                // 按照月份进行升序排列
                if (Integer.parseInt(o1.getMonth()) < Integer.parseInt(o2.getMonth())) {
                    return -1;
                }
                if (Integer.parseInt(o1.getMonth()) == Integer.parseInt(o2.getMonth())) {
                    return 0;
                }
                return 1;
            }
        });

        Collections.sort(intimacies, new Comparator<Intimacy>() {

            public int compare(Intimacy o1, Intimacy o2) {

                // 按照月份进行升序排列
                if (Integer.parseInt(o1.getMonth()) < Integer.parseInt(o2.getMonth())) {
                    return -1;
                }
                if (Integer.parseInt(o1.getMonth()) == Integer.parseInt(o2.getMonth())) {
                    return 0;
                }
                return 1;
            }
        });





        for (PerTel perTel : perTels) {
            perTel.setSumDuration((int)Math.ceil(perTel.getSumDuration()/3600.0));
            System.out.println(perTel.getMonth()+"\t"+perTel.getSumCall()+"\t"+perTel.getSumDuration());

        }

        for (Intimacy intimacy : intimacies) {
            intimacy.setSumDuration((int)Math.ceil(intimacy.getSumDuration()/3600.0));
        }





        List<Integer> callerHumans = new ArrayList<>();
        List<Integer> calleeHumans = new ArrayList<>();


        for(int i =0 ;i<12;i++){
            callerHumans.add(callerMans.get(i).getSumCall()+callerWomans.get(i).getSumCall());
        }

        for(int i =0 ;i<12;i++){
            calleeHumans.add(calleeMans.get(i).getSumCall()+calleeWomans.get(i).getSumCall());
        }


      /*  for (CallGender callerMan : callerMans) {
            System.out.println(callerMan.getMonth()+"\t"+callerMan.getSumCall());
        }

        for (CallGender callerWoman : callerWomans) {
            System.out.println(callerWoman.getMonth()+"\t"+callerWoman.getSumCall());
        }

        for (Integer callerHuman : callerHumans) {
            System.out.print(callerHuman+"\t");
        }*/

        for (CallGender calleeMan : calleeMans) {
            System.out.println(calleeMan.getMonth()+"\t"+calleeMan.getSumCall());
        }

        for (CallGender calleeWoman : calleeWomans) {
            System.out.println(calleeWoman.getMonth()+"\t"+calleeWoman.getSumCall());
        }

        for (Integer calleeHuman : calleeHumans) {
            System.out.print(calleeHuman+"\t");
        }





        model.addAttribute("perTels",perTels);
        model.addAttribute("callerMans",callerMans);
        model.addAttribute("callerWomans",callerWomans);
        model.addAttribute("callerHumans",callerHumans);

        model.addAttribute("calleeMans",calleeMans);
        model.addAttribute("calleeWomans",calleeWomans);
        model.addAttribute("calleeHumans",calleeHumans);

        model.addAttribute("intimacies",intimacies);

        model.addAttribute("contacts",contacts);
        model.addAttribute("perCallPaths",perCallPaths);


        return "personalYear_echarts";
    }

    //总体概览页面
    @RequestMapping("/tablesDynamic")
    public String tablesDynamic(Model model){
        //查询联系人列表
        List<Contact> contacts = callLogService.queryContacts();

        //查询地域分布
        List<Address> addresses = callLogService.queryAddress();

        //查询地域分布（包含男女）
        List<AddressGender> addressGenders = callLogService.queryAddressGender();

        List<Integer> womenLists = new ArrayList<>();
        List<Integer> menLists = new ArrayList<>();
        List<Integer> humanLists =  new ArrayList<>();

        womenLists.add(callLogService.queryWomen1());
        womenLists.add(callLogService.queryWomen2());
        womenLists.add(callLogService.queryWomen3());
        womenLists.add(callLogService.queryWomen4());
        womenLists.add(callLogService.queryWomen5());
        womenLists.add(callLogService.queryWomen6());

        menLists.add(callLogService.queryMen1());
        menLists.add(callLogService.queryMen2());
        menLists.add(callLogService.queryMen3());
        menLists.add(callLogService.queryMen4());
        menLists.add(callLogService.queryMen5());
        menLists.add(callLogService.queryMen6());

        humanLists.add(callLogService.queryWomen1()+callLogService.queryMen1());
        humanLists.add(callLogService.queryWomen2()+callLogService.queryMen2());
        humanLists.add(callLogService.queryWomen3()+callLogService.queryMen3());
        humanLists.add(callLogService.queryWomen4()+callLogService.queryMen4());
        humanLists.add(callLogService.queryWomen5()+callLogService.queryMen5());
        humanLists.add(callLogService.queryWomen6()+callLogService.queryMen6());






        model.addAttribute("contacts",contacts);
        model.addAttribute("addresses",addresses);
        model.addAttribute("addressGenders",addressGenders);
        model.addAttribute("womenLists",womenLists);
        model.addAttribute("menLists",menLists);
        model.addAttribute("humanLists",humanLists);


        return "tables_dynamic";
    }


    //总体查询页面
    @RequestMapping("/totalForm")
    public String totalForm(){
        return "total_form";
    }


    //总体数据展示页面
    @RequestMapping("/totalYearEcharts")
    public String totalYearEcharts(String calltime, Model model){

        List<TotalTel> totalTels = callLogService.queryTotalTelDatas(calltime);

            for(int i =1;i<13;i++){
                boolean flag = true;
                for (TotalTel totalTel : totalTels) {
                    if(Integer.parseInt(totalTel.getMonth()) == i ){
                        flag = false;
                        break;
                    }

                }
                if(flag){
                    totalTels.add(new TotalTel(0,String.valueOf(i),0,0));
                }

            }
        Collections.sort(totalTels, new Comparator<TotalTel>() {

            public int compare(TotalTel o1, TotalTel o2) {

                // 按照月份进行升序排列
                if (Integer.parseInt(o1.getMonth()) < Integer.parseInt(o2.getMonth())) {
                    return -1;
                }
                if (Integer.parseInt(o1.getMonth()) == Integer.parseInt(o2.getMonth())) {
                    return 0;
                }
                return 1;
            }
        });

        for (TotalTel totalTel : totalTels) {
            totalTel.setSumDuration((int)Math.ceil(totalTel.getSumDuration()/3600.0));
            System.out.println(totalTel.getId()+"\t"+totalTel.getMonth()+"\t"+totalTel.getSumCall()+"\t"+totalTel.getSumDuration());

        }


        List<AddressCaller> addressCallers = callLogService.queryAddressCaller(calltime);
        List<AddressCallee> addressCallees = callLogService.queryAddressCallee(calltime);

        List<CallPath> callPaths = callLogService.queryCallPath(calltime);




        model.addAttribute("totalTels",totalTels);
        model.addAttribute("addressCallers",addressCallers);
        model.addAttribute("addressCallees",addressCallees);
        model.addAttribute("callPaths",callPaths);


        return "totalYear_echarts";
    }







}
