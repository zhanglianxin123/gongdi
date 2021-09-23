package com.qrs.admin.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qrs.WeChat.pojo.User;
import com.qrs.WeChat.service.impl.UserServiceImpl;
import com.qrs.admin.annotation.PassToken;
import com.qrs.admin.annotation.UserLoginToken;
import com.qrs.admin.pojo.DTO.UserDTO;
import com.qrs.admin.pojo.RespBean;
import com.qrs.admin.utils.TokenUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zlx
 * @description
 * @Version 1.0
 * @Date 2021/4/8 20:31
 */
@RestController
@RequestMapping("/Login")
@Api(value = "用户登录模块" ,tags = "web用户登录接口")
public class LoginController {

    @Autowired
    private UserServiceImpl userService;



    @PassToken
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public RespBean userLogin(HttpServletRequest request, @RequestBody UserDTO userDTO){
        System.out.println(userDTO);
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.eq("user_id",userDTO.getId());
        List<User> list=userService.list(wrapper);
        User user=list.get(0);
        HttpSession session = request.getSession();
        if (user==null) {
            session.setAttribute("isError", true);
            return RespBean.error("isError");
        }
        else{
            Map<String,Object> tokenMap = new HashMap<>();
            tokenMap.put("token", TokenUtils.getUserToken(user));
            System.out.println(TokenUtils.getUserToken(user));
            tokenMap.put("user",user);
            return RespBean.success("登录成功",tokenMap);
        }

    }



    @UserLoginToken
    @PostMapping("/getMessage")
    public RespBean getMessage(){
        String aaa="hello word";
        return RespBean.success("你已经通过验证",aaa);
    }
}
