package com.qrs.WeChat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qrs.WeChat.pojo.User;
import com.qrs.admin.pojo.DTO.UserDetailedDTO3;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zlx
 * @since 2021-06-06
 */
public interface IUserService extends IService<User> {


    /**
     * 通过名字查询列表
     * @param user_name
     * @return
     */
    List<User> getListByName(String user_name);

    /**
     * 获得用户列表
     * @return
     */
    List<UserDetailedDTO3> getList(Integer fromIndex,Integer toIndex);

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
