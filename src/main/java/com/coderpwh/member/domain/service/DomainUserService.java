package com.coderpwh.member.domain.service;

import com.coderpwh.member.application.assembler.domain.MemberUserDTOAssembler;
import com.coderpwh.member.application.assembler.vo.MemberUserVOAssembler;
import com.coderpwh.member.application.command.MemberInfoQuery;
import com.coderpwh.member.application.command.UserLoginCommand;
import com.coderpwh.member.application.dto.MemberUserDTO;
import com.coderpwh.member.application.vo.MemberCheckRenewalVO;
import com.coderpwh.member.application.vo.MemberInfoVO;
import com.coderpwh.member.application.vo.MemberUserVO;
import com.coderpwh.member.application.vo.UserLoginVO;
import com.coderpwh.member.domain.model.*;
import com.coderpwh.member.domain.util.DateUtils;
import com.coderpwh.member.domain.util.JwtUtils;
import com.coderpwh.member.infrastructure.persistence.entity.MemberCardDO;
import com.coderpwh.member.infrastructure.persistence.entity.MemberPackageDO;
import com.coderpwh.member.infrastructure.persistence.entity.MemberUserDO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Member;
import java.util.Date;
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

    private MemberPackageRepository memberPackageRepository;

    private MemberUserDTOAssembler memberUserDTOAssembler;


    private MemberUserVOAssembler memberUserVOAssembler;


    public DomainUserService() {

    }

    public DomainUserService(MemberPackageRepository memberPackageRepository, MemberCardRepository memberCardRepository) {
        this.memberPackageRepository = memberPackageRepository;
        this.memberCardRepository = memberCardRepository;
    }


    public DomainUserService(MemberUserRepository memberUserRepository, MemberUserDTOAssembler memberUserDTOAssembler, MemberUserVOAssembler memberUserVOAssembler) {
        this.memberUserRepository = memberUserRepository;
        this.memberUserDTOAssembler = memberUserDTOAssembler;
        this.memberUserVOAssembler = memberUserVOAssembler;
    }


    public DomainUserService(MemberUserRepository userRepository, MemberTenantRepository tenantRepository, MemberCardRepository cardRepository, String appSecret) {
        this.memberUserRepository = userRepository;
        this.memberTenantRepository = tenantRepository;
        this.memberCardRepository = cardRepository;
        this.appSecret = appSecret;
    }

    public DomainUserService(MemberUserRepository userRepository, MemberCardRepository cardRepository) {
        this.memberUserRepository = userRepository;
        this.memberCardRepository = cardRepository;
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
        BeanUtils.copyProperties(userLogin, memberInfo);
        memberInfo.setEffectiveTime(DateUtils.getStringByDate(userLogin.getEffectiveTime()));
        memberInfo.setExpirationTime(DateUtils.getStringByDate(userLogin.getExpirationTime()));
        memberInfo.setUserId(memberUser.getId());
        memberInfo.setIsMember(memberUser.getIsMember());
        return memberInfo;
    }


    /***
     *
     * @param MemberUser
     * @param packageCode
     * @return
     */
    public MemberCheckRenewalVO getCheckRenewal(MemberUserDTO memberUser, String packageCode) {

        MemberCheckRenewalVO memberCheckRenewalVO = new MemberCheckRenewalVO();

        MemberPackage memberPackage = memberPackageRepository.selectByPackageCode(memberUser.getTenantId(), packageCode);
        if (Objects.nonNull(memberPackage) && !memberUser.getIsMember()) {
            memberCheckRenewalVO.setIsRenewal(true);
            return memberCheckRenewalVO;
        } else if (Objects.isNull(memberPackage)) {
            memberCheckRenewalVO.setIsRenewal(false);
            return memberCheckRenewalVO;
        }

        MemberCard memberCard = memberCardRepository.selectByUserIdAndTenantId(memberUser.getId(), memberUser.getTenantId());
        if (Objects.isNull(memberCard)) {
            memberCheckRenewalVO.setIsRenewal(true);
            return memberCheckRenewalVO;
        }

        if (memberUser.getIsMember()) {
            Date expirationTime = DateUtils.DateOperationByEndDay(memberCard.getExpirationTime(), memberPackage.getDay());
            //计算用户会员剩余有效天数
            if (null == memberPackage.getMinRenewalInterval() || memberPackage.getMinRenewalInterval() > DateUtils.daysBetween(new Date(), expirationTime)) {
                memberCheckRenewalVO.setIsRenewal(true);
                return memberCheckRenewalVO;
            }
        }
        memberCheckRenewalVO.setIsRenewal(false);
        return memberCheckRenewalVO;


    }


    /***
     * 获取用户信息
     * @param userId
     * @return
     */
    public MemberUserDTO getMemberUser(Long userId) {
        MemberUser memberUser = memberUserRepository.selectByUserId(userId);

        MemberUserDTO memberUserDTO = memberUserDTOAssembler.toDTO(memberUser);

        return memberUserDTO;
    }
}
