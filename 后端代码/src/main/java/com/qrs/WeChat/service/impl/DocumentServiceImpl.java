package com.qrs.WeChat.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qrs.WeChat.mapper.DocumentMapper;
import com.qrs.WeChat.pojo.Document;
import com.qrs.WeChat.service.IDocumentService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zlx
 * @since 2021-05-15
 */
@Service
public class DocumentServiceImpl extends ServiceImpl<DocumentMapper, Document> implements IDocumentService {

}
