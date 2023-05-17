package com.coderpwh.member.domain.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author coderpwh
 * @date 2023/5/17 17:21
 */
@Data
public class UserLogin implements Serializable {


    /***
     *卡号
     */
    private String cardNumber;


    /**
     * 卡类型
     */
    private String cardType;

    /**
     * 卡类型中文
     */
    private String cardTypeCn;

    /**
     * 是否会员 0-false 1-ture
     */
    private Integer isMember;

    /**
     * 是否新用户
     */
    private Integer isNewUser;


    /**
     * 卡生效时间
     */
    private Date effectiveTime;

    /**
     * 卡过期时间
     */
    private Date expirationTime;


}
