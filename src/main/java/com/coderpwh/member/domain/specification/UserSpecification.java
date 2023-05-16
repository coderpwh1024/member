package com.coderpwh.member.domain.specification;

import com.coderpwh.member.common.ddd.AbstractSpecification;
import com.coderpwh.member.common.util.enums.DddEnum;
import com.coderpwh.member.common.util.enums.SysReturnCode;
import com.coderpwh.member.common.util.exception.BusinessException;
import com.coderpwh.member.domain.model.MemberTenant;
import com.coderpwh.member.domain.model.MemberTenantRepository;
import com.coderpwh.member.domain.model.MemberUserRepository;
import com.coderpwh.member.infrastructure.persistence.entity.MemberTenantDO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author coderpwh
 * @date 2023/5/16 11:02
 */
@Slf4j
@AllArgsConstructor
public class UserSpecification extends AbstractSpecification<Integer> {



    private MemberTenantRepository memberTenantRepository;


    @Override
    public boolean isSatisfiedBy(Integer integer) {
        return false;
    }


    /***
     * 校验租户是否合法
     * @param agentNumber
     * @return
     */
    public boolean isAgentNumber(String agentNumber) {
        MemberTenant memberTenant = memberTenantRepository.selectByAgentNumber(agentNumber);
        if (Objects.nonNull(memberTenant)) {
            return true;
        } else {
            throw new BusinessException(SysReturnCode.CarGo, DddEnum.APPLICATIN, "当前租户不存在");
        }
    }

}
