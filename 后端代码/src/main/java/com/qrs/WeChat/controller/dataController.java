package com.qrs.WeChat.controller;

import com.qrs.admin.pojo.Environment;
import com.qrs.admin.pojo.Hardware;
import com.qrs.admin.pojo.RespBean;
import com.qrs.admin.service.IEnvironmentService;
import com.qrs.admin.service.IHardwareService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zlx
 * @description
 * @Version 1.0
 * @Date 2021/6/24 9:44
 */
@RestController
@RequestMapping("//data")
@Api(value = "微信小程序数据展示模块" ,tags = "微信小程序数据展示接口")
public class dataController {
    @Autowired
    private IEnvironmentService environmentService;
    @Autowired
    private IHardwareService hardwareService;
    @GetMapping("/get")
    @ApiOperation("展示数据")
    public RespBean list(){
        List<Environment> list = environmentService.list();
        List<Hardware> list1 = hardwareService.list();
        Map<String,Object> map=new HashMap<>();
        map.put("environment",list.get(list.size()-1));
        map.put("hardware",list1.get(list1.size()-1));
        return RespBean.success("成功",map);
    }
}
