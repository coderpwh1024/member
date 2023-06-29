package com.coderpwh.member.application.service.impl;

import com.coderpwh.member.application.command.MemberRefundCommand;
import com.coderpwh.member.application.dto.MemberUserDTO;
import com.coderpwh.member.application.service.RefundService;
import com.coderpwh.member.application.vo.MemberRefundVO;
import com.coderpwh.member.domain.model.MemberCardHistoryRepository;
import com.coderpwh.member.domain.model.MemberTenantExtraInfoRepository;
import com.coderpwh.member.domain.specification.RefundSpecification;
import com.coderpwh.member.domain.util.LoginUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 退款操作
 *
 * @author coderpwh
 * @date 2023/6/27 16:44
 */
@Service
public class RefundServiceImpl implements RefundService {


    @Resource
    private MemberCardHistoryRepository memberCardHistoryRepository;

    @Resource
    private MemberTenantExtraInfoRepository memberTenantExtraInfoRepository;

    @Override
    public MemberRefundVO saveRefund(MemberRefundCommand command) {
        MemberRefundVO memberRefundVO = new MemberRefundVO();

        // 获取登录用户
        MemberUserDTO memberUser = LoginUtil.loginUser();

        // 校验
        RefundSpecification specification = new RefundSpecification(memberCardHistoryRepository, memberTenantExtraInfoRepository);
        specification.isValidRefund(command, memberUser);


        return memberRefundVO;
    }


}
