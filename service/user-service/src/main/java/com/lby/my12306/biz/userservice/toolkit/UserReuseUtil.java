package com.lby.my12306.biz.userservice.toolkit;

import static com.lby.my12306.biz.userservice.common.constant.My12306Constant.USER_REGISTER_REUSE_SHARDING_COUNT;

/**
 * 用户可复用工具类
 * @author lby
 */
public final class UserReuseUtil {

    public static int hashShardingIdx(String username) {
        return Math.abs(username.hashCode() % USER_REGISTER_REUSE_SHARDING_COUNT);
    }
}
