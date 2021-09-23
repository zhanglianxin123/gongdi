package com.qrs.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qrs.admin.pojo.Limit;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zlx
 * @since 2021-06-09
 */
public interface ILimitService extends IService<Limit> {
    /**
     * 获得列表
     * @return
     */
    List<Limit> getList();
}
