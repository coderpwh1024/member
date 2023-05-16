package com.coderpwh.member.domain.specification;

import com.coderpwh.member.common.ddd.AbstractSpecification;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author coderpwh
 * @date 2023/5/16 11:02
 */
@AllArgsConstructor
@NoArgsConstructor
public class UserSpecification extends AbstractSpecification<Integer> {


    @Override
    public boolean isSatisfiedBy(Integer integer) {
        return false;
    }


    public boolean isAgentNumber(String agentNumber) {
        return false;
    }

}
