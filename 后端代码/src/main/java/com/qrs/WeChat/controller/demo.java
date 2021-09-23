package com.qrs.WeChat.controller;

import com.alibaba.fastjson.JSONObject;
import com.qrs.admin.annotation.UserLoginToken;
import com.qrs.admin.onenet.mq.PushCallback;
import com.qrs.admin.onenet.mq.handler.MessageArrivedHandler;
import com.qrs.admin.onenet.mq.handler.MessageHandler;
import com.qrs.admin.pojo.Limit;
import com.qrs.admin.service.ILimitService;
import com.qrs.admin.utils.OkHttpUtil2;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author zlx
 * @description
 * @Version 1.0
 * @Date 2021/5/14 16:15
 */
@RestController
public class demo {
    @Autowired
    private ILimitService limitService;
    @Autowired
    private  MessageHandler handler;
    @Autowired
    private OkHttpUtil2 okHttpUtil2;
    @UserLoginToken
    @GetMapping("/hello")
    public String hello(){
        return "hello word";
    }

    @GetMapping("/cmd")
    public void cmd(){
        String response= okHttpUtil2.issue("f3,7");
        JSONObject jsonObject = JSONObject.parseObject(response);
        if (jsonObject != null) {
            String code = jsonObject.getString("errno");
            if (code != null && code.equals("0")) {
                //return 成功;
            } else {
                //return 失败;
            }
        } else {
            //return 失败;
        }
    }


    @PostMapping("/onenet")
    @ApiOperation(value = "参数onenet")
    public void onenet(Long id,String msg){
        //F,1,23,3,18

        handler.handle(id,msg);
    }

    @GetMapping("/test")
    public void test(){
        List<Limit> list = limitService.list();
        System.out.println(list);

    }

}
