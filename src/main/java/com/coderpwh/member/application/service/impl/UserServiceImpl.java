package com.coderpwh.member.application.service.impl;

import com.coderpwh.member.application.command.MemberInfoQuery;
import com.coderpwh.member.application.command.UserLoginCommand;
import com.coderpwh.member.application.service.UserService;
import com.coderpwh.member.application.vo.MemberInfoVO;
import com.coderpwh.member.application.vo.UserLoginVO;
import com.coderpwh.member.domain.model.MemberTenantRepository;
import com.coderpwh.member.domain.model.MemberUserRepository;
import com.coderpwh.member.domain.service.DomainUserService;
import com.coderpwh.member.domain.specification.UserSpecification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户业务实现层
 *
 * @author coderpwh
 * @date 2023/5/16 10:26
 */
@Service
public class UserServiceImpl implements UserService {


    @Resource
    private MemberTenantRepository memberTenantRepository;

    @Resource
    private MemberUserRepository memberUserRepository;


    /***
     * 用户登录
     * @param command
     * @return
     */
    @Override
    public UserLoginVO login(UserLoginCommand command) {
        // 校验合作方代理号是否存在
        UserSpecification userSpecification = new UserSpecification(memberTenantRepository);
        userSpecification.isAgentNumber(command.getAgentNumber());

        // 获取领域层
        DomainUserService domainUserService = new DomainUserService();
        UserLoginVO userLoginVO = domainUserService.login(command);
        return userLoginVO;
    }


    /***
     * 查询用户会员信息
     * @param query
     * @return
     */
    @Override
    public MemberInfoVO getMemberInfo(MemberInfoQuery query) {

        // 校验层(校验合作方代理号与外部用户id是否合法)
        UserSpecification userSpecification = new UserSpecification(memberTenantRepository, memberUserRepository);
        userSpecification.isAgentNumberUniqueId(query.getAgentNumber(), query.getUniqueId());

        // 领域层
        DomainUserService domainUserService = new DomainUserService();
        MemberInfoVO memberInfoVO = domainUserService.getMemberInfo(query);

        return memberInfoVO;
    }

}
