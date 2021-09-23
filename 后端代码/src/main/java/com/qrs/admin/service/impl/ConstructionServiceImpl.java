package com.qrs.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qrs.admin.mapper.ConstructionMapper;
import com.qrs.admin.pojo.Construction;
import com.qrs.admin.service.IConstructionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zlx
 * @since 2021-06-09
 */
@Service
public class ConstructionServiceImpl extends ServiceImpl<ConstructionMapper, Construction> implements IConstructionService {
    @Autowired
    private ConstructionMapper constructionMapper;
    /**
     * 修改工地信息
     * @param construction
     */
    @Override
    public void updateConstruction(Construction construction) {
        constructionMapper.updateConstruction(construction);
    }

    /**
     * 工地名查询工地
     * @param ch
     * @return
     */
    @Override
    public List<Construction> getListByName(String ch) {
        return constructionMapper.getListByName(ch);
    }
}
