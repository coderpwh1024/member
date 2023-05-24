package com.coderpwh.member.domain.service;

import com.coderpwh.member.application.command.MemberJoinCommand;
import com.coderpwh.member.application.vo.MemberSaveVO;
import com.coderpwh.member.domain.enums.OrderTypeEnum;
import com.coderpwh.member.domain.model.*;
import com.coderpwh.member.infrastructure.persistence.entity.MemberPaymentRouterRuleDO;
import com.coderpwh.member.infrastructure.persistence.entity.MemberSettlementRuleDO;

import java.util.List;

/**
 * 会员领域层
 *
 * @author coderpwh
 * @date 2023/5/22 16:08
 */
public class DomainMemberService {


    private MemberPackageRepository memberPackageRepository;


    private MemberTenantRepository memberTenantRepository;


    private MemberPaymentRouterRuleRepository memberPaymentRouterRuleRepository;


    private MemberSettlementRuleRepository memberSettlementRuleRepository;


    public DomainMemberService() {

    }


    /***
     * 开通会员
     * @param command
     * @return
     */
    public MemberSaveVO saveMember(MemberJoinCommand command) {

        MemberTenant memberTenant = memberTenantRepository.selectByAgentNumber(command.getAgentNumber());


        MemberPackage memberPackage = memberPackageRepository.selectByAgentNumberAndCode(command.getAgentNumber(), command.getProductType());


        return null;

    }


    /***
     * 计算分润
     * @param tenantId
     * @param cashierType
     * @param type
     */
    public void revenue(Long tenantId, String cashierType, Integer type, Long packageId) {

        // 订单类型
        Integer orderType = OrderTypeEnum.getOrderType(Integer.valueOf(type)).val();

        List<MemberSettlementRule> list = memberSettlementRuleRepository.selectByPackageIdAndCashierType(tenantId, packageId, orderType, cashierType);
    }


}
