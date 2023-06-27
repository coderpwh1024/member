package com.coderpwh.member.web;

import com.coderpwh.member.application.command.MemberRefundCommand;
import com.coderpwh.member.application.service.RefundService;
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
 * @date 2023/6/26 14:29
 */
@Slf4j
@RestController
@RequestMapping("/refund")
public class RefundController {


    @Resource
    private RefundService refundService;


    /***
     * 会员注销与退款
     * @param command
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result saveRefund(@RequestBody @Valid MemberRefundCommand command) {
        return Result.ok(refundService.saveRefund(command));
    }

}
