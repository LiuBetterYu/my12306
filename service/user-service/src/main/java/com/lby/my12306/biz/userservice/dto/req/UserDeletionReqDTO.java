package com.lby.my12306.biz.userservice.dto.req;

import lombok.Data;

/**
 * 用户注销请求参数
 * @author lby
 */
@Data
public class UserDeletionReqDTO {

    /**
     * 用户名
     */
    private String username;
}
