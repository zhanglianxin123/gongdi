package com.qrs.admin.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qrs.WeChat.pojo.User;
import com.qrs.WeChat.service.IUserService;
import com.qrs.admin.pojo.DTO.PageDTO3;
import com.qrs.admin.pojo.DTO.SignDTO;
import com.qrs.admin.pojo.RespBean;
import com.qrs.admin.pojo.Sign;
import com.qrs.admin.service.ISignService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zlx
 * @since 2021-06-09
 */
@RestController
@RequestMapping("//sign")
@Api(value = "签到模块" ,tags = "web签到接口")
public class SignController {
    @Autowired
    private ISignService signService;
    @Autowired
    private IUserService userService;
    @GetMapping("/getSignRecently")
    @ApiOperation("获得最近的签到数据")
    public RespBean getSignRecently(){
        List<Sign> list = signService.list();
        if(list.size()>10){
            List<SignDTO> list1 = signService.getSignRecently(list.size()-10);
            return RespBean.success("成功",list1);
        }
        List<SignDTO> list2 = signService.getList();
        return RespBean.success("成功",list2);

    }

    @PostMapping("/getSelectByName")
    @ApiOperation("通过名字查询记录，分页")
    public RespBean getSelectByNameSign(@RequestBody PageDTO3 pageDTO3){
        System.out.println(pageDTO3.toString());
        String ch=pageDTO3.getCh();

        int current=pageDTO3.getCurrent();
        int size=pageDTO3.getSize();
        int fromIndex = (current-1)*size;
        //到第几条数据结束
        int toIndex = current*size;


        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.eq("user_name",ch);
        List<User> list = userService.list(wrapper);
        String user_id=list.get(0).getUser_id();
        QueryWrapper<Sign> wrapper1 = new QueryWrapper();
        wrapper.eq("user_id",user_id);
        signService.list(wrapper1);
        List<SignDTO>list1=signService.getSelectByID(user_id,fromIndex,size);
        Map<String,Object> oj=new HashMap<>();
        oj.put("size",list.size());
        oj.put("list",list1);
        return RespBean.success("成功",oj);
    }

    @PostMapping("/getSelectByTime")
    @ApiOperation("通过时间查询某天记录")
    public RespBean getSelectByTime(@RequestBody PageDTO3 pageDTO3){
        String ch=pageDTO3.getCh();
        int current=pageDTO3.getCurrent();
        int size=pageDTO3.getSize();
        int fromIndex = (current-1)*size;
        //到第几条数据结束
        int toIndex = current*size;
        List<SignDTO>list1=signService.getSelectByTime(ch,fromIndex,size);
        List<SignDTO>list2=signService.getSelectByTime2(ch);

        Map<String,Object> oj=new HashMap<>();
        oj.put("size",list2.size());
        oj.put("list",list1);
        return RespBean.success("成功",oj);
    }





    /*
    @UserLoginToken
    @GetMapping("/getInDataDay")
    @ApiOperation("获得今天的签到记录")
    public RespBean getInDataDay(){
        String today= DateUtil.today();
        List<Sign> list = signService.getInDataDay(today);
        return RespBean.success("成功",list);

    }
    @UserLoginToken
    @GetMapping("/getInDataMath")
    @ApiOperation("获得当月的签到记录")
    public RespBean getInDataMath(){
        Date date=DateUtil.date();
        String math=DateUtil.format(date,"yyyy-MM");
        List<Sign> list = signService.getInDataMath(math);
        return RespBean.success("成功",list);

    }
    @UserLoginToken
    @GetMapping("/getInDataLastMath")
    @ApiOperation("获得上个月的签到记录")
    public RespBean getInDataLastMath(){
        Date date=DateUtil.lastMonth();
        System.out.println(date);
        String math=DateUtil.format(date,"yyyy-MM");
        List<Sign> list = signService.getInDataMath(math);
        return RespBean.success("成功",list);

    }
    */



}
