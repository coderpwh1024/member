package com.coderpwh.member.web;

import com.coderpwh.member.application.command.OrderInfoQuery;
import com.coderpwh.member.application.command.RefundOrderQuery;
import com.coderpwh.member.application.service.RefundOrderService;
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
 * @date 2023/6/8 10:40
 */
@Slf4j
@RestController
@RequestMapping("/refund")
public class RefundOrderController {


    @Resource
    private RefundOrderService refundOrderService;


    /***
     * 获取退款订单查询
     * @param query
     * @return
     */
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public Result getRefundOrderInfo(@RequestBody @Valid RefundOrderQuery query) {
        return Result.ok(refundOrderService.getRefundOrderInfo(query));
    }


}
