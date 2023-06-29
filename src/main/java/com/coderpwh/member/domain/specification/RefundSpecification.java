package com.coderpwh.member.domain.specification;

import com.coderpwh.member.application.command.MemberRefundCommand;
import com.coderpwh.member.application.dto.MemberUserDTO;
import com.coderpwh.member.common.ddd.AbstractSpecification;
import com.coderpwh.member.common.util.enums.DddEnum;
import com.coderpwh.member.common.util.enums.SysReturnCode;
import com.coderpwh.member.common.util.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ObjectUtils;

/**
 * 退款校验
 *
 * @author coderpwh
 * @date 2023/6/27 17:11
 */
@Slf4j
public class RefundSpecification extends AbstractSpecification<Integer> {

    @Override
    public boolean isSatisfiedBy(Integer integer) {
        return false;
    }


    public boolean isValidRefund(MemberRefundCommand command, MemberUserDTO memberUser) {
        if (StringUtils.isBlank(command.getPartnerOrderNumber()) && StringUtils.isNotBlank(command.getPartnerOrderNumber())) {
            log.error("订单号与合作方订单号不能同时为空");
            throw new BusinessException(SysReturnCode.CarGo, DddEnum.APPLICATIN, "订单号与合作方订单号不能同时为空");
        }

        if (ObjectUtils.isEmpty(memberUser)) {
            log.error("当前用户尚未登录");
            throw new BusinessException(SysReturnCode.CarGo, DddEnum.APPLICATIN, "当前用户尚未登录");
        }
        return true;
    }


}
