package com.coderpwh.member.domain.service;

import com.coderpwh.member.application.command.UserLoginCommand;
import com.coderpwh.member.application.vo.UserLoginVO;
import com.coderpwh.member.domain.model.MemberTenant;
import com.coderpwh.member.domain.model.MemberTenantRepository;
import com.coderpwh.member.domain.model.MemberUser;
import com.coderpwh.member.domain.model.MemberUserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * 用户领域层
 *
 * @author coderpwh
 * @date 2023/5/16 10:55
 */

@Slf4j
@AllArgsConstructor
public class DomainUserService {


    private MemberUserRepository memberUserRepository;


    private MemberTenantRepository memberTenantRepository;


    public DomainUserService() {

    }


    /***
     *  用户登录领域层
     * @param command
     * @return
     */
    public UserLoginVO login(UserLoginCommand command) {

        MemberTenant memberTenant = memberTenantRepository.selectByAgentNumber(command.getAgentNumber());

        MemberUser memberUser = memberUserRepository.selectByUniqueIdAndTenantId(command.getUniqueId(), memberTenant.getId());
        if (Objects.isNull(memberUser)) {
            memberUser.setIsMember(false);
            memberUser.setUniqueId(command.getUniqueId());
            memberUser.setTenantId(String.valueOf(memberTenant.getId()));
            memberUserRepository.save(memberUser);
        } else {

        }
        return null;
    }


}
