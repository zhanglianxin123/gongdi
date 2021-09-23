package com.qrs.admin.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.qrs.WeChat.pojo.User;
import com.qrs.admin.pojo.Switch;
import com.qrs.admin.service.ISwitchService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author zlx
 * @description  下发命令处理
 * @Version 1.0
 * @Date 2021/6/24 8:23
 */
public class issueAnOrderUtil {
    @Autowired
    private static ISwitchService switchService;

    //开关或报警
    public static void issueSwitch(Integer switch_id,Integer switch_state){
        UpdateWrapper<Switch> wrapper = new UpdateWrapper();
        wrapper.eq("switch_id",switch_id).set("switch_state",switch_state);
        switchService.update(wrapper);
    }



    //阈值


}
