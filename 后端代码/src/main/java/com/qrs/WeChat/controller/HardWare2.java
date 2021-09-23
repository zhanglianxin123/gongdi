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

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zlx
 * @description
 * @Version 1.0
 * @Date 2021/6/18 14:54
 */
@RestController
@RequestMapping("//hardware")
@Api(value = "微信小程序查看数据模块" ,tags = "微信小程序查看数据接口")
public class HardWare2 {
    @Autowired
    private IEnvironmentService environmentService;
    @Autowired
    private IHardwareService hardwareService;

    @GetMapping("/getList")
    @ApiOperation(value = "获得信息")
    public RespBean getList(){
        List<Environment> list = environmentService.list();
        List<Hardware> list1 = hardwareService.list();

        List<Object> map=new ArrayList();
        map.add(list.get(list.size()-1));
        map.add(list1.get(list1.size()-1));
        return RespBean.success("成功",map);
    }
}
