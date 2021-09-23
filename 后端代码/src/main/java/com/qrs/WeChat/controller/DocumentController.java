package com.qrs.WeChat.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qrs.WeChat.pojo.Document;
import com.qrs.WeChat.service.IDocumentService;
import com.qrs.admin.annotation.PassToken;
import com.qrs.admin.pojo.RespBean;
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
 * @since 2021-05-15
 */
@RestController
@RequestMapping("//document")
@Api(value = "微信小程序文档模块" ,tags = "微信小程序文档接口")
public class DocumentController {
    @Autowired
    private IDocumentService documentService;

    @PassToken
    @PostMapping("/list")
    @ApiOperation(value = "获取该类下的文档列表")
    public List<Document> getList(@RequestBody Map<String,Object> params){
        String attribute=params.get("attribute").toString();
        QueryWrapper<Document> wrapper = new QueryWrapper();
        wrapper.eq("attribute",attribute);
        List<Document> list=documentService.list(wrapper);
        return list;
    }
    @PassToken
    @GetMapping("/listStudy")
    @ApiOperation(value = "最新三条文档")
    public RespBean listStudy(){
        QueryWrapper<Document> wrapper = new QueryWrapper();
        wrapper.eq("attribute",1);
        List<Document> list=documentService.list(wrapper);
        QueryWrapper<Document> wrapper2 = new QueryWrapper();
        wrapper2.eq("attribute",2);
        List<Document> list2=documentService.list(wrapper);
        Map<String,Object> map=new HashMap<>();
        map.put("document",list);
        map.put("video",list2);
        return RespBean.success("成功",map);
    }


}
