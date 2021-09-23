package com.qrs.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qrs.WeChat.pojo.User;
import com.qrs.admin.pojo.Environment;
import com.qrs.admin.pojo.Hardware;
import com.qrs.admin.pojo.RespBean;
import com.qrs.admin.pojo.Warningrecord;
import com.qrs.admin.service.IEnvironmentService;
import com.qrs.admin.service.IHardwareService;
import com.qrs.admin.service.IWarningrecordService;
import io.swagger.annotations.Api;
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
 * @Date 2021/7/12 9:12
 */
@RestController
@RequestMapping("/Indeex")
@Api(value = "用户首页模块" ,tags = "web首页接口")
public class IndexController {
    @Autowired
    private IEnvironmentService environmentService;
    @Autowired
    private IHardwareService hardwareService;

    @Autowired
    private IWarningrecordService warningrecordService;

    @GetMapping("/get")
    public RespBean get(){
        QueryWrapper<Environment> wrapper = new QueryWrapper();
        wrapper.last("ORDER BY create_time DESC LIMIT 1");
        List<Environment> list = environmentService.list(wrapper);

        QueryWrapper<Hardware> wrapper2 = new QueryWrapper();
        wrapper2.last("ORDER BY create_time DESC LIMIT 1");
        List<Hardware> list2= hardwareService.list(wrapper2);

        QueryWrapper<Warningrecord> wrapper3 = new QueryWrapper();
        wrapper3.last("ORDER BY create_time DESC LIMIT 5");
        List<Warningrecord> list3 = warningrecordService.list(wrapper3);


        Map<String,Object> map=new HashMap<>();
        map.put("environment",list);
        map.put("hardware",list2);
        map.put("warningrecord",list3);

        return RespBean.success("成功",map);


    }

}
