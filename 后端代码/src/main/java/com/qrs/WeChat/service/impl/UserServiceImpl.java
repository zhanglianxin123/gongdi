package com.qrs.WeChat.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qrs.WeChat.mapper.UserMapper;
import com.qrs.WeChat.pojo.User;
import com.qrs.WeChat.service.IUserService;
import com.qrs.admin.pojo.DTO.UserDetailedDTO3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zlx
 * @since 2021-06-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 通过名字查询列表
     * @param user_name
     * @return
     */
    @Override
    public List<User> getListByName(String user_name) {
        user_name="%"+user_name+"%";
        return userMapper.getListByName(user_name);
    }


    /**
     * 获得用户列表
     * @return
     */
    @Override
    public List<UserDetailedDTO3> getList(Integer fromIndex,Integer toIndex) {
        System.out.println(fromIndex+"aaaa"+toIndex);
        return userMapper.getList(fromIndex,toIndex);
    }

    /**
     * 通过名字查询列表
     * @param ch
     * @return
     */
    @Override
    public List<UserDetailedDTO3> getSelectList(String ch) {
        return userMapper.getSelectList(ch);
    }

    /**
     * 通过用户id查询列表
     * @param ch
     * @return
     */
    @Override
    public List<UserDetailedDTO3> getSelectByID(String ch) {
        return userMapper.getSelectByID(ch);
    }


}
