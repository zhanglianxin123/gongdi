package com.qrs.admin.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.qrs.admin.pojo.DTO.LimitDTO;
import com.qrs.admin.pojo.Limit;
import com.qrs.admin.pojo.RespBean;
import com.qrs.admin.service.ILimitService;
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
@RequestMapping("//limit")
@Api(value = "阈值模块" ,tags = "web阈值接口")
public class LimitController {

    @Autowired
    private ILimitService limitService;

    @GetMapping("/getList")
    @ApiOperation(value = "获得列表")
    public RespBean getList(){
        List<Limit> list = limitService.getList();
        return RespBean.success("成功",list);

    }

    @PostMapping("/updateMin")
    @ApiOperation(value = "通过id修改阈值,最小值")
    public RespBean updateMin(@RequestBody LimitDTO limitDTO){
        System.out.println(limitDTO.toString());
        UpdateWrapper<Limit> wrapper = new UpdateWrapper();
        wrapper.eq("device_id",limitDTO.getDevice_id())
                .set("min_value",limitDTO.getValue());
        if(limitService.update(wrapper)){
            return RespBean.success("成功",limitDTO);
        }
        return RespBean.error("失败");
    }

    @PostMapping("/updateMax")
    @ApiOperation(value = "通过id修改阈值,最大值")
    public RespBean updateMax(@RequestBody LimitDTO limitDTO){
        System.out.println(limitDTO.toString());
        UpdateWrapper<Limit> wrapper = new UpdateWrapper();
        wrapper.eq("device_id",limitDTO.getDevice_id())
                .set("max_value",limitDTO.getValue());
        if(limitService.update(wrapper)){
            return RespBean.success("成功",limitDTO);
        }
        return RespBean.error("失败");
    }

}
