package com.coderpwh.member.domain.specification;

import com.coderpwh.member.application.dto.MemberUserDTO;
import com.coderpwh.member.common.ddd.AbstractSpecification;
import com.coderpwh.member.common.util.enums.DddEnum;
import com.coderpwh.member.common.util.enums.SysReturnCode;
import com.coderpwh.member.common.util.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * @author coderpwh
 * @date 2023/6/7 11:20
 */
@Slf4j
public class MemberPackageOrderSpecifucation extends AbstractSpecification<Integer> {


    @Override
    public boolean isSatisfiedBy(Integer integer) {
        return false;
    }


    public boolean isUserLogin(MemberUserDTO memberUser) {
        if (Objects.isNull(memberUser)) {
            log.error("当前用户尚未登录");
            throw new BusinessException(SysReturnCode.CarGo, DddEnum.APPLICATIN, "当前用户尚未登录");
        } else {
            return true;
        }
    }

    public boolean isOrderNumberAndPartnerNumber(String orderNumber, String partnerOrderNumber) {
        if (StringUtils.isBlank(orderNumber) && StringUtils.isBlank(partnerOrderNumber)) {
            log.error("订单号与合作方订单号同时为空");
            throw new BusinessException(SysReturnCode.CarGo, DddEnum.APPLICATIN, "订单号与合作方订单号同时为空");
        } else {
            return true;
        }
    }


}
