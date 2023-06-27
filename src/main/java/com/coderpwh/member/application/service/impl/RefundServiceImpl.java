package com.coderpwh.member.application.service.impl;

import com.coderpwh.member.application.command.MemberRefundCommand;
import com.coderpwh.member.application.service.RefundService;
import org.springframework.stereotype.Service;

/**
 * 退款操作
 *
 * @author coderpwh
 * @date 2023/6/27 16:44
 */
@Service
public class RefundServiceImpl implements RefundService {

    @Override
    public String saveRefund(MemberRefundCommand command) {
        return "";
    }


}
