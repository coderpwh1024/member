package com.coderpwh.member.application.service;

import com.coderpwh.member.application.command.MemberRefundCommand;

/**
 * @author coderpwh
 * @date 2023/6/27 16:44
 */
public interface RefundService {


    String saveRefund(MemberRefundCommand command);

}
