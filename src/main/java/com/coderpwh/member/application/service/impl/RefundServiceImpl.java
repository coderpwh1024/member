package com.coderpwh.member.application.service.impl;

import com.coderpwh.member.application.command.MemberRefundCommand;
import com.coderpwh.member.application.dto.MemberUserDTO;
import com.coderpwh.member.application.service.RefundService;
import com.coderpwh.member.application.vo.MemberRefundVO;
import com.coderpwh.member.domain.util.LoginUtil;
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
    public MemberRefundVO saveRefund(MemberRefundCommand command) {
        // 获取登录用户
        MemberUserDTO memberUser = LoginUtil.loginUser();
        return null;
    }


}
