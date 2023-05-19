package com.coderpwh.member.application.service.impl;

import com.alibaba.fastjson.JSON;
import com.coderpwh.member.application.command.MemberInfoQuery;
import com.coderpwh.member.application.command.UserLoginCommand;
import com.coderpwh.member.application.service.UserService;
import com.coderpwh.member.application.vo.MemberCheckRenewalVO;
import com.coderpwh.member.application.vo.MemberInfoVO;
import com.coderpwh.member.application.vo.UserLoginVO;
import com.coderpwh.member.domain.model.MemberCardRepository;
import com.coderpwh.member.domain.model.MemberTenantRepository;
import com.coderpwh.member.domain.model.MemberUserRepository;
import com.coderpwh.member.domain.service.DomainUserService;
import com.coderpwh.member.domain.specification.UserSpecification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户业务实现层
 *
 * @author coderpwh
 * @date 2023/5/16 10:26
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {


    @Value("${benefit.APP_SECRET}")
    private String appSecret;


    @Resource
    private MemberTenantRepository memberTenantRepository;

    @Resource
    private MemberUserRepository memberUserRepository;

    @Resource
    private MemberCardRepository cardRepository;


    /***
     * 用户登录
     * @param command
     * @return
     */
    @Override
    public UserLoginVO login(UserLoginCommand command) {
        log.info("用户登录,入参为:{}", JSON.toJSONString(command));

        // 校验合作方代理号是否存在
        UserSpecification userSpecification = new UserSpecification(memberTenantRepository);
        userSpecification.isAgentNumber(command.getAgentNumber());

        log.info("appSecret为:{}", appSecret);
        // 获取领域层
        DomainUserService domainUserService = new DomainUserService(memberUserRepository, memberTenantRepository, cardRepository, appSecret);
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
        log.info("查询用户会员信息,入参为:{}", JSON.toJSONString(query));

        // 校验层(校验合作方代理号与外部用户id是否合法)
        UserSpecification userSpecification = new UserSpecification(memberTenantRepository, memberUserRepository);
        userSpecification.isAgentNumberUniqueId(query.getAgentNumber(), query.getUniqueId());

        // 领域层
        DomainUserService domainUserService = new DomainUserService(memberUserRepository, cardRepository);
        MemberInfoVO memberInfoVO = domainUserService.getMemberInfo(query);

        return memberInfoVO;
    }


    /***
     * 检查用户是否可以续费
     * @param packageCode
     * @return
     */
    @Override
    public MemberCheckRenewalVO getCheckRenewal(String packageCode) {
        return null;
    }


}
