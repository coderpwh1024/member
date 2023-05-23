package com.coderpwh.member.domain.service;

import com.coderpwh.member.application.command.MemberJoinCommand;
import com.coderpwh.member.application.vo.MemberSaveVO;
import com.coderpwh.member.domain.model.MemberPackage;
import com.coderpwh.member.domain.model.MemberPackageRepository;
import com.coderpwh.member.domain.model.MemberTenant;
import com.coderpwh.member.domain.model.MemberTenantRepository;

/**
 * 会员领域层
 *
 * @author coderpwh
 * @date 2023/5/22 16:08
 */
public class DomainMemberService {


    private MemberPackageRepository memberPackageRepository;


    private MemberTenantRepository memberTenantRepository;


    public DomainMemberService() {

    }


    /***
     * 开通会员
     * @param command
     * @return
     */
    public MemberSaveVO saveMember(MemberJoinCommand command) {

        MemberTenant memberTenant = memberTenantRepository.selectByAgentNumber(command.getAgentNumber());


        MemberPackage memberPackage = memberPackageRepository.selectByAgentNumberAndCode(command.getAgentNumber(), command.getProductType());


        return null;

    }
}
