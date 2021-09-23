package com.qrs.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qrs.WeChat.mapper.DocumentMapper;
import com.qrs.WeChat.pojo.Document;
import com.qrs.WeChat.service.IDocumentService;
import com.qrs.admin.pojo.DTO.DocumentDTO;
import com.qrs.admin.pojo.DTO.PageDTO2;
import com.qrs.admin.pojo.RespBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author zlx
 * @description
 * @Version 1.0
 * @Date 2021/6/11 15:20
 */
@RestController
@RequestMapping("/webDocument")
@Api(value = "文档模块" ,tags = "web文档管理接口")
public class WebDocumentController {
    @Autowired
    private IDocumentService documentService;

    @Autowired
    private DocumentMapper documentMapper;



    @PostMapping("/getSizeByAttribute")
    @ApiOperation(value = "通过属性文章个数")
    private RespBean getSizeByAttribute(@RequestBody Integer attribute){

        QueryWrapper<Document> wrapper = new QueryWrapper();
        wrapper.eq("attribute",attribute);
        List<Document> list = documentService.list(wrapper);

        return  RespBean.success("成功",list.size());
    }

    @PostMapping("/getList")
    @ApiOperation(value = "通过属性获得列表，分页")
    private RespBean getList(@RequestBody PageDTO2 pageDTO2){
        int current=pageDTO2.getCurrent();
        int size=pageDTO2.getSize();
        int attribute=pageDTO2.getAttribute();
        IPage<Document> Page = new Page<>(current, size);

        QueryWrapper<Document> wrapper = new QueryWrapper();
        wrapper.eq("attribute",attribute);

        IPage<Document> userIPage = documentMapper.selectPage(Page, wrapper);
        List<Document> records = userIPage.getRecords();

        List<Document> list = documentService.list(wrapper);
        return RespBean.success("成功",records);
    }

    @PostMapping("/getListById")
    @ApiOperation(value = "查询通过属性和编号获得列表")
    private RespBean getListById(@RequestBody DocumentDTO documentDTO){
        System.out.println(documentDTO.toString());

        QueryWrapper<Document> wrapper = new QueryWrapper();
        wrapper.eq("attribute",documentDTO.getAttribute()).eq("document_id",documentDTO.getDocument_id());
        System.out.println(documentDTO);
        List<Document> list = documentService.list(wrapper);
        return RespBean.success("成功",list);
    }

    @PostMapping("/insert")
    @ApiOperation(value = "添加文档")
    private RespBean insertDocument(@RequestBody  Document document){
        if(documentService.save(document)){
            return  RespBean.success("插入成功",document);
        }
        return RespBean.error("添加失败");
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除文档")
    private RespBean deleteDocument(@RequestBody  DocumentDTO documentDTO){
        QueryWrapper<Document> wrapper = new QueryWrapper();
        wrapper.eq("attribute",documentDTO.getAttribute()).eq("document_id",documentDTO.getDocument_id());

        if(documentService.remove(wrapper)){
            return  RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @PostMapping("/update")
    @ApiOperation(value = "修改文档")
    private RespBean updateDocument( @RequestBody  Document document){
        QueryWrapper<Document> wrapper = new QueryWrapper();
        wrapper.eq("attribute",document.getAttribute()).eq("document_id",document.getDocument_id());

        if(documentService.remove(wrapper)&&documentService.save(document)){
            return  RespBean.success("修改成功",document);
        }
        return RespBean.error("修改失败");
    }
}
