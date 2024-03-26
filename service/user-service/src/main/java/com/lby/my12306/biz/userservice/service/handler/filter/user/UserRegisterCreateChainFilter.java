package com.lby.my12306.biz.userservice.service.handler.filter.user;

import com.lby.my12306.biz.userservice.common.enums.UserChainMarkEnum;
import com.lby.my12306.biz.userservice.dto.req.UserRegisterReqDTO;
import com.lby.my12306.framework.starter.designpattern.chain.AbstractChainHandler;

/**
 * 用户注册责任链过滤器
 * @author lby
 */
public interface UserRegisterCreateChainFilter<T extends UserRegisterReqDTO> extends AbstractChainHandler<UserRegisterReqDTO> {

    /**
     * @return 责任链组件标识
     */
    @Override
    default String mark(){
        return UserChainMarkEnum.USER_REGISTER_FILTER.name();
    }
}
