package com.qrs.admin.controller;


import com.qrs.admin.pojo.RespBean;
import com.qrs.admin.pojo.Role;
import com.qrs.admin.service.IRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zlx
 * @since 2021-06-09
 */
@RestController
@RequestMapping("//role")
@Api(value = "权限模块" ,tags = "web权限接口")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    @GetMapping("/list")
    @ApiOperation(value = "获得权限列表")
    public RespBean getList(){
        List<Role> list = roleService.list();
        return RespBean.success("成功",list);

    }

}
