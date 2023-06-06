package com.coderpwh.member.domain.specification;

import com.coderpwh.member.common.ddd.AbstractSpecification;
import com.coderpwh.member.common.util.enums.DddEnum;
import com.coderpwh.member.common.util.enums.SysReturnCode;
import com.coderpwh.member.common.util.exception.BusinessException;
import com.coderpwh.member.domain.model.MemberTenant;
import com.coderpwh.member.domain.model.MemberTenantRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * @author coderpwh
 * @date 2023/6/6 11:30
 */
@Slf4j
public class MemberPackageDetailSpecification extends AbstractSpecification<Integer> {


    private MemberTenantRepository memberTenantRepository;


    public MemberPackageDetailSpecification(MemberTenantRepository memberTenantRepository) {
        this.memberTenantRepository = memberTenantRepository;
    }


    @Override
    public boolean isSatisfiedBy(Integer integer) {
        return false;
    }


    public boolean isMemberPackageDetail(String agentNumber) {
        MemberTenant memberTenant = memberTenantRepository.selectByAgentNumber(agentNumber);
        if (memberTenant != null) {
            return true;
        } else {
            log.error("当前租户号不存在,agentNumber为:{}", agentNumber);
            throw new BusinessException(SysReturnCode.CarGo, DddEnum.APPLICATIN, "当前租户号不存在");
        }
    }


}
