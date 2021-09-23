package com.qrs.WeChat.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qrs.WeChat.mapper.ScoreMapper;
import com.qrs.WeChat.pojo.Score;
import com.qrs.WeChat.service.IScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zlx
 * @since 2021-05-30
 */
@Service
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score> implements IScoreService {

    @Autowired
    private ScoreMapper scoreMapper;
    /**
     * 通过user_id获得用户分数
     * @param user_id
     * @return
     */
    @Override
    public Integer getScore(int user_id) {
        System.out.println(scoreMapper.getScore(user_id));
        if(scoreMapper.getScore(user_id)==null){
            return 0;
        }
       return scoreMapper.getScore(user_id);

    }


}
