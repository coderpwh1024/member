package com.coderpwh.member.web;

import com.coderpwh.member.application.command.MemberJoinCommand;
import com.coderpwh.member.application.service.MemberService;
import com.coderpwh.member.common.util.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author coderpwh
 * @date 2023/5/22 11:33
 */

@Slf4j
@RestController
@RequestMapping("/member")
public class MemberController {


    @Resource
    private MemberService memberService;


    /***
     * 开通会员
     * @param command
     * @return
     */
    @RequestMapping(value = "/saveMember", method = RequestMethod.POST)
    public Result saveMember(@RequestBody MemberJoinCommand command) {
        return Result.ok(memberService.saveMember(command));
    }


}
