package com.qrs.WeChat.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qrs.WeChat.pojo.Score;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zlx
 * @since 2021-05-30
 */
public interface ScoreMapper extends BaseMapper<Score> {
    /**
     * 通过user_id获得用户分数
     * @param user_id
     * @return
     */
    @Select("SELECT SUM(document_score) \n" +
            "FROM t_score \n" +
            "WHERE user_id=#{user_id};")
    Integer getScore(int user_id);


}
