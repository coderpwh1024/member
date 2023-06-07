package com.coderpwh.member.web;

import com.coderpwh.member.application.command.OrderInfoQuery;
import com.coderpwh.member.application.service.OrderOrderService;
import com.coderpwh.member.common.util.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author coderpwh
 * @date 2023/6/7 15:43
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {


    @Resource
    private OrderOrderService orderService;


    /***
     * 获取订单信息
     * @param query
     * @return
     */
    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public Result getOrderInfo(@RequestBody @Valid OrderInfoQuery query) {
        return Result.ok(orderService.getOrderInfo(query));
    }

}
