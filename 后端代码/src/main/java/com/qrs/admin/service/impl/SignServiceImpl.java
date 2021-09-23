package com.qrs.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qrs.admin.mapper.SignMapper;
import com.qrs.admin.pojo.DTO.SignDTO;
import com.qrs.admin.pojo.Sign;
import com.qrs.admin.service.ISignService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zlx
 * @since 2021-06-09
 */
@Service
public class SignServiceImpl extends ServiceImpl<SignMapper, Sign> implements ISignService {


    @Resource
    public SignMapper signMapper;

    /**
     * 获得今天的签到记录
     * @param today
     * @return
     */
    @Override
    public List<Sign> getInDataDay(String today) {
        return signMapper.getInDataDay(today);
    }

    /**
     * 获得当月的签到记录
     * @param math
     * @return
     */
    @Override
    public List<Sign> getInDataMath(String math) {
        return signMapper.getInDataMath(math);
    }

    /**
     *获得最近的签到数据
     * @return
     */
    @Override
    public List<SignDTO> getSignRecently(int li) {
        return signMapper.getSignRecently(li);
    }

    @Override
    public List<SignDTO> getList() {
        return signMapper.getList();
    }



    /**
     * 通过user_id查询记录,分页
     * @param user_id
     * @return
     */
    @Override
    public List<SignDTO> getSelectByID(String user_id, Integer fromIndex, Integer toIndex) {
        System.out.println("fromIndex:"+fromIndex);
        return signMapper.getSelectByID(user_id,fromIndex,toIndex);
    }

    /**
     * 通过时间查询记录
     * @param ch
     * @param fromIndex
     * @param toIndex
     * @return
     */
    @Override
    public List<SignDTO> getSelectByTime(String ch, int fromIndex, int toIndex) {
        return signMapper.getSelectByTime(ch,fromIndex,toIndex);
    }
    @Override
    public List<SignDTO> getSelectByTime2(String ch) {
        return signMapper.getSelectByTime2(ch);
    }


}
