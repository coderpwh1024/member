package com.coderpwh.member.application.service.impl;

import com.alibaba.fastjson2.JSON;
import com.coderpwh.member.application.assembler.domain.BenefitDTOAssembler;
import com.coderpwh.member.application.assembler.domain.MemberPackageDTOAssembler;
import com.coderpwh.member.application.assembler.domain.MemberPackageOrderDTOAssembler;
import com.coderpwh.member.application.assembler.vo.MemberPackageDetailVOAssembler;
import com.coderpwh.member.application.assembler.vo.MemberPackageOrderVOAssembler;
import com.coderpwh.member.application.command.MemberJoinCommand;
import com.coderpwh.member.application.command.MemberPackageDetailQuery;
import com.coderpwh.member.application.command.MemberPackageOrderQuery;
import com.coderpwh.member.application.command.MemberRefundCommand;
import com.coderpwh.member.application.dto.MemberUserDTO;
import com.coderpwh.member.application.service.MemberService;
import com.coderpwh.member.application.vo.MemberPackageDetailVO;
import com.coderpwh.member.application.vo.MemberPackageOrderVO;
import com.coderpwh.member.application.vo.MemberRefundVO;
import com.coderpwh.member.application.vo.MemberSaveVO;
import com.coderpwh.member.domain.model.*;
import com.coderpwh.member.domain.service.DomainMemberService;
import com.coderpwh.member.domain.specification.MemberPackageDetailSpecification;
import com.coderpwh.member.domain.specification.MemberPackageOrderSpecifucation;
import com.coderpwh.member.domain.specification.MemberRefundSpecification;
import com.coderpwh.member.domain.specification.MemberSpecification;
import com.coderpwh.member.domain.util.LoginUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author coderpwh
 * @date 2023/5/22 13:40
 */
@Slf4j
@Service
public class MemberServiceImpl implements MemberService {


    @Resource
    private MemberPackageOrderVOAssembler memberPackageOrderVOAssembler;

    @Resource
    private MemberPackageOrderDTOAssembler memberPackageOrderDTOAssembler;
    @Resource
    private BenefitDTOAssembler benefitDTOAssembler;

    @Resource
    private MemberPackageDetailVOAssembler memberPackageDetailVOAssembler;

    @Resource
    private MemberPackageDTOAssembler memberPackageDTOAssembler;

    @Resource
    private MemberPackageRepository memberPackageRepository;

    @Resource
    private MemberPackageBenefitRelRepository memberPackageBenefitRelRepository;

    @Resource
    private OrderOrderRepository orderOrderRepository;

    @Resource
    private MemberCardRepository memberCardRepository;


    @Resource
    private MemberTenantRepository memberTenantRepository;


    @Resource
    private MemberCardHistoryRepository memberCardHistoryRepository;


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
     * 查询会员权益包
     * @param query
     * @return
     */
    @Override
    public List<MemberPackageDetailVO> getPackageDetail(MemberPackageDetailQuery query) {
        log.info("查询会员权益包入参为:{}", JSON.toJSONString(query));

        // 数据校验
        MemberPackageDetailSpecification specification = new MemberPackageDetailSpecification(memberTenantRepository);
        specification.isMemberPackageDetail(query.getAgentNumber());

        //  领域层
        DomainMemberService domainMemberService = new DomainMemberService(memberTenantRepository, memberPackageRepository, memberPackageBenefitRelRepository, memberPackageDTOAssembler, memberPackageDetailVOAssembler, benefitDTOAssembler);
        List<MemberPackageDetailVO> list = domainMemberService.getPackageDetail(query);

        return list;
    }


    /***
     * 查询会员权益包订单
     * @param query
     * @return
     */
    @Override
    public MemberPackageOrderVO getParckageOrder(MemberPackageOrderQuery query) {
        log.info("获取会员套餐订单入参为:{}", JSON.toJSONString(query));

        // 获取登录用户
        MemberUserDTO memberUser = LoginUtil.loginUser();

        // 校验
        MemberPackageOrderSpecifucation specifucation = new MemberPackageOrderSpecifucation();
        specifucation.isUserLogin(memberUser);
        specifucation.isOrderNumberAndPartnerNumber(query.getOrderNumber(), query.getPartnerOrderNumber());

        // 领域层
        DomainMemberService domainMemberService = new DomainMemberService(memberCardHistoryRepository, memberPackageOrderVOAssembler, memberPackageOrderDTOAssembler);
        MemberPackageOrderVO memberPackageOrderVO = domainMemberService.getParckageOrder(query);
        return memberPackageOrderVO;
    }


}
