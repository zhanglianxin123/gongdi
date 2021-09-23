package com.qrs.WeChat.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qrs.WeChat.pojo.Score;
import com.qrs.WeChat.service.IScoreService;
import com.qrs.admin.annotation.PassToken;
import com.qrs.admin.pojo.RespBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zlx
 * @since 2021-05-30
 */
@RestController
@RequestMapping("//score")
@Api(value = "微信小程序分数接口" ,tags = "微信小程序分数接口")
public class ScoreController {

    @Autowired
    private IScoreService scoreService;

    @PassToken
    @PostMapping("/look")
    @ApiOperation(value = "用户点击了表,加分")
    public RespBean look(@RequestBody Map<String,Object> params){
        Score score=new Score();
        score.setUser_id(Integer.valueOf(params.get("user_id").toString()));
        score.setAttribute(Integer.valueOf(params.get("attribute").toString()));
        score.setDocument_id(Integer.valueOf(params.get("document_id").toString()));
        score.setDocument_score(Integer.valueOf(params.get("document_score").toString()));
       //还需要先查询是否已经存入
        QueryWrapper<Score> wrapper = new QueryWrapper();
        wrapper.eq("user_id",score.getUser_id()).eq("attribute",score.getAttribute())
                .eq("document_id",score.getDocument_id());
        List<Score> list = scoreService.list(wrapper);
        if(list.size()>0){
            return RespBean.success("已经查看该内容");
        } else if(scoreService.save(score)){
           return RespBean.success("加分成功");
        }
        return RespBean.error("加分失败");

    }
    @PassToken
    @PostMapping("/get")
    @ApiOperation(value = "通过用户id获得分数")
    public Integer getScore(@RequestBody Map<String,Object> params){
        int user_id=Integer.valueOf(params.get("user_id").toString());
        return scoreService.getScore(user_id);
    }

}
