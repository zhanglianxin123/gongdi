package com.qrs.WeChat.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qrs.WeChat.pojo.User;
import com.qrs.admin.pojo.DTO.UserDetailedDTO3;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zlx
 * @since 2021-06-06
 */
public interface UserMapper extends BaseMapper<User> {


    /**
     * 通过名字查询列表
     * @param user_name
     * @return
     */
    @Select("SELECT * FROM t_user  WHERE user_name like (#{user_name})")
    List<User> getListByName(String user_name);

    /**
     * 获得用户列表
     * @return
     */
    List<UserDetailedDTO3> getList(@Param("from")int from,@Param("toIndex") int toIndex);

    /**
     * 通过名字查询列表
     * @param ch
     * @return
     */
    List<UserDetailedDTO3> getSelectList(String ch);

    /**
     * 通过用户id查询列表
     * @param ch
     * @return
     */
    List<UserDetailedDTO3> getSelectByID(String ch);


}
