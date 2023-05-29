package com.coderpwh.member.application.service.impl;

import com.alibaba.fastjson2.JSON;
import com.coderpwh.member.application.command.MemberJoinCommand;
import com.coderpwh.member.application.command.MemberRefundCommand;
import com.coderpwh.member.application.dto.MemberUserDTO;
import com.coderpwh.member.application.service.MemberService;
import com.coderpwh.member.application.vo.MemberRefundVO;
import com.coderpwh.member.application.vo.MemberSaveVO;
import com.coderpwh.member.domain.model.MemberPackageBenefitRelRepository;
import com.coderpwh.member.domain.model.MemberPackageRepository;
import com.coderpwh.member.domain.model.OrderOrderRepository;
import com.coderpwh.member.domain.service.DomainMemberService;
import com.coderpwh.member.domain.specification.MemberSpecification;
import com.coderpwh.member.domain.util.LoginUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author coderpwh
 * @date 2023/5/22 13:40
 */
@Slf4j
@Service
public class MemberServiceImpl implements MemberService {


    @Resource
    private MemberPackageRepository memberPackageRepository;

    @Resource
    private MemberPackageBenefitRelRepository memberPackageBenefitRelRepository;


    @Resource
    private OrderOrderRepository orderOrderRepository;


    /***
     * 开通会员
     * @param command
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public MemberSaveVO saveMember(MemberJoinCommand command) {
        log.info("开通会员,合作方订单号:{},入参为:{}", command.getPartnerOrderNumber(), JSON.toJSONString(command));

        // 获取登录用户
        MemberUserDTO memberUser = LoginUtil.loginUser();

        // 校验层(校验用户登录与会员权益套餐包)
        MemberSpecification memberSpecification = new MemberSpecification(memberPackageRepository, memberPackageBenefitRelRepository);
        memberSpecification.isUserLogin(memberUser);
        memberSpecification.isMemberPackage(Long.valueOf(memberUser.getTenantId()), command.getProductCode());


        // 领域层
        DomainMemberService domainMemberService = new DomainMemberService();
        MemberSaveVO memberSaveVO = domainMemberService.saveMember(command);

        return memberSaveVO;
    }


    /***
     * 注销会员
     * @param command
     * @return
     */
    @Override
    public MemberRefundVO refundMember(MemberRefundCommand command) {
        // 获取登录用户
        MemberUserDTO memberUser = LoginUtil.loginUser();

        // 校验用户登录与参数
        MemberSpecification memberSpecification = new MemberSpecification(orderOrderRepository);
        memberSpecification.isUserLogin(memberUser);
        memberSpecification.isMemberRefund(command.getOrderNumber(), command.getPartnerOrderNumber());

        // 领域层
        DomainMemberService domainMemberService = new DomainMemberService();
        MemberRefundVO memberRefundVO = domainMemberService.refundMember(command);

        return memberRefundVO;
    }

}
