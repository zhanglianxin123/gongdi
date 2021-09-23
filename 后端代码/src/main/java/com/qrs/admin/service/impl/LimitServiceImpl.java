package com.qrs.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qrs.admin.mapper.LimitMapper;
import com.qrs.admin.pojo.Limit;
import com.qrs.admin.service.ILimitService;
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
public class LimitServiceImpl extends ServiceImpl<LimitMapper, Limit> implements ILimitService {
    @Autowired
    private LimitMapper limitMapper;
    /**
     * 获得列表
     * @return
     */
    @Override
    public List<Limit> getList() {
        return limitMapper.getList();
    }
}
