package com.coderpwh.member.web;

import com.coderpwh.member.application.command.MemberJoinCommand;
import com.coderpwh.member.application.command.MemberPackageDetailQuery;
import com.coderpwh.member.application.command.MemberPackageOrderQuery;
import com.coderpwh.member.application.command.MemberRefundCommand;
import com.coderpwh.member.application.service.MemberService;
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
 * @date 2023/5/22 11:33
 */

@Slf4j
@RestController
@RequestMapping("/member")
public class MemberController {


    @Resource
    private MemberService memberService;


    /***
     * 开通会员
     * @param command
     * @return
     */
    @RequestMapping(value = "/saveMember", method = RequestMethod.POST)
    public Result saveMember(@RequestBody @Valid MemberJoinCommand command) {
        return Result.ok(memberService.saveMember(command));
    }


    /***
     * 会员注销与退款
     * @param command
     * @return
     */
    @RequestMapping(value = "/refund", method = RequestMethod.POST)
    public Result refundMember(@RequestBody @Valid MemberRefundCommand command) {
        return Result.ok(memberService.refundMember(command));
    }


    /***
     *  查询会员权益包
     * @return
     */
    @RequestMapping(value = "/package/detail", method = RequestMethod.POST)
    public Result getPackageDetail(@RequestBody @Valid MemberPackageDetailQuery query) {
        return Result.ok(memberService.getPackageDetail(query));
    }


    /***
     *会员套餐订单查询
     * @return
     */
    @RequestMapping(value = "/package/order", method = RequestMethod.POST)
    public Result getParckageOrder(@RequestBody @Valid MemberPackageOrderQuery query) {
        return Result.ok(memberService.getParckageOrder(query));
    }


}
