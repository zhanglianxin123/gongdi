package com.qrs.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qrs.admin.pojo.DTO.SwitchDTO;
import com.qrs.admin.pojo.Switch;
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
public interface SwitchMapper extends BaseMapper<Switch> {
    /**
     * 开关列表
     * @return
     */
    @Select(" SELECT switch_id,switch_name,switch_state FROM t_switch order by switch_id    asc;;")
    List<SwitchDTO> getList();
}
