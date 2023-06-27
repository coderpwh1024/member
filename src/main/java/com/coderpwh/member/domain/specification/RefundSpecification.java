package com.coderpwh.member.domain.specification;

import com.coderpwh.member.common.ddd.AbstractSpecification;

/**
 * 退款校验
 * @author coderpwh
 * @date 2023/6/27 17:11
 */
public class RefundSpecification extends AbstractSpecification<Integer> {

    @Override
    public boolean isSatisfiedBy(Integer integer) {
        return false;
    }

}
