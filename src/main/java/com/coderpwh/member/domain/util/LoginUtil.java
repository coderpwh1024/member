package com.coderpwh.member.domain.util;

import com.coderpwh.member.application.dto.MemberUserDTO;
import com.coderpwh.member.application.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author coderpwh
 * @date 2023/5/19 14:04
 */
@Slf4j
@Component
public class LoginUtil {
    private static LoginUtil instance;

    @PostConstruct
    public void init() {
        instance = this;
    }

    @Resource
    private UserService userService;

    @Value("${benefit.APP_SECRET}")
    private String APP_SECRET;


    public static MemberUserDTO loginUser() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        return getUserinfoByToken(request.getHeader("token"));
    }


    public static MemberUserDTO getUserinfoByToken(String query) {
        Long userId = null;
        MemberUserDTO memberUserDTO = null;
        try {
            userId = Long.valueOf(JwtUtils.getUserIdByJwtToken(query, instance.APP_SECRET));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (userId != null) {
            memberUserDTO = instance.userService.getMemberUser(userId);
        }
        return memberUserDTO;
    }
}
