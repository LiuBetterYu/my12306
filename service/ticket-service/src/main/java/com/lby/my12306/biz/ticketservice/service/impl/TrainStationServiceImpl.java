package com.lby.my12306.biz.ticketservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.lby.my12306.biz.ticketservice.dao.entity.TrainStationDO;
import com.lby.my12306.biz.ticketservice.dao.mapper.TrainStationMapper;
import com.lby.my12306.biz.ticketservice.dto.domain.RouteDTO;
import com.lby.my12306.biz.ticketservice.dto.resp.TrainStationQueryRespDTO;
import com.lby.my12306.biz.ticketservice.service.TrainStationService;
import com.lby.my12306.biz.ticketservice.toolkit.StationCalculateUtil;
import com.lby.my12306.framework.starter.common.toolkit.BeanUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 列车站点接口实现层
 * @author lby
 */
@Service
@RequiredArgsConstructor
public class TrainStationServiceImpl implements TrainStationService {

    private final TrainStationMapper trainStationMapper;

    @Override
    public List<TrainStationQueryRespDTO> listTrainStationQuery(String trainId) {
        LambdaQueryWrapper<TrainStationDO> queryWrapper = Wrappers.lambdaQuery(TrainStationDO.class)
                .eq(TrainStationDO::getTrainId, trainId);
        List<TrainStationDO> trainStationDOList = trainStationMapper.selectList(queryWrapper);
        return BeanUtil.convert(trainStationDOList, TrainStationQueryRespDTO.class);
    }

    /**
     * 计算列车站点路线关系
     * 获取开始站点和目的站点及中间站点信息
     *
     * @param trainId   列车 ID
     * @param departure 出发站
     * @param arrival   到达站
     * @return 列车站点路线关系信息
     */
    @Override
    public List<RouteDTO> listTrainStationRoute(String trainId, String departure, String arrival) {
        LambdaQueryWrapper<TrainStationDO> queryWrapper = Wrappers.lambdaQuery(TrainStationDO.class)
                .eq(TrainStationDO::getTrainId, trainId)
                .select(TrainStationDO::getDeparture);
        List<TrainStationDO> trainStationDOList = trainStationMapper.selectList(queryWrapper);
        List<String> trainStationAllList = trainStationDOList.stream().map(TrainStationDO::getDeparture).collect(Collectors.toList());
        return StationCalculateUtil.throughStation(trainStationAllList, departure, arrival);
    }

    /**
     * 获取需列车站点扣减路线关系
     * 获取开始站点和目的站点、中间站点以及关联站点信息
     *
     * @param trainId   列车 ID
     * @param departure 出发站
     * @param arrival   到达站
     * @return 需扣减列车站点路线关系信息
     */
    @Override
    public List<RouteDTO> listTakeoutTrainStationRoute(String trainId, String departure, String arrival) {
        LambdaQueryWrapper<TrainStationDO> queryWrapper = Wrappers.lambdaQuery(TrainStationDO.class)
                .eq(TrainStationDO::getTrainId, trainId)
                .select(TrainStationDO::getDeparture);
        List<TrainStationDO> trainStationDOList = trainStationMapper.selectList(queryWrapper);
        List<String> trainStationAllList = trainStationDOList.stream().map(TrainStationDO::getDeparture).collect(Collectors.toList());
        return StationCalculateUtil.takeoutStation(trainStationAllList, departure, arrival);
    }
}
