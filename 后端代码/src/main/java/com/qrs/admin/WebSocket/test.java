package com.qrs.admin.WebSocket;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.google.gson.Gson;
import com.qrs.admin.pojo.RespBean;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zlx
 * @description
 * @Version 1.0
 * @Date 2021/6/10 15:27
 */
@RestController
@Api(value = "socket模块" ,tags = "web Socket测试接口")
public class test {
    @Autowired
    WebSocket webSocket;

    @RequestMapping(value = "/socket",method = RequestMethod.POST)
    public void aaa(){
        Gson gson = new Gson();
        JSON s = JSONUtil.parse(RespBean.success("成功"));
        webSocket.sendAllMessage(gson.toJson(RespBean.success("成功")));
    }

    @RequestMapping(value = "/socket2",method = RequestMethod.POST)
    public void aaa2(){
        Gson gson = new Gson();
        webSocket.sendTextMessage("home",gson.toJson(RespBean.success("成功")));
    }
}
