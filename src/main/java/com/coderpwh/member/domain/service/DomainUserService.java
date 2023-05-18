package com.coderpwh.member.domain.service;

import com.coderpwh.member.application.command.MemberInfoQuery;
import com.coderpwh.member.application.command.UserLoginCommand;
import com.coderpwh.member.application.vo.MemberInfoVO;
import com.coderpwh.member.application.vo.UserLoginVO;
import com.coderpwh.member.domain.model.*;
import com.coderpwh.member.domain.util.DateUtils;
import com.coderpwh.member.domain.util.JwtUtils;
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


    private String appSecret;
    private MemberUserRepository memberUserRepository;

    private MemberTenantRepository memberTenantRepository;

    private MemberCardRepository memberCardRepository;


    public DomainUserService() {

    }


    public DomainUserService(MemberUserRepository userRepository, MemberTenantRepository tenantRepository, MemberCardRepository cardRepository, String appSecret) {
        this.memberUserRepository = userRepository;
        this.memberTenantRepository = tenantRepository;
        this.memberCardRepository = cardRepository;
        this.appSecret = appSecret;
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
                BeanUtils.copyProperties(userLogin, userLoginVO);
                userLoginVO.setEffectiveTime(DateUtils.getStringByDate(userLogin.getEffectiveTime()));
                userLoginVO.setExpirationTime(DateUtils.getStringByDate(userLogin.getExpirationTime()));
            }
            userLoginVO.setUserId(memberUser.getId());
            userLoginVO.setIsMember(memberUser.getIsMember());
        }
        String token = JwtUtils.getJwtToken(memberUser.getId(), appSecret);
        userLoginVO.setToken(token);
        return userLoginVO;
    }


    /***
     *  查询用户会员信息
     * @param query
     * @return
     */
    public MemberInfoVO getMemberInfo(MemberInfoQuery query) {
        MemberInfoVO memberInfo = new MemberInfoVO();
        MemberUser memberUser = memberUserRepository.selectByUniqueIdAndAgentNumber(query.getUniqueId(), query.getAgentNumber());
        if (!memberUser.getIsMember()) {
            return memberInfo;
        }
        UserLogin userLogin = memberCardRepository.selectByUserId(memberUser.getId());
        BeanUtils.copyProperties(memberInfo, userLogin);
        memberInfo.setUserId(memberUser.getId());
        memberInfo.setIsMember(memberUser.getIsMember());
        return memberInfo;
    }

}
