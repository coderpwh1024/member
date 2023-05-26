package com.coderpwh.member.domain.service;

import com.coderpwh.member.application.command.MemberJoinCommand;
import com.coderpwh.member.application.vo.MemberSaveVO;
import com.coderpwh.member.domain.enums.CashierTypeEnum;
import com.coderpwh.member.domain.enums.OrderTypeEnum;
import com.coderpwh.member.domain.model.*;
import com.coderpwh.member.infrastructure.persistence.entity.MemberPaymentRouterRuleDO;
import com.coderpwh.member.infrastructure.persistence.entity.MemberSettlementRuleDO;

import java.util.List;
import java.util.Objects;

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

        MemberSettlementRule settlementRule = new MemberSettlementRule();

        // 订单类型
        Integer orderType = OrderTypeEnum.getOrderType(Integer.valueOf(type)).val();

        List<MemberSettlementRule> list = memberSettlementRuleRepository.selectByPackageIdAndCashierType(tenantId, packageId, orderType, cashierType);

        if (list == null || list.size() <= 0) {
            List<MemberSettlementRule> ruleList = memberSettlementRuleRepository.selectByPackageIdAndCashierType(tenantId, packageId, orderType, String.valueOf(CashierTypeEnum.CASHIER_NO_PAY.getType()));
            if (ruleList != null && ruleList.size() > 0) {
                settlementRule = ruleList.get(0);
            }
        } else {
            settlementRule = list.get(0);
        }

        if (Objects.isNull(settlementRule)) {
            List<MemberSettlementRule> ruleList = memberSettlementRuleRepository.selectByOrderTypeAndPackageId(tenantId, OrderTypeEnum.ZERO.val(), packageId);
            if (ruleList != null && ruleList.size() > 0) {
                settlementRule = ruleList.get(0);
            }
        }

        if (settlementRule != null && settlementRule.getRule() != null) {
            Float ratio = settlementRule.getRatio();
            Integer price = 0;



        }


    }


}
