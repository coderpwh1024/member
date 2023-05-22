package com.coderpwh.member.application.service.impl;

import com.coderpwh.member.application.command.MemberJoinCommand;
import com.coderpwh.member.application.service.MemberService;
import com.coderpwh.member.application.vo.MemberSaveVO;
import org.springframework.stereotype.Service;

/**
 * @author coderpwh
 * @date 2023/5/22 13:40
 */
@Service
public class MemberServiceImpl implements MemberService {


    @Override
    public MemberSaveVO saveMember(MemberJoinCommand command) {
        return null;
    }

}
