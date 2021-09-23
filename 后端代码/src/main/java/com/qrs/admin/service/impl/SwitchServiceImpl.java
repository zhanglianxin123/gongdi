package com.qrs.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qrs.admin.mapper.SwitchMapper;
import com.qrs.admin.pojo.DTO.SwitchDTO;
import com.qrs.admin.pojo.Switch;
import com.qrs.admin.service.ISwitchService;
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
public class SwitchServiceImpl extends ServiceImpl<SwitchMapper, Switch> implements ISwitchService {
    @Autowired
    private SwitchMapper switchMapper;
    /**
     * 开关列表
     * @return
     */
    @Override
    public List<SwitchDTO> getList() {
        return switchMapper.getList();
    }
}
