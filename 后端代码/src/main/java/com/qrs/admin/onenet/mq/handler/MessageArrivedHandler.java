package com.qrs.admin.onenet.mq.handler;


import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.google.gson.Gson;
import com.qrs.WeChat.pojo.User;
import com.qrs.WeChat.service.IUserService;
import com.qrs.admin.WebSocket.WebSocket;
import com.qrs.admin.pojo.*;
import com.qrs.admin.service.*;

import com.qrs.admin.utils.OkHttpUtil;
import com.qrs.admin.utils.OkHttpUtil2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: kyg
 * @Description: mq消息处理器
 * @Date: 2020-07-06 16:37
 **/
@Slf4j
@Component
public class MessageArrivedHandler implements MessageHandler {
    @Autowired
    private  ISwitchService switchService;

    @Autowired
    private  ILimitService limitService;

    @Autowired
    private  IEnvironmentService environmentService;

    @Autowired
    private  IHardwareService hardwareService;

    @Autowired
    private  IUserService userService;

    @Autowired
    private ISignService signService;

    @Autowired
    private IWarningrecordService warningrecordService;

    @Autowired
    private OkHttpUtil2 okHttpUtil2;

    @Autowired
    WebSocket webSocket;

    @Autowired
    private IConstructionService constructionService;


    @Override
    public void handle(Long msgId, String msgBody) {
        okHttpUtil2(msgId,msgBody);

    }



    public  void okHttpUtil2(Long msgId,String sourceStr) {


        String[] sourceStrArray = sourceStr.split(",");
        System.out.println(sourceStr);

        if (sourceStrArray[0] != null){
            switch (sourceStrArray[0]) {
                case "F":
                    switch (sourceStrArray[1]) {
                        case "1":
                            //环境数据
                            Environment environment1=Environment.builder()
                                    .environment_number(Math.toIntExact(msgId))
                                    .dust_one(Float.valueOf(sourceStrArray[2]))
                                    .dust_two(Float.valueOf(sourceStrArray[2]))
                                    .noise(Float.valueOf(sourceStrArray[3]))
                                    .speed(Float.valueOf(sourceStrArray[4]))
                                    .build();
                            disposeEnvironment(msgId,environment1);
                            break;
                        case "2":
                            //设备数据
                            Hardware hardware1=Hardware.builder()
                                    .tardward_id(Math.toIntExact(msgId))
                                    .vibration_one(Float.valueOf(sourceStrArray[2]))
                                    .acceleration_x_one(Float.valueOf(sourceStrArray[3]))
                                    .acceleration_y_one(Float.valueOf(sourceStrArray[4]))
                                    .acceleration_z_one(Float.valueOf(sourceStrArray[5]))
                                    .vibration_two(Float.valueOf(sourceStrArray[6]))
                                    .acceleration_x_two(Float.valueOf(sourceStrArray[7]))
                                    .acceleration_y_two(Float.valueOf(sourceStrArray[8]))
                                    .acceleration_z_two(Float.valueOf(sourceStrArray[9]))
                                    .detection_one(Integer.valueOf(sourceStrArray[10]))
                                    .detection_two(Integer.valueOf(sourceStrArray[10]))
                                    .build();
                            disposeHardware(msgId,hardware1);
                            break;
                        case "3":
                            //打卡
                            disposeSign(msgId, Integer.parseInt(sourceStrArray[2]));
                            break;
                        default:
                            System.out.println("数据不正确!");
                            break;
                    }
                    break;
                case "A" :
                    switch (sourceStrArray[1]){
                        case "1":
                            switch (sourceStrArray[2]){
                                case "1":
                                    //粉尘报警
                                    disposeSwitch(msgId,7, Integer.valueOf(sourceStrArray[3]));
                                    break;
                                case "2":
                                    //噪声报警
                                    disposeSwitch(msgId,3, Integer.valueOf(sourceStrArray[3]));
                                    break;
                                default:
                                    System.out.println("数据不正确!");
                                    break;
                            }
                        case "2":
                            switch(sourceStrArray[2]){
                                case "1":
                                    //吊塔震动报警
                                    disposeSwitch(msgId,1, Integer.valueOf(sourceStrArray[3]));
                                    break;
                                case "2":
                                    //加速度x轴上限报警
                                    disposeSwitch(msgId,4, Integer.valueOf(sourceStrArray[3]));
                                    break;
                                case "3":
                                    //加速度x轴下限报警
                                    disposeSwitch(msgId,4, Integer.valueOf(sourceStrArray[3]));
                                    break;
                                case "4":
                                    //加速度y轴上限报警
                                    disposeSwitch(msgId,4, Integer.valueOf(sourceStrArray[3]));
                                    break;
                                case "5":
                                    //加速度y轴上限
                                    disposeSwitch(msgId,4, Integer.valueOf(sourceStrArray[3]));
                                    break;
                                case "6":
                                    //加速度z轴上限
                                    disposeSwitch(msgId,4, Integer.valueOf(sourceStrArray[3]));
                                    break;
                                case "7":
                                    //加速度z轴下限
                                    disposeSwitch(msgId,4, Integer.valueOf(sourceStrArray[3]));
                                    break;
                                default:
                                    System.out.println("数据不正确!");
                                    break;
                            }
                            break;
                        case "3":
                            switch (sourceStrArray[2]){
                                case "1":
                                    //高支模震动报警
                                    disposeSwitch(msgId,2, Integer.valueOf(sourceStrArray[3]));                                     break;
                                case "2":
                                    //加速度x轴上限
                                    disposeSwitch(msgId,5, Integer.valueOf(sourceStrArray[3]));
                                    break;
                                case "3":
                                    //加速度x轴下限
                                    disposeSwitch(msgId,5, Integer.valueOf(sourceStrArray[3]));
                                    break;
                                case "4":
                                    //加速度y轴上限
                                    disposeSwitch(msgId,5, Integer.valueOf(sourceStrArray[3]));
                                    break;
                                case "5":
                                    //加速度y轴下限
                                    disposeSwitch(msgId,5, Integer.valueOf(sourceStrArray[3]));
                                    break;
                                case "6":
                                    //加速度z轴上限
                                    disposeSwitch(msgId,5, Integer.valueOf(sourceStrArray[3]));
                                    break;
                                case "7":
                                    //加速度z轴下限
                                    disposeSwitch(msgId,5, Integer.valueOf(sourceStrArray[3]));
                                    break;
                                default:
                                    System.out.println("数据不正确!");
                                    break;
                            }
                            break;

                        case "4":
                            //深坑报警
                            disposeSwitch(msgId,6, Integer.valueOf(sourceStrArray[3]));
                            break;
                        case "5":
                            //喷淋开关
                            disposeSwitch(msgId,8, Integer.valueOf(sourceStrArray[3]));
                            break;
                        case "A":
                            switch (sourceStrArray[2]){
                                case "1":
                                    //粉尘阈值
                                    disposeLimit_max(4, Integer.parseInt(sourceStrArray[3]));
                                    disposeLimit_max(5, Integer.parseInt(sourceStrArray[3]));
                                    break;
                                case "2":
                                    //噪声阈值
                                    disposeLimit_max(9, Integer.parseInt(sourceStrArray[3]));
                                    break;
                                case "3":
                                    //风速阈值
                                    break;
                                case "4":
                                    //塔吊加速度x轴上限数值
                                    disposeLimit_min(1, Integer.parseInt(sourceStrArray[3]));
                                    break;
                                case "5":
                                    //塔吊加速度x轴下限数值
                                    disposeLimit_max(1, Integer.parseInt(sourceStrArray[3]));
                                    break;
                                case "6":
                                    //塔吊加速度y轴上限数值
                                    disposeLimit_min(2, Integer.parseInt(sourceStrArray[3]));
                                    break;
                                case "7":
                                    //塔吊加速度y轴下限数值
                                    disposeLimit_max(2, Integer.parseInt(sourceStrArray[3]));
                                    break;
                                case "8":
                                    //塔吊加速度z轴上限数值
                                    disposeLimit_min(3, Integer.parseInt(sourceStrArray[3]));
                                    break;
                                case "9":
                                    //塔吊加速度z轴下限数值
                                    disposeLimit_max(3, Integer.parseInt(sourceStrArray[3]));
                                    break;
                                case "10":
                                    //高支模加速度x轴上限数值
                                    disposeLimit_min(6, Integer.parseInt(sourceStrArray[3]));
                                    break;
                                case "11":
                                    //高支模加速度x轴下限数值
                                    disposeLimit_max(6, Integer.parseInt(sourceStrArray[3]));
                                    break;
                                case "12":
                                    //高支模加速度y轴上限数值
                                    disposeLimit_min(7, Integer.parseInt(sourceStrArray[3]));
                                    break;
                                case "13":
                                    //高支模加速度y轴下限数值
                                    disposeLimit_max(7, Integer.parseInt(sourceStrArray[3]));
                                    break;
                                case "14":
                                    //高支模加速度z轴上限数值
                                    disposeLimit_min(8, Integer.parseInt(sourceStrArray[3]));
                                    break;
                                case "15":
                                    //高支模加速度z轴下限数值
                                    disposeLimit_max(8, Integer.parseInt(sourceStrArray[3]));
                                    break;
                                default:
                                    System.out.println("数据不正确!");
                                    break;
                            }
                            break;
                        default:
                            System.out.println("数据不正确!");
                            break;
                    }
                    break;
                default:
                    System.out.println("数据不正确!");
                    break;
            }
        }
    }
    public  void disposeSign(long magId,int  d){
        if(d==1){
            int hour = DateUtil.hour(DateUtil.date(), true);
            if(hour<8||(hour>13&&hour<14)){
                //上班
                Sign sign=Sign.builder().user_id(1).sign_time(DateUtil.now()).construction_id(1).status(1).build();
                signService.save(sign);
            }else{
                //下班
                Sign sign=Sign.builder().user_id(1).sign_time(DateUtil.now()).construction_id(1).status(1).build();
                signService.save(sign);
            }

        }
    }

    //处理环境数据
    public  void disposeEnvironment(long magId,Environment environment){
        System.out.println("处理环境数据:"+environment.toString());
        //将数据存放到数据库
        if (environmentService.save(environment)){
            System.out.println("接收环境数据成功");
        }
        //是否报警，如果报警要将报警数据下发到硬件
        List<Limit> list = limitService.list();
        //粉尘
        Limit limit = list.get(0);
        if(limit.getMax_value()<environment.getDust_one()){
            okHttpUtil2.issue("A,1,1");
            disposeSwitch(magId,7,1);
        }
        //噪音
        Limit limit1 = list.get(5);
        if(limit1.getMax_value()<environment.getNoise()){
            okHttpUtil2.issue("A,1,2");
            disposeSwitch(magId,3,1);
        }

        //将数据通过websocket传输到前端
        Map<String , Object> map=new HashMap<>();
        map.put("environment",environment);
        Gson gson = new Gson();
        webSocket.sendTextMessage("home",gson.toJson(map));


    }


    //处理硬件数据
    public  void disposeHardware(long magId,Hardware hardware){
        System.out.println("处理硬件数据:"+hardware.toString());
        //将数据存放到数据库
        if (hardwareService.save(hardware)){
            System.out.println("接收硬件数据成功");
        }
        //是否报警，如果报警要将报警数据下发到硬件
        List<Limit> list = limitService.list();
        //吊塔震动
        if(hardware.getVibration_one()==1){
            okHttpUtil2.issue("A,2,1");
            disposeSwitch(magId,1,1);
        }
        //高支模震动
        if(hardware.getVibration_two()==1){
            okHttpUtil2.issue("A,3,1");
            disposeSwitch(magId,2,1);
        }

        //吊塔x
        Limit limit1 = list.get(2);
        if(hardware.getAcceleration_x_one()<limit1.getMin_value()){
            okHttpUtil2.issue("A,2,3");
            disposeSwitch(magId,4,1);
        }
        if(hardware.getAcceleration_x_one()>limit1.getMax_value()){
            okHttpUtil2.issue("A,2,2");
            disposeSwitch(magId,4,1);
        }
        //吊塔y
        Limit limit2 = list.get(3);
        if(hardware.getAcceleration_y_one()<limit2.getMin_value()){
            okHttpUtil2.issue("A,2,5");
            disposeSwitch(magId,4,1);
        }
        if(hardware.getAcceleration_y_one()>limit2.getMax_value()){
            okHttpUtil2.issue("A,2,4");
            disposeSwitch(magId,4,1);
        }
        //吊塔z
        Limit limit3 = list.get(4);
        if(hardware.getAcceleration_z_one()<limit3.getMin_value()){
            okHttpUtil2.issue("A,2,7");
            disposeSwitch(magId,4,1);
        }
        if(hardware.getAcceleration_z_one()>limit3.getMax_value()){
            okHttpUtil2.issue("A,2,6");
            disposeSwitch(magId,4,1);
        }
        //高支模x
        Limit limit4 = list.get(6);
        if(hardware.getAcceleration_x_two()<limit4.getMin_value()){
            okHttpUtil2.issue("A,3,3");
            disposeSwitch(magId,5,1);
        }
        if(hardware.getAcceleration_x_two()>limit4.getMax_value()){
            okHttpUtil2.issue("A,3,2");
            disposeSwitch(magId,5,1);
        }
        //高支模y
        Limit limit5 = list.get(7);
        if(hardware.getAcceleration_y_two()<limit5.getMin_value()){
            okHttpUtil2.issue("A,3,5");
            disposeSwitch(magId,5,1);
        }
        if(hardware.getAcceleration_y_two()>limit5.getMax_value()){
            okHttpUtil2.issue("A,3,4");
            disposeSwitch(magId,5,1);
        }
        //高支模z
        Limit limit6 = list.get(8);
        if(hardware.getAcceleration_z_two()<limit6.getMin_value()){
            okHttpUtil2.issue("A,3,7");
            disposeSwitch(magId,5,1);
        }
        if(hardware.getAcceleration_z_two()>limit6.getMax_value()){
            okHttpUtil2.issue("A,3,6");
            disposeSwitch(magId,5,1);
        }

        //将数据通过websocket传输到前端

        QueryWrapper<Warningrecord> wrapper3 = new QueryWrapper();
        wrapper3.last("ORDER BY create_time DESC LIMIT 5");
        List<Warningrecord> list3 = warningrecordService.list(wrapper3);

        Map <String,Object>map=new HashMap<>();
        map.put("warningrecord",list3);
        map.put("hardware",hardware);

        Map <String,Object>o=new HashMap<>();
        o.put("hardware",map);
        Gson gson = new Gson();
        webSocket.sendTextMessage("home",gson.toJson(o));

    }

    //处理报警或喷淋开关
    public  void disposeSwitch(long magId,Integer switch_id,Integer switch_state){
        System.out.println("开关"+switch_id+"报警");
        //记录报警
        if(switch_id!=8){
            QueryWrapper<Switch> wrapper = new QueryWrapper();
            wrapper.eq("switch_id",switch_id);
            List<Switch> list = switchService.list(wrapper);

            QueryWrapper<User> wrapper1 = new QueryWrapper();
            wrapper1.eq("user_id",1);
            List<User> list1 = userService.list(wrapper1);

            QueryWrapper<Construction> wrapper2 = new QueryWrapper();
            wrapper2.eq("construction_id",1);
            List<Construction> list2 = constructionService.list(wrapper2);


            Warningrecord warningrecord=Warningrecord.builder()
                    .warning_id(switch_id).warning_number(String.valueOf(magId))
                    .warning_name(list.get(0).getNote())
                    .warning_why(list2.get(0).getConstruction_name()+"发生"+list.get(0).getSwitch_name()).warning_time(DateUtil.now()).build();
            warningrecordService.save(warningrecord);
            //将报警信息发送到前端



            Map <String,Object>o=new HashMap<>();
            o.put("warning",warningrecord);
            Gson gson = new Gson();
            webSocket.sendTextMessage("home",gson.toJson(o));


        }
        //修改开关
        UpdateWrapper<Switch> wrapper = new UpdateWrapper();
        wrapper.eq("switch_id",switch_id).set("switch_state",switch_state);
        switchService.update(wrapper);
    }


    //处理阈值
    //下限
    public  void disposeLimit_min(Integer device_id,int min_value){
        //修改阈值
        UpdateWrapper<Limit> wrapper = new UpdateWrapper();
        wrapper.eq("device_id",device_id).set("min_value",min_value);
        limitService.update(wrapper);
    }


    //上限
    public  void disposeLimit_max(Integer device_id,int max_value){
        //修改阈值
        //修改阈值
        UpdateWrapper<Limit> wrapper = new UpdateWrapper();
        wrapper.eq("device_id",device_id).set("max_value",max_value);
        limitService.update(wrapper);

    }


}
