package com.coderpwh.member.domain.specification;

import com.coderpwh.member.application.command.MemberRefundCommand;
import com.coderpwh.member.application.dto.MemberUserDTO;
import com.coderpwh.member.application.dto.TenantPropertyDTO;
import com.coderpwh.member.common.ddd.AbstractSpecification;
import com.coderpwh.member.common.util.enums.DddEnum;
import com.coderpwh.member.common.util.enums.SysReturnCode;
import com.coderpwh.member.common.util.exception.BusinessException;
import com.coderpwh.member.domain.enums.TenantPropertyKeyConstant;
import com.coderpwh.member.domain.model.MemberCardHistory;
import com.coderpwh.member.domain.model.MemberCardHistoryRepository;
import com.coderpwh.member.domain.model.MemberPackageRepository;
import com.coderpwh.member.domain.model.MemberTenantExtraInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * 退款校验
 *
 * @author coderpwh
 * @date 2023/6/27 17:11
 */
@Slf4j
public class RefundSpecification extends AbstractSpecification<Integer> {


    private MemberCardHistoryRepository memberCardHistoryRepository;


    private MemberTenantExtraInfoRepository memberTenantExtraInfoRepository;


    @Override
    public boolean isSatisfiedBy(Integer integer) {
        return false;
    }


    public boolean isValidRefund(MemberRefundCommand command, MemberUserDTO memberUser) {
        if (ObjectUtils.isEmpty(memberUser)) {
            log.error("当前用户尚未登录");
            throw new BusinessException(SysReturnCode.CarGo, DddEnum.APPLICATIN, "当前用户尚未登录");
        }

        MemberCardHistory memberCardHistory = memberCardHistoryRepository.selectByOrderNumber(command.getOrderNumber());

        // 过期退款
        boolean expireRefund = isExpireRefund(memberUser);

        return true;
    }


    /***
     * 过期退款校验
     * @param memberUser
     * @return
     */
    public boolean isExpireRefund(MemberUserDTO memberUser) {

        Long tenantId = Long.valueOf(memberUser.getTenantId());
        List<TenantPropertyDTO> list = memberTenantExtraInfoRepository.selectByTenantId(tenantId, TenantPropertyKeyConstant.OVERDUE_REFUND__KEY);
        if (ObjectUtils.isEmpty(list)) {
            log.error("当前租户:{},尚未配置过期退款规则", tenantId);
            throw new BusinessException(SysReturnCode.CarGo, DddEnum.APPLICATIN, "当前租户尚未配置过期退款规则");
        }
        String overdueFlag = list.get(0).getPropertyValue();
        if (overdueFlag.equals("false")) {
            log.error("当前租户:{},不允许过期退款", tenantId);
            throw new BusinessException(SysReturnCode.CarGo, DddEnum.APPLICATIN, "当前租户不允许过期退款");
        }
        return true;
    }


    /***
     * 倒序退款
     * @return
     */
    public boolean isOutOfOrderRefund() {
        return true;
    }


}
