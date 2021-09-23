package com.qrs.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qrs.WeChat.pojo.User;
import com.qrs.WeChat.service.IUserService;
import com.qrs.admin.pojo.DTO.PageDTO;
import com.qrs.admin.pojo.DTO.UserDetailedDTO3;
import com.qrs.admin.pojo.RespBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author zlx
 * @description
 * @Version 1.0
 * @Date 2021/6/11 14:52
 */
@RestController
@RequestMapping("/user2")
@Api(value = "用户模块" ,tags = "web用户接口")
public class UserController2 {
    @Autowired
    private IUserService userService;

    @PostMapping("/selectList")
    @ApiOperation(value = "通过用户id或名字查询列表")
    public RespBean getList(@RequestBody  String ch){
        String[] split = ch.split("\"");
        ch=split[1];
        System.out.println(ch);

        List<UserDetailedDTO3> list1=userService.getSelectByID(ch);


        ch="%"+ch+"%";
        List<UserDetailedDTO3> list = userService.getSelectList(ch);
        if(list.size()>0){
            return RespBean.success("成功",list);
        }
        return RespBean.success("成功",list1);
    }

    @GetMapping("/getNumber")
    @ApiOperation(value = "获得用户人数")
    public RespBean addUser(){
        int Number=userService.list().size();
        return  RespBean.success("成功",Number);
    }

    @PostMapping("/addUser")
    @ApiOperation(value = "添加用户")
    public RespBean addUser(@RequestBody User user){
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.eq("user_id",user.getUser_id());
        List<User> list = userService.list(wrapper);
        if(list.size()>0){
            return RespBean.error("添加失败，用户id已经存在");
        }

        user.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        if(userService.save(user)){
            return  RespBean.success("添加成功");
        }
        return  RespBean.success("添加失败");
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除用户")
    public RespBean deleteUser(@RequestBody Integer user_id) {
        System.out.println(user_id);
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.eq("user_id",user_id);
        if(userService.remove(wrapper)){
            return RespBean.success("用户删除成功");
        }
        return RespBean.success("用户删除失败");

    }

    @PostMapping("getList")
    @ApiOperation(value = "获得用户列表,分页")
    public RespBean getList(@RequestBody PageDTO pageDTO){
        int current=pageDTO.getCurrent();
        int size=pageDTO.getSize();
        int fromIndex = (current-1)*size;
        //到第几条数据结束
        int toIndex = current*size;
        //使用subList方法截取满足条件的数据
        List<UserDetailedDTO3> list = userService.getList(fromIndex,size);
        return RespBean.success("成功",list);


    }

    @PostMapping("/update")
    @ApiOperation(value = "修改某个用户")
    public RespBean update(@RequestBody User user){
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.eq("user_id",user.getUser_id());
        List<User> list = userService.list(wrapper);
        if(!list.get(0).getPassword().equals(user.getPassword())){
            user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        }

        userService.remove(wrapper);

        userService.save(user);
        return RespBean.success("成功");
    }

    @PostMapping("/select")
    @ApiOperation(value = "查询个用户")
    public RespBean update(String ch){
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.eq("user_id",ch);
        List<User> list = userService.list(wrapper);



        List<User> list1 = userService.getListByName(ch);
        if(list.size()>0){
            return RespBean.success("成功",list);
        }else if(list1.size()>0){
            return RespBean.success("成功",list1);
        }
        return RespBean.error("失败");
    }
}
