package com.lby.my12306.biz.ticketservice.controller;

import com.lby.my12306.biz.ticketservice.dto.resp.TrainStationQueryRespDTO;
import com.lby.my12306.biz.ticketservice.service.TrainStationService;
import com.lby.my12306.framework.starter.convention.result.Result;
import com.lby.my12306.framework.starter.web.Results;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 列车站点控制层
 * @author lby
 */
@RestController
@RequiredArgsConstructor
public class TrainStationController {

    private final TrainStationService trainStationService;

    /**
     * 根据列车 ID 查询站点信息
     */
    @GetMapping("/api/ticket-service/train-station/query")
    public Result<List<TrainStationQueryRespDTO>> listTrainStationQuery(String trainId) {
        return Results.success(trainStationService.listTrainStationQuery(trainId));
    }
}
