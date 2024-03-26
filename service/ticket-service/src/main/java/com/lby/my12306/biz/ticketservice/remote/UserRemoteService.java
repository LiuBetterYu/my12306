package com.lby.my12306.biz.ticketservice.remote;

import com.lby.my12306.biz.ticketservice.remote.dto.PassengerRespDTO;
import com.lby.my12306.framework.starter.convention.result.Result;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

/**
 * 用户远程服务调用
 * @author lby
 */
@FeignClient(value = "my12306-user${unique-name:}-service", url = "${aggregation.remote-url:}")
public interface UserRemoteService {

    /**
     * 根据乘车人 ID 集合查询乘车人列表
     */
    Result<List<PassengerRespDTO>> listPassengerQueryByIds(String username, List<String> passengerIds);
}
