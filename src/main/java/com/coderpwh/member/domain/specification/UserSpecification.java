package com.coderpwh.member.domain.specification;

import com.coderpwh.member.common.ddd.AbstractSpecification;
import com.coderpwh.member.common.util.enums.DddEnum;
import com.coderpwh.member.common.util.enums.SysReturnCode;
import com.coderpwh.member.common.util.exception.BusinessException;
import com.coderpwh.member.domain.model.MemberTenant;
import com.coderpwh.member.domain.model.MemberTenantRepository;
import com.coderpwh.member.domain.model.MemberUser;
import com.coderpwh.member.domain.model.MemberUserRepository;
import com.coderpwh.member.infrastructure.persistence.entity.MemberTenantDO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author coderpwh
 * @date 2023/5/16 11:02
 */
@Slf4j
public class UserSpecification extends AbstractSpecification<Integer> {


    private MemberTenantRepository memberTenantRepository;


    private MemberUserRepository memberUserRepository;


    public UserSpecification(MemberTenantRepository repository) {
        this.memberTenantRepository = repository;
    }


    public UserSpecification(MemberTenantRepository tenantRepository, MemberUserRepository userRepository) {
        this.memberUserRepository = userRepository;
        this.memberTenantRepository = tenantRepository;
    }


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


    /***
     *  校验租户跟uniqueId
     * @param agentNumber
     * @param uniqueId
     */
    public boolean isAgentNumberUniqueId(String agentNumber, String uniqueId) {

        MemberUser memberUser = memberUserRepository.selectByUniqueIdAndAgentNumber(uniqueId, agentNumber);

        if (Objects.nonNull(memberUser)) {
            return true;
        } else {
            log.error("当前用户不存在,合作方代理号:{},外部用户id为:{}", agentNumber, uniqueId);
            throw new BusinessException(SysReturnCode.CarGo, DddEnum.APPLICATIN, "当前用户不存在");
        }

    }
}
