package com.qrs.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qrs.admin.pojo.Construction;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zlx
 * @since 2021-06-09
 */
public interface ConstructionMapper extends BaseMapper<Construction> {
    @Update("update t_construction set construction_number=#{construction_number},construction_name=#{construction_name},construction_longitude=#{construction_longitude},construction_latitude=#{construction_latitude},head_name=#{head_name},head_phone=#{head_phone},create_time=#{create_time},update_time=#{update_time},construction_people=#{construction_people},construction_address=#{construction_address} where construction_id=#{construction_id}")
    void updateConstruction(Construction construction);


    /**
     * 工地名查询工地
     * @param ch
     * @return
     */
    @Select(" SELECT * FROM t_construction WHERE t_construction.`construction_name` LIKE(#{CH})")
    List<Construction> getListByName(String ch);
}
