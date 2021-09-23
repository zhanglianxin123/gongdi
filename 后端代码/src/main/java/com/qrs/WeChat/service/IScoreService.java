package com.qrs.WeChat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qrs.WeChat.pojo.Score;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zlx
 * @since 2021-05-30
 */
public interface IScoreService extends IService<Score> {
    /**
     * 通过user_id获得用户分数
     * @param user_id
     * @return
     */
    Integer getScore(int user_id);


}
