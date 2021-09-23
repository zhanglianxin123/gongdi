package com.qrs.admin.controller;


import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.qrs.admin.pojo.DTO.SwitchDTO;
import com.qrs.admin.pojo.RespBean;
import com.qrs.admin.pojo.Switch;
import com.qrs.admin.pojo.Warningrecord;
import com.qrs.admin.service.ISwitchService;
import com.qrs.admin.service.IWarningrecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zlx
 * @since 2021-06-09
 */
@RestController
@RequestMapping("//switch")
@Api(value = "开关模块" ,tags = "web开关管理接口")
public class SwitchController {

    @Autowired
    private ISwitchService switchService;

    @Autowired
    private IWarningrecordService warmingrecordService;

    /**
     * 查询所有开关状态
     */
    @GetMapping("/switchList")
    @ApiOperation("开关列表")
    public RespBean switchList() {
        List<SwitchDTO> list = switchService.getList();
        return RespBean.success("成功", list);
    }

    @PostMapping("/update")
    @ApiOperation("修改开关状态")
    public RespBean updatesSwitch(@RequestBody SwitchDTO sw) {
        System.out.println(sw.getSwitch_id());
        if(sw.getSwitch_id()!=8&&sw.getSwitch_state()==0){
            QueryWrapper<Warningrecord> wrapper = new QueryWrapper();
            wrapper.eq("warning_id",sw.getSwitch_id());
            List<Warningrecord> list = warmingrecordService.list(wrapper);
            Warningrecord warningrecord = list.get(list.size() - 1);

            UpdateWrapper<Warningrecord> wrapper1 = new UpdateWrapper();
            wrapper1.eq("id",warningrecord.getId()).set("shutdown_time", DateUtil.now());
            warmingrecordService.update(wrapper1);

        }

        UpdateWrapper<Switch> wrapper = new UpdateWrapper();
        wrapper.eq("switch_id",sw.getSwitch_id()).set("switch_state",sw.getSwitch_state());
        if(switchService.update(wrapper)){
            return RespBean.success("成功",sw);
        }
        return RespBean.success("失败");
    }


    @GetMapping("/getWarning")
    @ApiOperation("得到警告记录")
    public RespBean getWarning() {
        List<Warningrecord> list = warmingrecordService.list();
        return RespBean.success("成功",list);

    }




}
