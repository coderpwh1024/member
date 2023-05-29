package com.coderpwh.member.domain.service;

import com.coderpwh.member.application.command.MemberJoinCommand;
import com.coderpwh.member.application.command.MemberRefundCommand;
import com.coderpwh.member.application.dto.MemberSharePriceDTO;
import com.coderpwh.member.application.vo.MemberRefundVO;
import com.coderpwh.member.application.vo.MemberSaveVO;
import com.coderpwh.member.domain.enums.CashierTypeEnum;
import com.coderpwh.member.domain.enums.MemberSettlementRuleEnum;
import com.coderpwh.member.domain.enums.OrderTypeEnum;
import com.coderpwh.member.domain.model.*;
import com.coderpwh.member.infrastructure.persistence.entity.MemberPaymentDO;
import com.coderpwh.member.infrastructure.persistence.entity.MemberPaymentRouterRuleDO;
import com.coderpwh.member.infrastructure.persistence.entity.MemberSettlementRuleDO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * 会员领域层
 *
 * @author coderpwh
 * @date 2023/5/22 16:08
 */
@Slf4j
public class DomainMemberService {


    private MemberPackageRepository memberPackageRepository;


    private MemberTenantRepository memberTenantRepository;


    private MemberPaymentRouterRuleRepository memberPaymentRouterRuleRepository;


    private MemberSettlementRuleRepository memberSettlementRuleRepository;


    private MemberPaymentRepository memberPaymentRepository;


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
    public MemberSharePriceDTO doRevenue(Long tenantId, String cashierType, Integer type, Long packageId, String partnerPrice) {
        MemberSharePriceDTO memberSharePrice = new MemberSharePriceDTO();

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

            if (settlementRule.getRule() == MemberSettlementRuleEnum.AMOUNT_RULE.val()) {
                price = Objects.isNull(settlementRule.getPrice()) ? 0 : settlementRule.getPrice();
            } else if (settlementRule.getRule() == MemberSettlementRuleEnum.ORDER_AMOUNT_RULE.val()) {
                BigDecimal bigDecimalPrice = new BigDecimal(partnerPrice);
                price = StringUtils.isBlank(partnerPrice) ? 0 : bigDecimalPrice.intValue();
            }

            String revenue = new BigDecimal(price).multiply(new BigDecimal(ratio)).setScale(0, BigDecimal.ROUND_HALF_UP).toString();
            memberSharePrice.setRevenue(revenue);
            memberSharePrice.setShareRatio(settlementRule.getShareRatio());
            memberSharePrice.setIsShareBenefit(settlementRule.getIsShareBenefit());
            memberSharePrice.setAccountType(settlementRule.getAccountType());
            memberSharePrice.setBenefitAccount(settlementRule.getAccount());
            return memberSharePrice;
        } else {
            log.error("不存在对应的分润规则,租户id为:{}", tenantId);
            return null;
        }
    }


    /***
     *  设置支付方式及其路由
     */
    public void doPayPayment(Long tenantId, String payType, String category) {

        String env = "";

        MemberPayment memberPayment = memberPaymentRepository.selectByPayType(tenantId, payType, env, category);
        if (Objects.isNull(memberPayment)) {
        }


    }


    /***
     * 会员注销
     * @param command
     * @return
     */
    public MemberRefundVO refundMember(MemberRefundCommand command) {

        return null;
    }

}
