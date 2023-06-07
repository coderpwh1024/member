package com.coderpwh.member.domain.specification;

import com.coderpwh.member.common.ddd.AbstractSpecification;
import com.coderpwh.member.common.util.enums.DddEnum;
import com.coderpwh.member.common.util.enums.SysReturnCode;
import com.coderpwh.member.common.util.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * @author coderpwh
 * @date 2023/6/7 16:38
 */
@Slf4j
public class OrderInfoSpecification extends AbstractSpecification<Integer> {


    @Override
    public boolean isSatisfiedBy(Integer integer) {
        return false;
    }


    /***
     * 参数校验
     * @param orderNumber
     * @param partnerOrderNumber
     * @return
     */
    public boolean isOrderInfoSpecification(String orderNumber, String partnerOrderNumber) {
        if (StringUtils.isBlank(orderNumber) && StringUtils.isBlank(partnerOrderNumber)) {
            log.error("订单号与合作方订单号不能同时为空");
            throw new BusinessException(SysReturnCode.CarGo, DddEnum.APPLICATIN, "订单号与合作方订单号不能同时为空");
        } else {
            return true;
        }
    }


}
