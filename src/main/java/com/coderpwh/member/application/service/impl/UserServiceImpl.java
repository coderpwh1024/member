package com.coderpwh.member.application.service.impl;

import com.coderpwh.member.application.command.UserLoginCommand;
import com.coderpwh.member.application.service.UserService;
import com.coderpwh.member.application.vo.UserLoginVO;
import org.springframework.stereotype.Service;

/**
 * 用户业务实现层
 *
 * @author coderpwh
 * @date 2023/5/16 10:26
 */
@Service
public class UserServiceImpl implements UserService {


    /***
     * 用户登录
     * @param command
     * @return
     */
    @Override
    public UserLoginVO login(UserLoginCommand command) {
        return null;
    }

}
