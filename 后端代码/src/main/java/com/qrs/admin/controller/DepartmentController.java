package com.qrs.admin.controller;


import com.qrs.admin.pojo.Department;
import com.qrs.admin.pojo.RespBean;
import com.qrs.admin.service.IDepartmentService;
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
@RequestMapping("//department")
@Api(value = "部门模块" ,tags = "web部门接口")
public class DepartmentController {
    @Autowired
    private IDepartmentService departmentService;

    @GetMapping("/list")
    @ApiOperation(value = "部门列表")
    public RespBean getList(){
        List<Department> list = departmentService.list();
        return RespBean.success("成功",list);

    }

}
