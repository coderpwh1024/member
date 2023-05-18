package com.coderpwh.member.web;

import com.coderpwh.member.application.command.CargoBookCommand;
import com.coderpwh.member.application.command.MemberInfoQuery;
import com.coderpwh.member.application.command.UserLoginCommand;
import com.coderpwh.member.application.service.UserService;
import com.coderpwh.member.application.vo.MemberInfoVO;
import com.coderpwh.member.application.vo.UserLoginVO;
import com.coderpwh.member.common.util.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author coderpwh
 * @date 2023/5/15 18:02
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {


    @Resource
    private UserService userService;


    /***
     * 用户登录
     * @param command
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result userLogin(@RequestBody @Valid UserLoginCommand command) {
        UserLoginVO userLoginVo = userService.login(command);
        return Result.ok(userLoginVo);
    }


    /***
     *  查询会员信息
     * @param query
     * @return
     */
    @RequestMapping(value = "/memberInfo", method = RequestMethod.POST)
    public Result getMemberInfo(@RequestBody @Valid MemberInfoQuery query) {
        MemberInfoVO memberInfo = userService.getMemberInfo(query);
        return Result.ok(memberInfo);
    }
}
