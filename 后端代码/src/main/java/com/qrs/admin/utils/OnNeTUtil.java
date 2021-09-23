package com.qrs.admin.utils;

import com.alibaba.fastjson.JSONObject;
import com.qrs.admin.utils.modul.Command;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * @Author zlx
 * @description
 * @Version 1.0
 * @Date 2021/6/22 16:35
 */
public class OnNeTUtil {
    private  final OkHttpUtil okHttpUtil;
    @Autowired
    public OnNeTUtil(OkHttpUtil okHttpUtil) {
        this.okHttpUtil = okHttpUtil;
    }
     void comm(String cmd){
        HashMap<String, String> urlParams = new HashMap<>();
        urlParams.put("imei", "868474041800077");
        urlParams.put("timeout", "5");
        urlParams.put("obj_id", "3200");
        urlParams.put("obj_inst_id", "0");
        urlParams.put("mode", "2");
        String url = parseUrl(urlParams);
        // 构建 request body 中的 json 字符串
        HashMap<String, List> map = new HashMap<>();
        List<Command> commands = new ArrayList<>();
        // 资源 ID 为 5527
        commands.add(new Command(5527, Objects.requireNonNull(cmd)));
        map.put("data", commands);
        String params = JSONObject.toJSONString(map);
        // 发送控制指令请求到平台，返回响应的 json 字符串
        String response = okHttpUtil.postJson(url, params);
        System.out.println(response);
        // 解析响应的字符串，判断是否下发成功
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

    private String parseUrl(HashMap<String, String> params) {
        StringBuilder sb = new StringBuilder("http://api.heclouds.com/nbiot?");
        for (String key : params.keySet()) {
            sb.append(key).append("=").append(params.get(key)).append("&");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

}
