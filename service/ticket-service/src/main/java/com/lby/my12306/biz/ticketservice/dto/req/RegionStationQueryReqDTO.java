package com.lby.my12306.biz.ticketservice.dto.req;

import lombok.Data;

/**
 * 地区&站点查询请求入参
 * @author lby
 */
@Data
public class RegionStationQueryReqDTO {

    /**
     * 查询方式
     */
    private Integer queryType;

    /**
     * 名称
     */
    private String name;
}
