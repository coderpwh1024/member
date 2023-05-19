package com.coderpwh.member.application.service;

import com.coderpwh.member.application.command.MemberInfoQuery;
import com.coderpwh.member.application.command.UserLoginCommand;
import com.coderpwh.member.application.vo.MemberCheckRenewalVO;
import com.coderpwh.member.application.vo.MemberInfoVO;
import com.coderpwh.member.application.vo.UserLoginVO;

/**
 * 用户业务层
 *
 * @author coderpwh
 * @date 2023/5/16 10:26
 */
public interface UserService {


    /***
     * 用户登录
     * @param command
     * @return
     */
    UserLoginVO login(UserLoginCommand command);


    /***
     * 获取会员信息
     * @param query
     * @return
     */
    MemberInfoVO getMemberInfo(MemberInfoQuery query);


    /***
     * 检查用户是否可以续费
     * @param packageCode
     * @return
     */
    MemberCheckRenewalVO getCheckRenewal(String packageCode);


}
