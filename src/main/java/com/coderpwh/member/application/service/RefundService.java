package com.coderpwh.member.application.service;

import com.coderpwh.member.application.command.MemberRefundCommand;
import com.coderpwh.member.application.vo.MemberRefundVO;

/**
 * @author coderpwh
 * @date 2023/6/27 16:44
 */
public interface RefundService {

    /***
     * 退款
     * @param command
     * @return
     */
    MemberRefundVO saveRefund(MemberRefundCommand command);

}
