package com.coderpwh.member.domain.service;

import com.coderpwh.member.application.command.UserLoginCommand;
import com.coderpwh.member.application.vo.UserLoginVO;
import com.coderpwh.member.domain.model.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

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

    private MemberCardRepository memberCardRepository;


    public DomainUserService() {

    }


    /***
     *  用户登录领域层
     * @param command
     * @return
     */
    public UserLoginVO login(UserLoginCommand command) {
        UserLoginVO userLoginVO = new UserLoginVO();

        MemberTenant memberTenant = memberTenantRepository.selectByAgentNumber(command.getAgentNumber());

        MemberUser memberUser = memberUserRepository.selectByUniqueIdAndTenantId(command.getUniqueId(), memberTenant.getId());
        if (Objects.isNull(memberUser)) {
            memberUser.setIsMember(false);
            memberUser.setUniqueId(command.getUniqueId());
            memberUser.setTenantId(String.valueOf(memberTenant.getId()));
            memberUserRepository.save(memberUser);
        } else {
            if (memberUser.getIsMember()) {
                UserLogin userLogin = memberCardRepository.selectByUserId(memberUser.getId());
                BeanUtils.copyProperties(userLoginVO, userLogin);
            }
            userLoginVO.setUserId(memberUser.getId());
            userLoginVO.setIsMember(memberUser.getIsMember());
        }
        return userLoginVO;
    }


}
