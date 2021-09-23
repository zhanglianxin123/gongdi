package com.qrs.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qrs.WeChat.mapper.UserMapper;
import com.qrs.WeChat.pojo.Document;
import com.qrs.WeChat.pojo.Score;
import com.qrs.WeChat.pojo.User;
import com.qrs.WeChat.service.IDocumentService;
import com.qrs.WeChat.service.IScoreService;
import com.qrs.WeChat.service.IUserService;
import com.qrs.admin.pojo.Construction;
import com.qrs.admin.pojo.DTO.PageDTO;
import com.qrs.admin.pojo.DTO.ScoreDTO;
import com.qrs.admin.pojo.DTO.UserDTO2;
import com.qrs.admin.pojo.Department;
import com.qrs.admin.pojo.RespBean;
import com.qrs.admin.service.IConstructionService;
import com.qrs.admin.service.IDepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zlx
 * @description
 * @Version 1.0
 * @Date 2021/6/11 16:10
 */
@RestController
@RequestMapping("/webScore")
@Api(value = "分数模块" ,tags = "web分数管理接口")
public class WecScoreController {
    @Autowired
    private IScoreService scoreService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IDepartmentService departmentService;

    @Autowired
    private  IDocumentService documentService;

    @Autowired
    private IConstructionService constructionService;

    @Autowired
    private UserMapper userMapper;


    @PostMapping("/getList")
    @ApiOperation(value = "获得列表信息,分页")
    public RespBean getScore(@RequestBody PageDTO pageDTO){
        IPage<User> ipage = new Page<>(pageDTO.getCurrent(), pageDTO.getSize());
        IPage<User> userIPage = userMapper.selectPage(ipage, null);

        List<User> list = userIPage.getRecords();
        List <UserDTO2> list2=new ArrayList<>();
        for(User user:list) {
            UserDTO2 userDTO2=new UserDTO2();
            userDTO2.setUser_id(user.getUser_id());
            userDTO2.setUser_name(user.getUser_name());
            userDTO2.setPhone(user.getPhone());
            QueryWrapper<Department> wrapper = new QueryWrapper();
            wrapper.eq("department_id",user.getDepartment_id()).eq("construction_id",user.getConstruction_id());
            List<Department> list1 = departmentService.list(wrapper);
            userDTO2.setDepartment_name(list1.get(0).getDepartment_name());


            QueryWrapper<Construction> wrapper2 = new QueryWrapper();
            wrapper2.eq("construction_id",user.getConstruction_id());
            List<Construction> list3 = constructionService.list(wrapper2);
            userDTO2.setConstruction_name(list3.get(0).getConstruction_name());



            userDTO2.setScore(scoreService.getScore(Integer.valueOf(user.getUser_id())));

            list2.add(userDTO2);
        }

        return RespBean.success("成功",list2);
    }

    @PostMapping("/getLeanList")
    @ApiOperation(value = "通过用户id获得学习记录列表")
    public RespBean getLeanList(@RequestBody Integer user_id){
        QueryWrapper<Score> wrapper = new QueryWrapper();
        wrapper.eq("user_id",user_id);
        List<Score> list = scoreService.list(wrapper);
        List<ScoreDTO> scoreList=new ArrayList<>();
        for(Score score:list){
            ScoreDTO scoreDTO=new ScoreDTO();
            scoreDTO.setUser_id(score.getUser_id());
            if(score.getAttribute()==1){
                scoreDTO.setAttribute_name("文档");
            }else {
                scoreDTO.setAttribute_name("视频");
            }

            QueryWrapper<Document> wrapper1 = new QueryWrapper();
            wrapper1.eq("attribute",score.getAttribute()).eq("document_id",score.getDocument_id());
            List<Document> list3 = documentService.list(wrapper1);
            scoreDTO.setDocument_name(list3.get(0).getDocument_name());

            scoreDTO.setDocument_score(score.getDocument_score());
            scoreDTO.setUpdate_time(score.getUpdate_time());

            scoreList.add(scoreDTO);
        }

        return RespBean.success("成功",scoreList);

    }

    @PostMapping("/getListById")
    @ApiOperation(value = "通过用户id查询，分数模块")
    public RespBean getLeanList(@RequestBody String ch){
        String[] split = ch.split("\"");
        ch=split[1];
        System.out.println(ch);
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.eq("user_id",ch);
        List<User> list = userService.list(wrapper);
        List <UserDTO2> list2=new ArrayList<>();
        for(User user:list) {
            UserDTO2 userDTO2=new UserDTO2();
            userDTO2.setUser_id(user.getUser_id());
            userDTO2.setUser_name(user.getUser_name());
            userDTO2.setPhone(user.getPhone());
            QueryWrapper<Department> wrapper1 = new QueryWrapper();
            wrapper.eq("department_id",user.getDepartment_id()).eq("construction_id",user.getConstruction_id());
            List<Department> list1 = departmentService.list(wrapper1);
            userDTO2.setDepartment_name(list1.get(0).getDepartment_name());


            QueryWrapper<Construction> wrapper2 = new QueryWrapper();
            wrapper2.eq("construction_id",user.getConstruction_id());
            List<Construction> list3 = constructionService.list(wrapper2);
            userDTO2.setConstruction_name(list3.get(0).getConstruction_name());



            userDTO2.setScore(scoreService.getScore(Integer.valueOf(user.getUser_id())));

            list2.add(userDTO2);
        }
        return RespBean.success("成功",list2);

    }
}
