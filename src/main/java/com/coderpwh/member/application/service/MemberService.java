package com.coderpwh.member.application.service;

import com.coderpwh.member.application.command.MemberJoinCommand;
import com.coderpwh.member.application.vo.MemberSaveVO;

/**
 * @author coderpwh
 * @date 2023/5/22 11:32
 */
public interface MemberService {


    /***
     * 开通会员
     * @param command
     * @return
     */
    MemberSaveVO saveMember(MemberJoinCommand command);

}
