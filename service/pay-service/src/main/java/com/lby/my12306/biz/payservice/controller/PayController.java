package com.lby.my12306.biz.payservice.controller;

import com.lby.my12306.biz.payservice.service.PayService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付控制层
 * @author lby
 */
@RestController
@RequiredArgsConstructor
public class PayController {

    private final PayService payService;
}
