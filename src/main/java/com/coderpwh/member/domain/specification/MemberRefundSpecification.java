package com.coderpwh.member.domain.specification;

import com.coderpwh.member.application.dto.MemberUserDTO;
import com.coderpwh.member.application.dto.TenantPropertyDTO;
import com.coderpwh.member.common.ddd.AbstractSpecification;
import com.coderpwh.member.common.util.enums.DddEnum;
import com.coderpwh.member.common.util.enums.SysReturnCode;
import com.coderpwh.member.common.util.exception.BusinessException;
import com.coderpwh.member.domain.enums.TenantPropertyKeyConstant;
import com.coderpwh.member.domain.model.*;
import com.coderpwh.member.domain.util.DateUtils;
import com.coderpwh.member.infrastructure.persistence.entity.MemberTenantExtraInfoDO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Objects;

/**
 * @author coderpwh
 * @date 2023/5/30 11:19
 */
@Slf4j
public class MemberRefundSpecification extends AbstractSpecification<Integer> {


    private OrderOrderRepository orderOrderRepository;


    private MemberCardRepository memberCardRepository;


    private MemberTenantRepository memberTenantRepository;


    private MemberTenantExtraInfoRepository memberTenantExtraInfoRepository;


    public MemberRefundSpecification(OrderOrderRepository orderOrderRepository, MemberCardRepository memberCardRepository) {
        this.orderOrderRepository = orderOrderRepository;
        this.memberCardRepository = memberCardRepository;
    }


    @Override
    public boolean isSatisfiedBy(Integer integer) {
        return false;
    }


    /***
     * 校验用户是否登录
     * @param memberUser
     * @return
     */
    public boolean isUserLogin(MemberUserDTO memberUser) {
        if (Objects.isNull(memberUser)) {
            log.error("当前用户尚未登录");
            throw new BusinessException(SysReturnCode.CarGo, DddEnum.APPLICATIN, "当前用户尚未登录");
        } else {
            return true;
        }
    }


    /***
     * 会员退款校验
     * @param orderNumber
     * @param partnerOrderNumber
     * @return
     */
    public boolean isMemberRefund(String orderNumber, String partnerOrderNumber) {

        if (StringUtils.isBlank(orderNumber) && StringUtils.isBlank(partnerOrderNumber)) {
            throw new BusinessException(SysReturnCode.CarGo, DddEnum.APPLICATIN, "订单号与合作方订单号都为空");
        }

        if (StringUtils.isNotBlank(partnerOrderNumber)) {
            OrderOrder order = orderOrderRepository.selectByPartnerOrderNumber(partnerOrderNumber);
            if (Objects.isNull(order)) {
                log.error("当前合作方订单号不存在,尚未查询到订单,合作方订单号为:{}", partnerOrderNumber);
                throw new BusinessException(SysReturnCode.CarGo, DddEnum.APPLICATIN, "当前合作方订单号不存在,尚未查询到订单");
            } else {
                return true;
            }
        }

        if (StringUtils.isNotBlank(orderNumber)) {
            OrderOrder order = orderOrderRepository.selectByOrderNumber(orderNumber);
            if (Objects.isNull(order)) {
                log.error("当前订单号不存在,尚未查询到订单,订单号为:{}", partnerOrderNumber);
                throw new BusinessException(SysReturnCode.CarGo, DddEnum.APPLICATIN, "当前订单号不存在,尚未查询到订单");
            } else {
                return true;
            }
        }

        return true;
    }


    /***
     * 会员退款校验过期规则退款
     * @return
     */
    public boolean isMemberRefundByExpirationTime(String orderNumber, String agentNumber) {
        MemberTenant memberTenant = memberTenantRepository.selectByAgentNumber(agentNumber);
        if (Objects.isNull(memberTenant)) {
            log.error("会员退款校验过期退款时租户信息为空,租户代理号为:{},订单号为:{}", agentNumber, orderNumber);
            throw new BusinessException(SysReturnCode.CarGo, DddEnum.APPLICATIN, "代理号不存在");
        }

        MemberCard memberCard = memberCardRepository.selectByOrderNumber(orderNumber);

        Boolean expirationTimeFlag = DateUtils.checkExpirationTime(memberCard.getExpirationTime());


        List<TenantPropertyDTO> tenantExtraInfoList = memberTenantExtraInfoRepository.selectByTenantId(memberTenant.getId(), TenantPropertyKeyConstant.OVERDUE_REFUND__KEY);


        // TODO   还未校验完
        return true;

    }


}
