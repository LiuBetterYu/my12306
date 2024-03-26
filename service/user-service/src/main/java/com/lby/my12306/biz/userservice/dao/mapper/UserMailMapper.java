package com.lby.my12306.biz.userservice.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lby.my12306.biz.userservice.dao.entity.UserMailDO;

/**
 * 用户邮箱表持久层
 * @author lby
 */
public interface UserMailMapper extends BaseMapper<UserMailDO> {
    void deletionUser(UserMailDO userMailDO);
}
