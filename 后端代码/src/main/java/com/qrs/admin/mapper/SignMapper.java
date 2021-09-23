package com.qrs.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qrs.admin.pojo.DTO.SignDTO;
import com.qrs.admin.pojo.Sign;
import org.apache.ibatis.annotations.Param;
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
public interface SignMapper extends BaseMapper<Sign> {

    /**
     * 获得今天的签到记录
     * @param today
     * @return
     */
    @Select("SELECT *  " +
            "FROM t_sign  " +
            "WHERE DATE_FORMAT(create_time,'%Y-%m-%d')= #{today}")
    public List<Sign> getInDataDay(String today);


    /**
     * 获得当月的签到记录
     * @param math
     * @return
     */
    @Select("SELECT *  " +
            "FROM t_sign  " +
            "WHERE DATE_FORMAT(create_time,'%Y-%m')= #{math};")
    List<Sign> getInDataMath(String math);

    /**
     * 获得最近的签到数据
     * @return
     */
    List<SignDTO> getSignRecently(int li);

    List<SignDTO> getList();

    /**
     * 通过user_id查询记录,分页
     * @param user_id
     * @param fromIndex
     * @param toIndex
     * @return
     */
    List<SignDTO> getSelectByID(@Param("user_id")String user_id,@Param("fromIndex") int fromIndex,@Param("toIndex") int toIndex);

    List<SignDTO> getSelectByTime(@Param("ch")String ch,@Param("fromIndex") int fromIndex,@Param("toIndex") int toIndex);

    List<SignDTO> getSelectByTime2(String ch);
}
