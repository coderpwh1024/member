package com.coderpwh.member.application.service;

import com.coderpwh.member.application.command.UserLoginCommand;
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

}
