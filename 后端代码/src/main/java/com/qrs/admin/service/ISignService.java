package com.qrs.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qrs.admin.pojo.DTO.SignDTO;
import com.qrs.admin.pojo.Sign;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zlx
 * @since 2021-06-09
 */
public interface ISignService extends IService<Sign> {


    /**
     * 获得今天的签到记录
     * @param today
     * @return
     */
    List<Sign> getInDataDay(String today);


    /**
     * 获得当月的签到记录
     * @param math
     * @return
     */
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
     * @return
     */
    List<SignDTO> getSelectByID(String user_id, Integer fromIndex, Integer toIndex);

    /**
     * 通过时间查询记录
     * @param ch
     * @param fromIndex
     * @param toIndex
     * @return
     */
    List<SignDTO> getSelectByTime(String ch, int fromIndex, int toIndex);
    List<SignDTO> getSelectByTime2(String ch);
}
