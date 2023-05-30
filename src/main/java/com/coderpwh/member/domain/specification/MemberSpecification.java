package com.coderpwh.member.domain.specification;

import com.coderpwh.member.application.dto.MemberUserDTO;
import com.coderpwh.member.common.ddd.AbstractSpecification;
import com.coderpwh.member.common.util.enums.DddEnum;
import com.coderpwh.member.common.util.enums.SysReturnCode;
import com.coderpwh.member.common.util.exception.BusinessException;
import com.coderpwh.member.domain.model.*;
import com.coderpwh.member.infrastructure.persistence.entity.MemberCardDO;
import com.coderpwh.member.infrastructure.persistence.entity.MemberCardHistoryDO;
import com.coderpwh.member.infrastructure.persistence.entity.MemberPaymentRouterRuleDO;
import com.coderpwh.member.infrastructure.persistence.entity.OrderOrderDO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Objects;

/**
 * 会员校验
 *
 * @author coderpwh
 * @date 2023/5/22 16:11
 */
@Slf4j
public class MemberSpecification extends AbstractSpecification<Integer> {


    private MemberPackageRepository memberPackageRepository;


    private MemberPackageBenefitRelRepository memberPackageBenefitRelRepository;

    private MemberPaymentRepository memberPaymentRepository;

    private MemberPaymentRouterRuleRepository memberPaymentRouterRuleRepository;


    private OrderOrderRepository orderOrderRepository;


    private MemberCardRepository memberCardRepository;


    public MemberSpecification(MemberPackageRepository memberPackageRepository, MemberPackageBenefitRelRepository memberPackageBenefitRelRepository) {
        this.memberPackageRepository = memberPackageRepository;
        this.memberPackageBenefitRelRepository = memberPackageBenefitRelRepository;
    }


    public MemberSpecification(OrderOrderRepository orderOrderRepository) {
        this.orderOrderRepository = orderOrderRepository;
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


    /**
     * 校验权益包是否存在
     *
     * @param tenantId
     * @param code
     * @return
     */
    public boolean isMemberPackage(Long tenantId, String code) {
        MemberPackage memberPackage = memberPackageRepository.selectByPackageCode(String.valueOf(tenantId), code);
        if (Objects.isNull(memberPackage)) {
            log.error("当前租户id:{},编码code:{},会员套餐包不存在", tenantId, code);
            throw new BusinessException(SysReturnCode.CarGo, DddEnum.APPLICATIN, "当前租户的会员套餐包不存在");
        } else {
            return isMemberPackageBenefitRel(tenantId, memberPackage.getId());
        }
    }

    public boolean isMemberPackageBenefitRel(Long tenantId, Long packageId) {
        List<MemberPackageBenefitRel> list = memberPackageBenefitRelRepository.selectByTenantIdAndPackageId(tenantId, packageId);
        if (list != null && list.size() > 0) {
            return true;
        } else {
            log.error("当前租户id:{},套餐包id:{},开通会员套餐权益配置为空", tenantId, packageId);
            throw new BusinessException(SysReturnCode.CarGo, DddEnum.APPLICATIN, "开通会员套餐权益配置为空");
        }

    }

    public boolean isPaymentAndPayRule(Long tenantId, String payType, String category, String env) {
        if (StringUtils.isBlank(env)) {
            env = "default";
        }

        MemberPayment memberPayment = memberPaymentRepository.selectByPayType(tenantId, payType, env, category);
        if (Objects.isNull(memberPayment)) {
            log.error("尚未配置支付方式,租户id:{},支付类型:{},订单类型:{}", tenantId, payType, category);
            throw new BusinessException(SysReturnCode.CarGo, DddEnum.APPLICATIN, "尚未配置支付方式,请联系管理员");
        } else {
            if (memberPayment.getIsRouter()) {
                MemberPaymentRouterRule memberPaymentRouterRule = memberPaymentRouterRuleRepository.selectByPaymentId(memberPayment.getId());
                if (Objects.isNull(memberPaymentRouterRule)) {
                    log.error("尚未配置支付路由,租户id:{},支付类型:{},订单类型:{}", tenantId, payType, category);
                    throw new BusinessException(SysReturnCode.CarGo, DddEnum.APPLICATIN, "尚未配置支付路由,请联系管理员");
                }
            } else {
                return true;
            }
            return true;
        }
    }







}
