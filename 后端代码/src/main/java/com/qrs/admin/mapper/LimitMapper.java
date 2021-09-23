package com.qrs.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qrs.admin.pojo.Limit;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zlx
 * @since 2021-06-09
 */
public interface LimitMapper extends BaseMapper<Limit> {
    /**
     * 获得列表
     * @return
     */
    @Select("select  *  from   t_limit    order by device_id    asc;")
    List<Limit> getList();
}
