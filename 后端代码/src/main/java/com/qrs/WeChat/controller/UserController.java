package com.qrs.WeChat.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qrs.WeChat.pojo.User;
import com.qrs.WeChat.service.IUserService;
import com.qrs.admin.annotation.PassToken;
import com.qrs.admin.pojo.DTO.UserDetailedDTO3;
import com.qrs.admin.pojo.RespBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zlx
 * @since 2021-06-06
 */
@RestController
@RequestMapping("/user")
@Api(value = "微信小程序用户模块" ,tags = "微信小程序用户接口")
public class UserController {
    @Autowired
    private IUserService userService;

    @PassToken
    @GetMapping("/list")
    @ApiOperation(value = "获取所有用户信息")
    public List<User> getlist(){
        System.out.println("list");
        return userService.list();
    }

    @PassToken
    @PostMapping("/login")
    @ApiOperation(value = "用户登录")
    public RespBean login(@RequestBody Map<String,Object> params ){

        String phone=params.get("phone").toString();
        String password=params.get("password").toString();
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.eq("phone",phone).eq("password", DigestUtils.md5DigestAsHex(password.getBytes()));
        List<User> list = userService.list(wrapper);
        if(!list.isEmpty()){

            List<UserDetailedDTO3> selectByID = userService.getSelectByID(list.get(0).getUser_id());
            return RespBean.success("登录成功",selectByID);
        }else{
            return RespBean.error("登录失败");
        }



    }

}
