package com.qrs.admin.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qrs.admin.pojo.Construction;
import com.qrs.admin.pojo.RespBean;
import com.qrs.admin.service.IConstructionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("//construction")
@Api(value = "工地模块" ,tags = "web工地接口")
public class ConstructionController {

    @Autowired
    private IConstructionService constructionService;

    @GetMapping("/list")
    @ApiOperation(value = "获得工地列表")
    public RespBean getList(){
        List<Construction> list = constructionService.list();
        return RespBean.success("成功",list);

    }

    @PostMapping("/addConstruction")
    @ApiOperation(value = "添加工地")
    public RespBean addUser(@RequestBody Construction construction){
        if(constructionService.save(construction)){
            return  RespBean.success("添加成功");
        }
        return  RespBean.success("添加失败");
    }

    @PostMapping("/getByID")
    @ApiOperation(value = "通过工地id获得工地信息")
    public RespBean getByID(@RequestBody Integer ch){

        QueryWrapper<Construction> queryWrapper = new QueryWrapper();
        queryWrapper.eq("construction_id",ch);
        List<Construction> list = constructionService.list(queryWrapper);
        return RespBean.success("成功",list);
    }

    @PostMapping("/getListByID")
    @ApiOperation(value = "通过工地id或工地名查询工地")
    public RespBean getListByID(@RequestBody String ch){
        //切割掉双引号
        String[] split = ch.split("\"");
        ch=split[1];
        System.out.println(ch);

        QueryWrapper<Construction> queryWrapper = new QueryWrapper();
        queryWrapper.eq("construction_id",ch);
        List<Construction> list = constructionService.list(queryWrapper);

        ch="%"+ch+"%";
        List<Construction> list1 =constructionService.getListByName(ch);
        if(list.size()>0){
            return RespBean.success("成功",list);
        }
        return RespBean.success("成功",list1);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "通过工地id删除工地")
    public RespBean deleteConstruction(@RequestBody int construction_id){
        QueryWrapper<Construction> queryWrapper = new QueryWrapper();
        queryWrapper.eq("construction_id",construction_id);
        if (constructionService.remove(queryWrapper)){
            return RespBean.success("工地删除成功!");
        }
        return RespBean.success("工地删除失败!");
    }
    @ApiOperation(value = "修改工地信息")
    @PostMapping("/updateConstruction")
    public  RespBean updateConstruction(@RequestBody Construction construction){
        constructionService.updateConstruction(construction);
        return RespBean.success("修改成功",construction);
    }

}
