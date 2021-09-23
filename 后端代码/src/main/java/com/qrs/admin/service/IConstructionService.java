package com.qrs.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qrs.admin.pojo.Construction;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zlx
 * @since 2021-06-09
 */
public interface IConstructionService extends IService<Construction> {
    /**
     * 修改工地信息
     * @param construction
     */
    void updateConstruction(Construction construction);

    /**
     * 工地名查询工地
     * @param ch
     * @return
     */
    List<Construction> getListByName(String ch);
}
