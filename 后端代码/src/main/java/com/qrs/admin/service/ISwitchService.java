package com.qrs.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qrs.admin.pojo.DTO.SwitchDTO;
import com.qrs.admin.pojo.Switch;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zlx
 * @since 2021-06-09
 */
public interface ISwitchService extends IService<Switch> {
    /**
     * 开关列表
     * @return
     */
    List<SwitchDTO> getList();
}
