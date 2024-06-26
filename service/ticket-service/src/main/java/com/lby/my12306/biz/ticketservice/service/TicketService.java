package com.lby.my12306.biz.ticketservice.service;

import com.lby.my12306.biz.ticketservice.dto.req.PurchaseTicketReqDTO;
import com.lby.my12306.biz.ticketservice.dto.req.TicketPageQueryReqDTO;
import com.lby.my12306.biz.ticketservice.dto.resp.TicketPageQueryRespDTO;
import com.lby.my12306.biz.ticketservice.dto.resp.TicketPurchaseRespDTO;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author lby
 */
public interface TicketService {

    /**
     * 根据条件分页查询车票
     *
     * @param requestParam 分页查询车票请求参数
     * @return 查询车票返回结果
     */
    TicketPageQueryRespDTO pageListTicketQueryV1(TicketPageQueryReqDTO requestParam);

    /**
     * 根据条件分页查询车票V2高性能版本
     *
     * @param requestParam 分页查询车票请求参数
     * @return 查询车票返回结果
     */
    TicketPageQueryRespDTO pageListTicketQueryV2(TicketPageQueryReqDTO requestParam);

    /**
     * 购买车票
     *
     * @param requestParam 车票购买请求参数
     * @return 订单号
     */
    TicketPurchaseRespDTO purchaseTicketsV1(@RequestBody PurchaseTicketReqDTO requestParam);


    /**
     * 执行购买车票
     * 被对应购票版本号接口调用 {@link TicketService#purchaseTicketsV1(PurchaseTicketReqDTO)} and {@link TicketService#purchaseTicketsV2(PurchaseTicketReqDTO)}
     *
     * @param requestParam 车票购买请求参数
     * @return 订单号
     */
    TicketPurchaseRespDTO executePurchaseTickets(PurchaseTicketReqDTO requestParam);


    /**
     * 购买车票V2高性能版本
     *
     * @param requestParam 车票购买请求参数
     * @return 订单号
     */
    TicketPurchaseRespDTO purchaseTicketsV2(@RequestBody PurchaseTicketReqDTO requestParam);
}
